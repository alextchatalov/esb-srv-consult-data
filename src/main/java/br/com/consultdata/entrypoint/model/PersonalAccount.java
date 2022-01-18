package br.com.consultdata.entrypoint.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class PersonalAccount {

    private PersonalAccountsType type;
    private List<ServiceBundle> serviceBundles;
    private List<TransactionMethods> transactionMethods;


}
