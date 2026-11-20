package com.kellen.rpc.user.event;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserAccountCreatedEventTest {

    @Test
    void javaSerializationRoundTrip() throws Exception {
        UserAccountCreatedEvent event = new UserAccountCreatedEvent();
        event.setEventId("event-1");
        event.setOccurredAt(Instant.parse("2026-11-20T09:30:00Z"));
        event.setTenantId("tenant-1");
        event.setUserId("user-1");
        event.setUsername("kellen");
        event.setNickname("Kellen");

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(bytes)) {
            out.writeObject(event);
        }
        UserAccountCreatedEvent restored;
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
            restored = (UserAccountCreatedEvent) in.readObject();
        }

        assertEquals("event-1", restored.getEventId());
        assertEquals(Instant.parse("2026-11-20T09:30:00Z"), restored.getOccurredAt());
        assertEquals("tenant-1", restored.getTenantId());
        assertEquals("user-1", restored.getUserId());
        assertEquals("kellen", restored.getUsername());
        assertEquals("Kellen", restored.getNickname());
    }

    @Test
    void hasNoSensitiveFields() {
        List<String> names = Arrays.stream(UserAccountCreatedEvent.class.getDeclaredFields())
                .map(Field::getName)
                .map(name -> name.toLowerCase(Locale.ROOT))
                .toList();

        assertTrue(names.stream().noneMatch(name -> name.contains("password") || name.contains("secret")
                || name.contains("token") || name.contains("authorit")), names.toString());
    }
}
