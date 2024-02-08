1. `docker-compose up -d`
2. `sbt run`
3. `docker-compose stop`

## Logs:

```text
[info] Error while reading: skunk.exception.EofException: 
[info] 🔥  
[info] 🔥  EofException
[info] 🔥  
[info] 🔥    Problem: EOF was reached on the network socket.
[info] 🔥     Detail: Attempt to read 5 byte(s) failed after 0 bytes(s) were read, because
[info] 🔥             the connection had closed.
[info] 🔥       Hint: Discard this session and retry with a new one.
[info] 🔥  
[info] skunk.exception.EofException: EOF was reached on the network socket.
[error] skunk.exception.EofException: 
[error] 🔥  
[error] 🔥  EofException
[error] 🔥  
[error] 🔥    Problem: EOF was reached on the network socket.
[error] 🔥     Detail: Attempt to read 5 byte(s) failed after 0 bytes(s) were read, because
[error] 🔥             the connection had closed.
[error] 🔥       Hint: Discard this session and retry with a new one.
[error] 🔥  
[error] skunk.exception.EofException: EOF was reached on the network socket.
[error]         at skunk.exception.EofException$.apply(EofException.scala:7)
[error]         at skunk.net.BitVectorSocket$$anon$1.readUntilN$$anonfun$1(BitVectorSocket.scala:52)
[error]         at run$ @ Main$.run(Main.scala:13)
[error]         at delay @ fs2.io.net.SocketCompanionPlatform$AsyncSocket.readChunk$$anonfun$1(SocketPlatform.scala:120)
[error]         at async @ fs2.io.net.SocketCompanionPlatform$AsyncSocket.readChunk(SocketPlatform.scala:120)
[error]         at flatMap @ fs2.io.net.SocketCompanionPlatform$BufferedReads.read$$anonfun$1(SocketPlatform.scala:84)
[error]         at delay @ fs2.io.net.SocketCompanionPlatform$BufferedReads.withReadBuffer(SocketPlatform.scala:58)
[error]         at flatten$extension @ skunk.util.Pool$.give$1$$anonfun$1(Pool.scala:120)
```

## Fiber dump:

```text
load: 2.81  cmd: java 89382 running 1.57u 0.10s

 

 

 

 

 

 

 

 

 

 

 
Thread[io-compute-3,5,] (#3): 0 enqueued
Thread[io-compute-2,5,] (#2): 0 enqueued
Thread[io-compute-5,5,] (#5): 0 enqueued
Thread[io-compute-9,5,] (#9): 0 enqueued
Thread[io-compute-7,5,] (#7): 0 enqueued
Thread[io-compute-4,5,] (#4): 0 enqueued
Thread[io-compute-1,5,] (#1): 0 enqueued
Thread[io-compute-0,5,] (#0): 0 enqueued
Thread[io-compute-6,5,] (#6): 0 enqueued
Thread[io-compute-8,5,] (#8): 0 enqueued
 
Global: enqueued 0, foreign 0, waiting 0
[error]  
[error]  
[error]  
[error]  
[error]  
[error]  
[error]  
[error]  
[error]  
[error]  
[error]  
[error] cats.effect.IOFiber@5fa1e30b WAITING
[error]  ╰ main$ @ Main$.main(Main.scala:13)
[error]  
[error] cats.effect.IOFiber@100409ce WAITING
[error]  ├ main$ @ Main$.main(Main.scala:13)
[error]  ├ parTraverse$extension @ Main$.$init$$$anonfun$1$$anonfun$1(Main.scala:39)
[error]  ╰ parTraverse$extension @ Main$.$init$$$anonfun$1$$anonfun$1(Main.scala:39)
[error]  
[error] cats.effect.IOFiber@4fc98abb WAITING
[error]  
[error] cats.effect.IOFiber@258df0ae WAITING
[error]  ├ main$ @ Main$.main(Main.scala:13)
[error]  ├ parTraverse$extension @ Main$.$init$$$anonfun$1$$anonfun$1(Main.scala:39)
[error]  ├ parTraverse$extension @ Main$.$init$$$anonfun$1$$anonfun$1(Main.scala:39)
[error]  ├ parTraverse$extension @ Main$.$init$$$anonfun$1$$anonfun$1(Main.scala:39)
[error]  ├ parTraverse$extension @ Main$.$init$$$anonfun$1$$anonfun$1(Main.scala:39)
[error]  ╰ >> @ Main$.<clinit>(Main.scala:43)
[error]  
[error] cats.effect.IOFiber@43de1aaa WAITING
[error]  ├ flatMap @ skunk.util.Pool$.$anonfun$1(Pool.scala:110)
[error]  ├ onError @ skunk.util.Pool$.give$1$$anonfun$1$$anonfun$1(Pool.scala:102)
[error]  ├ flatMap @ skunk.util.Pool$.$anonfun$1(Pool.scala:110)
[error]  ├ modify @ skunk.util.Pool$.give$1$$anonfun$1(Pool.scala:120)
[error]  ├ flatten$extension @ skunk.util.Pool$.give$1$$anonfun$1(Pool.scala:120)
[error]  ╰ flatModify @ skunk.util.Pool$.give$1$$anonfun$1$$anonfun$1(Pool.scala:113)
[error]  
[error] Thread[io-compute-6,5,main] (#6): 0 enqueued
[error] Thread[io-compute-9,5,main] (#9): 0 enqueued
[error] Thread[io-compute-5,5,main] (#5): 0 enqueued
[error] Thread[io-compute-0,5,main] (#0): 0 enqueued
[error] Thread[io-compute-7,5,main] (#7): 0 enqueued
[error] Thread[io-compute-1,5,main] (#1): 0 enqueued
[error] Thread[io-compute-3,5,main] (#3): 0 enqueued
[error] Thread[io-compute-4,5,main] (#4): 0 enqueued
[error] Thread[io-compute-8,5,main] (#8): 0 enqueued
[error] Thread[io-compute-2,5,main] (#2): 0 enqueued
[error]  
[error] Global: enqueued 0, foreign 0, waiting 5
```