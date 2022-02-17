package br.com.consultdata.dataprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class CompanyEntity {
    private String name;
    private String cnpjNumber;
    private String urlComplementaryList;
    private List<PersonalAccountEntity> personalAccounts;
    private List<BusinessAccountEntity> businessAccounts;
}