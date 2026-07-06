package com.kellen.rpc.memory;

/**
 * AI 记忆候选写入 RPC 契约。
 */
public interface MemoryCandidateRpcService {

    /**
     * 提交候选记忆，由 ai-memory 策略决定是否晋升为长期事实。
     *
     * @param request 候选记忆请求
     * @return 写入结果
     */
    MemoryWriteRpcDTO submitCandidate(MemoryCandidateRpcRequest request);
}
