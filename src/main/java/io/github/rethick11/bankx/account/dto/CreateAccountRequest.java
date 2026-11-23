package io.github.rethick11.bankx.account.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateAccountRequest(

        @NotBlank

        String ownerName,

        @Pattern(regexp = "[A-Z]{3}")
        @NotBlank
        String currency) {


}