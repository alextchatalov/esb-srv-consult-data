package br.com.bestbank.backbestbank.entrypoint.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Bank {

    private String name;
    private List<PersonalAccount> personalAccounts;
}
