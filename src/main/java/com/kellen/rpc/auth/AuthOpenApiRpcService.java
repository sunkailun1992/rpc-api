package com.kellen.rpc.auth;

/**
 * 统一认证开放接口 Dubbo RPC 契约。
 */
public interface AuthOpenApiRpcService {

    /**
     * 校验外部系统开放接口 HMAC 签名。
     *
     * @param request 开放接口签名校验请求
     */
    void verifyOpenApiSignature(OpenApiSignatureVerifyRpcRequest request);
}
