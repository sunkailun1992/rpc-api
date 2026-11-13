# 版本管理规范

## 基线

```gradle
group = 'com'
version = '1.0.0'
```

`rpc-api` 发布坐标固定为 `com:rpc-api:<version>`。

个人公共制品固定使用 `com:rpc-api` 和 `com:utils`；美联公共制品使用 `com.kellen:rpc-api` 和 `com.kellen:utils`。同一个远程 Maven 地址不代表同一个制品，两边按 group 隔离并独立递增版本。同步代码时不得把美联坐标或依赖覆盖到个人项目，Java package `com.kellen.*` 不随 Maven group 改名。

## 递增规则

- 补丁版本：兼容新增接口、兼容新增 DTO 字段、文档外的构建修复，例如 `1.0.0 -> 1.0.1`。
- 次版本：新增一组稳定领域契约或大规模兼容能力，例如 `1.4.9 -> 1.5.0`。
- 主版本：删除字段、改方法签名、改字段类型、改变核心语义等破坏性变更，例如 `1.x.x -> 2.0.0`。

补丁版本递增到 `.9` 后，再进入下一个次版本：`1.4.9 -> 1.5.0`。

## 修改门禁

- 修改生产源码或构建脚本时，同一批未提交改动只提升一次版本。
- 纯文档、注释、README、AI 规范变更不强制提升制品版本。
- 契约版本提升后，直接 provider 和 consumer 必须同步依赖新版本并通过编译。
- 不允许服务项目继续依赖旧版本，同时在本仓库手工复制新接口。

## 发布

- 本地验证：`./gradlew publishToMavenLocal`。
- CI 验证：消费者 workflow 先 checkout `rpc-api` 并发布到 Maven Local，再编译消费者。
- 正式制品：执行 `./gradlew publish` 发布到统一阿里云 Maven Release 仓库，必须保证 Git tag、`build.gradle` 版本和远程 Maven 制品一致。

## 修改版本前核对

修改版本前 fetch 并核对构建文件、远端 main、在途功能分支、tag 与已发布制品占用，按本文件规则选择未占用且递增的精确版本；同一批未提交改动只升一次。历史记录、已发布 tag 和同版私库制品不重写或覆盖。纯规范文档不提升业务/公共库版本，也不为文档推送重复发布旧制品；若本仓已接入自动检查，不得绕过；未接入时不宣称已有该能力。

远程发布从已验证的确定 commit 构建，读回 POM、JAR、sourcesJar、javadocJar 与 Maven metadata，核对坐标、版本和 SHA-256；消费者精确版本解析另行验证。Git 推送成功、Maven 发布成功与消费者构建通过分开记录；失败时写明已完成与待处理项。个人公共库保持 `com:utils` / `com:rpc-api`，不恢复公司 `com.kellen` 坐标。
