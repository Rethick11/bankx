package io.github.rethick11.bankx.account.dto;

import lombok.Builder;

import java.time.Instant;


@Builder
public record AccountResponse(Long id, String ownerName, String currency, Instant createdAt) {
}

//: a record with id, ownerName, currency, createdAt