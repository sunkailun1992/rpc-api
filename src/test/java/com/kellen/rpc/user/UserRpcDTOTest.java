package com.kellen.rpc.user;

import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class UserRpcDTOTest {

    @Test
    void shouldExposeSerializableStableFields() {
        UserRpcDTO dto = new UserRpcDTO();
        dto.setId("user-1");
        dto.setTenantId("tenant-1");
        dto.setUsername("kellen");
        dto.setNickname("Kellen");
        dto.setAdminType("TENANT_ADMIN");
        dto.setAdminTypeDesc("租户管理员");
        dto.setDeptId("dept-1");
        dto.setState(1);
        dto.setStateDesc("正常");
        dto.setVersion(3);

        assertInstanceOf(Serializable.class, dto);
        assertEquals("user-1", dto.getId());
        assertEquals("tenant-1", dto.getTenantId());
        assertEquals("kellen", dto.getUsername());
        assertEquals("Kellen", dto.getNickname());
        assertEquals("TENANT_ADMIN", dto.getAdminType());
        assertEquals("租户管理员", dto.getAdminTypeDesc());
        assertEquals("dept-1", dto.getDeptId());
        assertEquals(1, dto.getState());
        assertEquals("正常", dto.getStateDesc());
        assertEquals(3, dto.getVersion());
    }
}
