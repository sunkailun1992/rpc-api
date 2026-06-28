package com.kellen.rpc.rag;

import java.io.Serializable;

/**
 * RAG 检索命中的知识片段 RPC DTO。
 */
public class RagRetrievalChunkRpcDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String documentId;

    private String chunkId;

    private String title;

    private String source;

    private String content;

    private Double score;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getChunkId() {
        return chunkId;
    }

    public void setChunkId(String chunkId) {
        this.chunkId = chunkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
