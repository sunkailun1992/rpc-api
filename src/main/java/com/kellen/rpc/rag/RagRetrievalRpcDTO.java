package com.kellen.rpc.rag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * RAG 检索 RPC 响应 DTO。
 */
public class RagRetrievalRpcDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean enabled;

    private boolean matched;

    private String context;

    private Integer sourceCount;

    private String message;

    private List<RagRetrievalChunkRpcDTO> chunks = new ArrayList<>();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getSourceCount() {
        return sourceCount;
    }

    public void setSourceCount(Integer sourceCount) {
        this.sourceCount = sourceCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<RagRetrievalChunkRpcDTO> getChunks() {
        return chunks;
    }

    public void setChunks(List<RagRetrievalChunkRpcDTO> chunks) {
        this.chunks = chunks;
    }
}
