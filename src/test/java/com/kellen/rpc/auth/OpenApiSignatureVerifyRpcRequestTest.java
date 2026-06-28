package com.kellen.rpc.auth;

import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class OpenApiSignatureVerifyRpcRequestTest {

    @Test
    void shouldExposeSerializableStableFields() {
        OpenApiSignatureVerifyRpcRequest request = new OpenApiSignatureVerifyRpcRequest();
        request.setProviderCode("partner-system");
        request.setClientId("client-1");
        request.setTimestamp("1782440747000");
        request.setNonce("nonce-1");
        request.setSignature("signature-1");
        request.setBody("{\"action\":\"sync\"}");

        assertInstanceOf(Serializable.class, request);
        assertEquals("partner-system", request.getProviderCode());
        assertEquals("client-1", request.getClientId());
        assertEquals("1782440747000", request.getTimestamp());
        assertEquals("nonce-1", request.getNonce());
        assertEquals("signature-1", request.getSignature());
        assertEquals("{\"action\":\"sync\"}", request.getBody());
    }
}
