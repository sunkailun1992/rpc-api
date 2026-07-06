package com.kellen.rpc.memory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * AI 记忆召回 RPC 响应。
 */
public class MemoryRetrievalRpcDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean enabled;

    private boolean matched;

    private String context;

    private Integer sourceCount;

    private String message;

    private List<String> hitSources = new ArrayList<>();

    private List<MemoryRetrievalItemRpcDTO> items = new ArrayList<>();

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

    public List<String> getHitSources() {
        return hitSources;
    }

    public void setHitSources(List<String> hitSources) {
        this.hitSources = hitSources;
    }

    public List<MemoryRetrievalItemRpcDTO> getItems() {
        return items;
    }

    public void setItems(List<MemoryRetrievalItemRpcDTO> items) {
        this.items = items;
    }
}
