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

    /**
     * 严格校验开放接口签名：客户端必须明确启用签名，且 HMAC、时钟和单次 nonce 全部通过才返回 true。
     *
     * <p>不支持此方法的旧 provider 必须失败；消费者不能回退到允许可选签名的旧方法。</p>
     */
    boolean verifyRequiredOpenApiSignature(OpenApiSignatureVerifyRpcRequest request);
}
