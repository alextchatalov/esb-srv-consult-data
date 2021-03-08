package br.com.bestbank.backbestbank.core.model;

public enum Category {

    PERSONAL_ACCOUNTS("/personal-accounts"),
    BUSINESS_ACCOUNTS("/business-accounts"),
    PERSONAL_LOANS("/personal-loans"),
    BUSINESS_LOANS("/business-loans"),
    PERSONAL_FINANCINGS("/personal-financings"),
    BUSINESS_FINANCINGS("/business-financings"),
    PERSONAL_INVOICE_FINANCINGS("/personal-invoice-financings"),
    BUSINESS_INVOICE_FINANCINGS("/business-invoice-financings"),
    PERSONAL_CREDIT_CARDS("/personal-credit-cards"),
    BUSINESS_CREDIT_CARDS("/business-credit-cards"),
    PERSONAL_UNARRANGED_ACCOUNT_OVERDRAFT("/personal-unarranged-account-overdraft"),
    BUSINESS_UNARRANGED_ACCOUNT_OVERDRAFT("/business-unarranged-account-overdraft");

    private String entryPoint;
    Category(String entryPoint) {
        this.entryPoint = entryPoint;
    }

    public String getEntryPoint() {
        return entryPoint;
    }
}
