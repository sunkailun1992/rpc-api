# 测试分层规范

## 定位

`rpc-api` 是契约库，不是运行时业务服务。测试重点是契约对象、序列化兼容性、接口签名稳定性和消费者编译兼容。

## 主流分层

- 单元测试：DTO、枚举和值对象，使用 JUnit 5 + AssertJ。
- 契约兼容测试：验证 DTO 字段、Serializable、枚举 code 和默认语义。
- 消费者编译测试：修改契约后必须编译直接 provider 和 consumer。

## assertThat 规则

`assertThat` 是断言工具，可以继续使用。它只能说明被断言对象符合预期，不能替代 provider/consumer 的真实集成验证。

## 不适用项

- 默认不使用 `@SpringBootTest`，因为本仓库没有 Spring Boot 应用。
- 默认不连接 Nacos、数据库、Redis、RabbitMQ 或真实 Dubbo 注册中心。
- 不在本仓库测试 provider 实现或 consumer 调用逻辑。

## 测试稳定性

- 测试结果只能由输入决定，不依赖真实时间、线程调度、连接复用、端口、执行顺序或本机遗留状态。需要时间的逻辑注入 `Clock`；等待异步结果用有总时限的条件等待，不用固定 `Thread.sleep` 赌时序。
- 本地 HTTP 桩服务每个测试独占随机端口，并在 `@AfterEach` 停止。同一测试对同一被测实例请求多次时，桩响应设 `Connection: close`，不依赖 JDK `HttpServer` 的 keep-alive 连接回收时序。更复杂的桩可评估 MockWebServer 或 WireMock，新增依赖按依赖变更处理。
- 连接池、事件循环、静态单例、系统属性等进程级共享状态，不能成为测试之间的隐含依赖；用到时写明隔离方式，不依赖测试类或测试方法的执行顺序。
- 新增或修改涉及网络、并发、超时、流式的测试，合并前本机连续三轮运行该测试类全部通过：`./gradlew test --rerun --tests '<测试类全名>'`。
- 偶发失败按缺陷处理：先查明原因再修，不用自动重试、放宽断言、`@Disabled` 或删除测试换取通过。确需临时禁用时，在注解里写明原因与恢复条件，并在交付说明中列出。
- 本机 macOS 通过不代表 CI 的 Linux 通过；只在一个平台验证过的结论要写明平台。

## 必跑命令

```bash
./gradlew clean test publishToMavenLocal
```

修改契约后，至少同步编译直接 provider 和 consumer。
