import cats.*
import cats.effect.*
import cats.syntax.all.*
import org.typelevel.otel4s.trace.Tracer
import skunk.*
import skunk.codec.all.*
import skunk.syntax.all.*
import fs2.*

import java.time.OffsetDateTime
import scala.concurrent.duration.*

object Main extends IOApp.Simple {

  given Tracer[IO] = Tracer.noop[IO]

  val sessionPool = Session.pooled[IO](
    host = "localhost",
    port = 5432,
    user = "postgres",
    database = "postgres",
    password = Some("password"),
    max = 1
  )

  def readFromDb(session: Session[IO]): IO[OffsetDateTime] =
    session
      .unique(sql"select current_timestamp".query(timestamptz))
      .flatTap(result => IO.println(s"| $result |"))
      .onError(error => IO.println(s"Error while reading: $error"))

  val run: IO[Unit] = IO.println("Make sure PG is started, then kill it after a few seconds.") >> sessionPool.use { pool =>
    val use =
      // Change this to traverse to "fix" the hanging issue
      List.range(1, 10).parTraverse { _ =>
        pool.use { session =>
          readFromDb(session)
        }
      }
        >> IO.sleep(1.second)

    use.foreverM
  }
}