package com.kellen.rpc.rag;

import java.io.Serializable;

/**
 * RAG 检索 RPC 请求 DTO。
 */
public class RagRetrievalRpcRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String query;

    private String conversationId;

    private String collectionName;

    private Integer topK;

    private Double similarityThreshold;

    private Integer maxContextCharacters;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Integer getTopK() {
        return topK;
    }

    public void setTopK(Integer topK) {
        this.topK = topK;
    }

    public Double getSimilarityThreshold() {
        return similarityThreshold;
    }

    public void setSimilarityThreshold(Double similarityThreshold) {
        this.similarityThreshold = similarityThreshold;
    }

    public Integer getMaxContextCharacters() {
        return maxContextCharacters;
    }

    public void setMaxContextCharacters(Integer maxContextCharacters) {
        this.maxContextCharacters = maxContextCharacters;
    }
}
