一、什么Arthas
官方地址：https://arthas.aliyun.com/doc/
Arthas 是一款线上监控诊断产品，通过全局视角实时查看应用 load、内存、gc、线程的状态信息，并能在不修改应用代码的情况下，对业务问题进行诊断，包括查看方法调用的出入参、异常，监测方法执行耗时，类加载信息等，大大提升线上问题排查效率。
诞生Arthas的背景
通常，本地开发环境无法访问生产环境。如果在生产环境中遇到问题，则无法使用 IDE 远程调试。更糟糕的是，在生产环境中调试是不可接受的，因为它会暂停所有线程，导致服务暂停。
开发人员可以尝试在测试环境或者预发环境中复现生产环境中的问题。但是，某些问题无法在不同的环境中轻松复现，甚至在重新启动后就消失了。
如果您正在考虑在代码中添加一些日志以帮助解决问题，您将必须经历以下阶段：测试、预发，然后生产。这种方法效率低下，更糟糕的是，该问题可能无法解决，因为一旦 JVM 重新启动，它可能无法复现，如上文所述。
Arthas 旨在解决这些问题。开发人员可以在线解决生产问题。无需 JVM 重启，无需代码更改。 Arthas 作为观察者永远不会暂停正在运行的线程。

二、Arthas能做什么
1. 这个类从哪个 jar 包加载的？为什么会报各种类相关的 Exception？
2. 我改的代码为什么没有执行到？难道是我没 commit？分支搞错了？
3. 遇到问题无法在线上 debug，难道只能通过加日志再重新发布吗？
4. 线上遇到某个用户的数据处理有问题，但线上同样无法 debug，线下无法重现！
5. 是否有一个全局视角来查看系统的运行状况？
6. 有什么办法可以监控到 JVM 的实时运行状态？
7. 怎么快速定位应用的热点，生成火焰图？
8. 怎样直接从 JVM 内查找某个类的实例？

三、Arthas进阶技巧
1. 通过 websocket 连接 Arthas
   https://arthas.aliyun.com/doc/web-console.html
   本地运行arthas之后，访问地址：http://127.0.0.1:8563/。就可以在浏览器操作了，当然如果需要访问线上的Arthas通过切换IP即可。
   [图片]
   本地需要在Docker运行Arthas，https://arthas.aliyun.com/doc/docker.html#%E9%80%9A%E8%BF%87-docker-%E5%BF%AB%E9%80%9F%E5%85%A5%E9%97%A8
2. SpringBoot运行Arthas
   https://arthas.aliyun.com/doc/spring-boot-starter.html
   配置 maven 依赖：
   <dependency>
   <groupId>com.taobao.arthas</groupId>
   <artifactId>arthas-spring-boot-starter</artifactId>
   <version>${arthas.version}</version>
   </dependency>

应用启动后，spring 会启动 arthas，并且 attach 自身进程。
配置信息
agent-id是当前进程的id全局唯一，可以在tunnel上连接到server，可实现一个服务端代理其他业务端，不用每个进程都需要一次页面通过agentId切换即可。tunnel-server是server端的ws地址。
arthas.agent-id=hsehdfsfghhwertyfad
arthas.tunnel-server=ws://47.75.156.201:7777/ws
3. 搭建Tunnel Server
- 下载jar包
  暂时无法在飞书文档外展示此内容
- 启动jar包
  启动日志可以看到tunnel-server的密码，账号是arthas。
  [图片]
  通过http://127.0.0.1:8080/actuator/arthas可以访问到server的信息以及agent的信息。
  {
  "clientConnections": {},
  "version": "3.6.9",
  "properties": {
  "server": {
  "host": "0.0.0.0",
  "port": 7777,
  "ssl": false,
  "path": "/ws",
  "clientConnectHost": "192.168.123.119"
  },
  "embeddedRedis": null,
  "enableDetailPages": false,
  "enableIframeSupport": true
  },
  "agents": {
  "stopping": {
  "host": "192.168.123.119",
  "port": 55851,
  "arthasVersion": "3.6.9"
  }
  }
  }
  最终通过访问server的ip以及agentId即可代理访问到业务端的监控情况了，http://127.0.0.1:8080/
  [图片]
4. IDEA插件形式操作Arthas（高效）
1. https://arthas.aliyun.com/doc/idea-plugin.html
2. https://www.yuque.com/arthas-idea-plugin
   下载IDEA插件
   暂时无法在飞书文档外展示此内容
   IDEA插件可以通过在编辑器的界面快速生成arthas监控命令，减少学习命令的成本
   [图片]
