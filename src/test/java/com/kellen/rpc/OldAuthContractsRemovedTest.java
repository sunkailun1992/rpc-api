package com.kellen.rpc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 第5阶段起身份由 Keycloak 签发，user 服务的旧认证 RPC（会话校验、外部身份、开放接口 HMAC 验签）与其 DTO 已删除，不能再被加载。
 */
class OldAuthContractsRemovedTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "com.kellen.rpc.auth.AuthSessionRpcService",
            "com.kellen.rpc.auth.AuthIdentityRpcService",
            "com.kellen.rpc.auth.AuthOpenApiRpcService",
            "com.kellen.rpc.auth.AuthSessionIdentityRpcDTO",
            "com.kellen.rpc.auth.ExternalIdentityRpcDTO",
            "com.kellen.rpc.auth.ExternalIdentityRpcRequest",
            "com.kellen.rpc.auth.OpenApiSignatureVerifyRpcRequest"
    })
    void oldAuthContractsAreGone(String className) {
        assertThrows(ClassNotFoundException.class, () -> Class.forName(className, false, OldAuthContractsRemovedTest.class.getClassLoader()));
    }
}
