package org.example.entity;

import com.alibaba.fastjson2.annotation.JSONField;

import java.time.LocalDateTime;

/**
 * @author mrawa_ltf
 */
public record Todo(@JSONField(name = "id") int id,
                   @JSONField(name = "content") String content,
                   @JSONField(name = "emergency") boolean emergency,
                   @JSONField(name = "deadline") LocalDateTime deadline) {}
