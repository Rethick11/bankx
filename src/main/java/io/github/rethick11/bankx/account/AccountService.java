package io.github.rethick11.bankx.account;


import io.github.rethick11.bankx.account.dto.AccountResponse;
import io.github.rethick11.bankx.account.dto.CreateAccountRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse createAccount(CreateAccountRequest payload){

        Account account = new Account(payload.ownerName(), payload.currency());
        Account acc =  accountRepository.save(account);

        return AccountResponse.builder()
                .id(acc.getId())
                .currency(acc.getCurrency())
                .ownerName(acc.getOwnerName())
                .createdAt(acc.getCreatedAt()).build();



    }

    public AccountResponse getAccountById(Long id){

        Optional<Account> account = accountRepository.findById(id);

        Account acc  = account.orElseThrow();


        return AccountResponse.builder()
                .id(acc.getId())
                .currency(acc.getCurrency())
                .ownerName(acc.getOwnerName())
                .createdAt(acc.getCreatedAt()).build();


    }
}
