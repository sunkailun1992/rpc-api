package com.kellen.rpc.memory;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MemoryRpcDTOTest {

    @Test
    void shouldExposeCandidateWriteFields() {
        MemoryCandidateRpcRequest request = new MemoryCandidateRpcRequest();
        request.setCaller("ai-agent");
        request.setPurpose("patient_chat");
        request.setTraceId("trace-1");
        request.setUserId("user-1");
        request.setTenantId("100");
        request.setSourceTenantId("172");
        request.setPatientId("patient-1");
        request.setConversationId("conversation-1");
        request.setSourceType("DOCUMENT_ANALYSIS");
        request.setSourceId("session-1");
        request.setMemoryType("document_summary");
        request.setMemoryKey("document:summary");
        request.setTitle("文档摘要");
        request.setContent("合成文档分析完成");
        request.setFactsJson("{\"score\":1}");
        request.setConfidence(0.9);
        request.setRequiresHumanReview(false);
        request.setAuthorizationScope("patient");
        request.setOccurredAt(LocalDateTime.of(2026, 7, 6, 10, 0));

        MemoryWriteRpcDTO dto = new MemoryWriteRpcDTO();
        dto.setSuccess(true);
        dto.setStatus("ACCEPTED");
        dto.setCandidateId("candidate-1");
        dto.setMemoryId("memory-1");
        dto.setEventId("event-1");
        dto.setMessage("accepted");

        assertInstanceOf(Serializable.class, request);
        assertInstanceOf(Serializable.class, dto);
        assertEquals("ai-agent", request.getCaller());
        assertEquals("172", request.getSourceTenantId());
        assertEquals("patient-1", request.getPatientId());
        assertEquals("document:summary", request.getMemoryKey());
        assertEquals(0.9, request.getConfidence());
        assertTrue(dto.isSuccess());
        assertEquals("ACCEPTED", dto.getStatus());
        assertEquals("memory-1", dto.getMemoryId());
    }

    @Test
    void shouldExposeRetrievalFields() {
        MemoryRetrievalRpcRequest request = new MemoryRetrievalRpcRequest();
        request.setCaller("ai-agent");
        request.setPurpose("patient_analysis");
        request.setTraceId("trace-2");
        request.setSourceTenantId("172");
        request.setPatientId("patient-1");
        request.setConversationId("conversation-1");
        request.setQuery("头痛");
        request.setMaxItems(5);
        request.setMaxTokens(800);
        request.setIncludeArchived(false);
        request.setAllowSensitive(false);

        MemoryRetrievalItemRpcDTO item = new MemoryRetrievalItemRpcDTO();
        item.setMemoryId("memory-1");
        item.setMemoryType("health_signal");
        item.setMemoryKey("symptom:headache");
        item.setTitle("头痛");
        item.setContent("近一周头痛");
        item.setSourceType("CHAT");
        item.setSourceId("conversation-1");
        item.setConfidence(0.82);
        item.setStatus("ACTIVE");
        item.setHitSource("MYSQL_LONG_MEMORY");

        MemoryRetrievalRpcDTO dto = new MemoryRetrievalRpcDTO();
        dto.setEnabled(true);
        dto.setMatched(true);
        dto.setContext("- 头痛：近一周头痛");
        dto.setSourceCount(1);
        dto.setMessage("matched");
        dto.setHitSources(List.of("MYSQL_LONG_MEMORY"));
        dto.setItems(List.of(item));

        assertInstanceOf(Serializable.class, request);
        assertInstanceOf(Serializable.class, item);
        assertInstanceOf(Serializable.class, dto);
        assertEquals("patient_analysis", request.getPurpose());
        assertEquals(5, request.getMaxItems());
        assertTrue(dto.isEnabled());
        assertTrue(dto.isMatched());
        assertEquals("MYSQL_LONG_MEMORY", dto.getItems().get(0).getHitSource());
    }

    @Test
    void shouldExposeGovernanceAndVectorRebuildFields() {
        MemoryGovernanceRpcRequest governance = new MemoryGovernanceRpcRequest();
        governance.setOperation("DELETE");
        governance.setCaller("admin-web");
        governance.setSourceTenantId("172");
        governance.setPatientId("patient-1");
        governance.setMemoryId("memory-1");
        governance.setReason("privacy request");

        MemoryVectorRebuildRpcRequest rebuild = new MemoryVectorRebuildRpcRequest();
        rebuild.setCaller("admin-web");
        rebuild.setTenantId("100");
        rebuild.setSourceTenantId("172");
        rebuild.setPatientId("patient-1");
        rebuild.setReason("model upgrade");

        MemoryGovernanceRpcDTO dto = new MemoryGovernanceRpcDTO();
        dto.setSuccess(true);
        dto.setAffectedCount(3);
        dto.setEventId("event-1");
        dto.setTaskId("task-1");
        dto.setMessage("queued");

        assertInstanceOf(Serializable.class, governance);
        assertInstanceOf(Serializable.class, rebuild);
        assertInstanceOf(Serializable.class, dto);
        assertEquals("DELETE", governance.getOperation());
        assertEquals("model upgrade", rebuild.getReason());
        assertEquals(3, dto.getAffectedCount());
        assertEquals("task-1", dto.getTaskId());
    }
}
