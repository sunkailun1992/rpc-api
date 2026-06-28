package com.kellen.rpc.auth;

import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ExternalIdentityRpcDTOTest {

    @Test
    void shouldExposeSerializableStableFields() {
        ExternalIdentityRpcDTO dto = new ExternalIdentityRpcDTO();
        dto.setProviderCode("partner-system");
        dto.setExternalTenantId("tenant-out");
        dto.setExternalUserId("user-out");
        dto.setExternalPatientId("patient-out");
        dto.setLocalTenantId("tenant-local");
        dto.setLocalUserId("user-local");
        dto.setSubjectType("PATIENT");
        dto.setDisplayName("张三");
        dto.setState(1);

        assertInstanceOf(Serializable.class, dto);
        assertEquals("partner-system", dto.getProviderCode());
        assertEquals("tenant-out", dto.getExternalTenantId());
        assertEquals("user-out", dto.getExternalUserId());
        assertEquals("patient-out", dto.getExternalPatientId());
        assertEquals("tenant-local", dto.getLocalTenantId());
        assertEquals("user-local", dto.getLocalUserId());
        assertEquals("PATIENT", dto.getSubjectType());
        assertEquals("张三", dto.getDisplayName());
        assertEquals(1, dto.getState());
    }
}
