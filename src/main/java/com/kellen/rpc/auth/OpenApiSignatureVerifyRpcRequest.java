package com.kellen.rpc.auth;

import java.io.Serializable;

/**
 * 开放接口签名校验 RPC 请求 DTO。
 */
public class OpenApiSignatureVerifyRpcRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 外部系统编码。
     */
    private String providerCode;

    /**
     * 三方客户端 ID。
     */
    private String clientId;

    /**
     * 签名时间戳，毫秒。
     */
    private String timestamp;

    /**
     * 随机串。
     */
    private String nonce;

    /**
     * HMAC-SHA256 签名。
     */
    private String signature;

    /**
     * 原始请求体。
     */
    private String body;

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
