package com.kellen.rpc.auth;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class AuthSessionContractTest {
    @Test void minimalIdentityIsSerializableAndDoesNotReturnTokens() throws Exception {
        var identity = new AuthSessionIdentityRpcDTO(); identity.setUserId("user-a"); identity.setTenantId("tenant-a");
        var bytes = new ByteArrayOutputStream();
        try (var out = new ObjectOutputStream(bytes)) { out.writeObject(identity); }
        try (var in = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
            var copy = (AuthSessionIdentityRpcDTO) in.readObject();
            assertEquals("user-a", copy.getUserId()); assertEquals("tenant-a", copy.getTenantId());
        }
        assertEquals(java.util.Set.of("userId", "tenantId"), Arrays.stream(AuthSessionIdentityRpcDTO.class.getDeclaredFields())
                .filter(field -> !java.lang.reflect.Modifier.isStatic(field.getModifiers()))
                .map(java.lang.reflect.Field::getName).collect(java.util.stream.Collectors.toSet()));
        assertEquals(AuthSessionIdentityRpcDTO.class,
                AuthSessionRpcService.class.getMethod("resolveAccessIdentity", String.class).getReturnType());
    }
}
