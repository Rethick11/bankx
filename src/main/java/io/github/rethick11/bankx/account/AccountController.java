package io.github.rethick11.bankx.account;


import io.github.rethick11.bankx.account.dto.AccountResponse;
import io.github.rethick11.bankx.account.dto.CreateAccountRequest;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest payload) {

        AccountResponse res =  accountService.createAccount(payload);

        return  ResponseEntity
                .status(201)
                .body(res);

    }


    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccountById(@PathVariable Long id){

        AccountResponse res = accountService.getAccountById(id);

       return  ResponseEntity
               .status(200)
               .body(res);

    }




}