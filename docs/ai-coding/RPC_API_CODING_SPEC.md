# RPC 契约编码规范

## 分层

- `rpc-api`：只放接口、DTO、枚举和值对象。
- `utils`：只放 Dubbo 上下文透传、通用配置、通用工具和中间件适配。
- provider 服务：实现 `rpc-api` 接口，使用 `@DubboService` 发布。
- consumer 服务：引用 `rpc-api` 接口，使用 `@DubboReference` 调用。
- gateway/admin-web/小程序：只能通过 HTTP 入口访问，不直接承载 RPC 契约。

## 包名

- 契约统一放在 `com.kellen.rpc.<domain>`。
- 用户中心契约放在 `com.kellen.rpc.user`。
- 新领域按业务边界建包，例如 `com.kellen.rpc.message`、`com.kellen.rpc.ai`。

## 接口规则

- 接口名以业务能力命名，例如 `UserRpcService`。
- 方法参数只放业务必要参数；用户登录信息、租户、链路、版本、流量泳道等横切上下文优先由 Dubbo attachment/filter 透传。
- 如果某个字段本身是业务查询条件，例如显式查询指定租户的数据，可以保留为方法参数。
- 不暴露 provider 内部实体、Mapper、Page 对象、框架请求对象或数据库模型。
- 不在接口上绑定 Spring MVC 注解。

## DTO 规则

- DTO 必须实现 `Serializable` 并声明 `serialVersionUID`。
- DTO 使用普通 getter/setter，不强制依赖 Lombok，降低消费者编译要求。
- DTO 字段默认只新增不删除；删除、改名、改类型都视为破坏性变更。
- 不返回密码、token、密钥、内部风控字段、支付敏感字段或仅 provider 内部使用的状态。
- 枚举跨服务传递优先使用稳定 code，并可补充 desc；不要直接暴露服务内部 enum 类型。

## 兼容性

- 向后兼容：新增 DTO 字段、新增接口方法、新增可空查询条件。
- 高风险：修改字段类型、删除字段、修改方法签名、改变 null 语义、改变枚举 code。
- 破坏性变更必须优先新增方法或新增 DTO；确实不能兼容时升级主版本并同步所有 provider/consumer。

## Provider 规则

- provider 实现类留在业务服务仓库，例如 `user/src/main/java/.../rpc/*Impl.java`。
- provider 使用 `@DubboService` 发布接口。
- provider 内部完成租户、权限、数据范围和脱敏处理。
- provider 不返回内部 Entity，不把异常细节直接透给调用方。

## Consumer 规则

- consumer 使用 `@DubboReference` 注入接口。
- consumer 不复制接口/DTO，不依赖 provider 服务源码。
- 调用超时、check 策略、重试策略要在本服务调用点或 Nacos `dubbo.yaml` 明确。
- 本地验证接口必须标明测试用途，避免误认为正式业务 API。

## 上下文透传

RPC 调用默认分三类上下文：

- 认证上下文：用户 ID、用户名、角色、token 摘要等。
- 租户和数据上下文：租户 ID、数据源 key、Seata XID、请求 ID。
- 流量治理上下文：`release.version`、`traffic.lane`、`canary.tag`、`traffic.weight`。

这些字段应由 `utils` 的 Dubbo 过滤器和网关/前端请求头桥接，不应重复写进每个 RPC 方法签名。
