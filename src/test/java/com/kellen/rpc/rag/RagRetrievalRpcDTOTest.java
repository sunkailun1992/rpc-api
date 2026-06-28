package com.kellen.rpc.rag;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RagRetrievalRpcDTOTest {

    @Test
    void shouldExposeSerializableStableFields() {
        RagRetrievalRpcRequest request = new RagRetrievalRpcRequest();
        request.setQuery("糖尿病饮食建议");
        request.setConversationId("conversation-1");
        request.setCollectionName("medical-kb");
        request.setTopK(3);
        request.setSimilarityThreshold(0.72);
        request.setMaxContextCharacters(4000);

        RagRetrievalChunkRpcDTO chunk = new RagRetrievalChunkRpcDTO();
        chunk.setDocumentId("doc-1");
        chunk.setChunkId("chunk-1");
        chunk.setTitle("饮食原则");
        chunk.setSource("medical-guide");
        chunk.setContent("控制总能量并均衡碳水摄入");
        chunk.setScore(0.88);

        RagRetrievalRpcDTO dto = new RagRetrievalRpcDTO();
        dto.setEnabled(true);
        dto.setMatched(true);
        dto.setContext("控制总能量并均衡碳水摄入");
        dto.setSourceCount(1);
        dto.setMessage("matched");
        dto.setChunks(List.of(chunk));

        assertInstanceOf(Serializable.class, request);
        assertInstanceOf(Serializable.class, dto);
        assertInstanceOf(Serializable.class, chunk);
        assertEquals("糖尿病饮食建议", request.getQuery());
        assertEquals("conversation-1", request.getConversationId());
        assertEquals("medical-kb", request.getCollectionName());
        assertEquals(3, request.getTopK());
        assertEquals(0.72, request.getSimilarityThreshold());
        assertEquals(4000, request.getMaxContextCharacters());
        assertTrue(dto.isEnabled());
        assertTrue(dto.isMatched());
        assertEquals("控制总能量并均衡碳水摄入", dto.getContext());
        assertEquals(1, dto.getSourceCount());
        assertEquals("matched", dto.getMessage());
        assertEquals("doc-1", dto.getChunks().get(0).getDocumentId());
        assertEquals("chunk-1", dto.getChunks().get(0).getChunkId());
        assertEquals("饮食原则", dto.getChunks().get(0).getTitle());
        assertEquals("medical-guide", dto.getChunks().get(0).getSource());
        assertEquals("控制总能量并均衡碳水摄入", dto.getChunks().get(0).getContent());
        assertEquals(0.88, dto.getChunks().get(0).getScore());
    }
}
