package br.com.bestbank.backbestbank.fixtures.resource;

import br.com.bestbank.getdataopenbanking.core.model.BusinessAccount;
import br.com.bestbank.getdataopenbanking.core.model.Company;
import br.com.bestbank.getdataopenbanking.core.model.Customers;
import br.com.bestbank.getdataopenbanking.core.model.FeesBusinessAccounts;
import br.com.bestbank.getdataopenbanking.core.model.FeesPersonalAccounts;
import br.com.bestbank.getdataopenbanking.core.model.IncomeRate;
import br.com.bestbank.getdataopenbanking.core.model.Maximum;
import br.com.bestbank.getdataopenbanking.core.model.Minimum;
import br.com.bestbank.getdataopenbanking.core.model.MinimumBalance;
import br.com.bestbank.getdataopenbanking.core.model.OtherService;
import br.com.bestbank.getdataopenbanking.core.model.PersonalAccount;
import br.com.bestbank.getdataopenbanking.core.model.Price;
import br.com.bestbank.getdataopenbanking.core.model.PriorityService;
import br.com.bestbank.getdataopenbanking.core.model.ServiceBundle;
import br.com.bestbank.getdataopenbanking.core.model.ServiceBusinessAccounts;
import br.com.bestbank.getdataopenbanking.core.model.ServiceFromServiceBundle;
import br.com.bestbank.getdataopenbanking.core.model.TermsConditions;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.Arrays;
import java.util.Collections;

public class CompanyFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(Company.class).addTemplate(VALID, new Rule() {{
            add(Company.Fields.name, "test");
            add(Company.Fields.cnpjNumber, "1244441");
            add(Company.Fields.urlComplementaryList, "test");
            add(Company.Fields.personalAccounts, Arrays.asList(createPersonalAccount()));
            add(Company.Fields.businessAccounts, Arrays.asList(createBusinessAccount()));

        }});
    }

    private BusinessAccount createBusinessAccount() {
        return BusinessAccount.builder()
                .type("test")
                .fees(createFeesBusiness())
                .serviceBundles(Collections.singletonList(createServiceBundles()))
                .openingClosingChannels(Collections.singletonList("test"))
                .additionalInfo("test")
                .transactionMethods(Collections.singletonList("test"))
                .termsConditions(createTermsConditions())
                .incomeRate(createIncomeRate())
                .build();
    }

    private FeesBusinessAccounts createFeesBusiness() {

        return FeesBusinessAccounts.builder()
                .services(Collections.singletonList(createServiceBusiness()))
                .build();
    }

    private ServiceBusinessAccounts createServiceBusiness() {

        return ServiceBusinessAccounts.builder()
                .name("test")
                .code("123")
                .chargingTriggerInfo("test")
                .prices(Collections.singletonList(createPrice()))
                .minimum(createMinimum())
                .maximum(createMaximum())
                .eventLimitQuantity("1")
                .freeEventQuantity("1")
                .build();
    }

    private PersonalAccount createPersonalAccount() {

        return PersonalAccount.builder()
                .type("test")
                .fees(createFees())
                .serviceBundles(Collections.singletonList(createServiceBundles()))
                .openingClosingChannels(Collections.singletonList("test"))
                .additionalInfo("test")
                .transactionMethods(Collections.singletonList("test"))
                .termsConditions(createTermsConditions())
                .incomeRate(Collections.singletonList(createIncomeRate()))
                .build();
    }
    
    private IncomeRate createIncomeRate() {

        return IncomeRate.builder()
                .savingAccount("123")
                .prepaidPaymentAccount("123")
                .build();
    }

    private TermsConditions createTermsConditions() {

        return TermsConditions.builder()
                .minimumBalance(createMinimumBalance())
                .elegibilityCriteriaInfo("test")
                .closingProcessInfo("1")
                .build();
    }

    private MinimumBalance createMinimumBalance() {
        return MinimumBalance.builder()
                .currency("123")
                .value("123")
                .build();
    }

    private ServiceBundle createServiceBundles() {

        return ServiceBundle.builder()
                .name("test")
                .services(Collections.singletonList(createService()))
                .prices(Collections.singletonList(createPrice()))
                .minimum(createMinimum())
                .maximum(createMaximum())
                .build();
    }

    private ServiceFromServiceBundle createService() {

        return ServiceFromServiceBundle.builder()
                .code("123")
                .chargingTriggerInfo("test")
                .eventLimitQuantity("1")
                .freeEventQuantity("1")
                .build();
    }


    private FeesPersonalAccounts createFees() {

        return FeesPersonalAccounts.builder()
                .priorityServices(Collections.singletonList(createPriorityService()))
                .otherServices(Collections.singletonList(createOtherService()))
                .build();
    }

    private OtherService createOtherService() {

        return OtherService.builder()
                .name("test")
                .code("test")
                .chargingTriggerInfo("test")
                .prices(Collections.singletonList(createPrice()))
                .minimum(createMinimum())
                .maximum(createMaximum())
                .build();
    }

    private PriorityService createPriorityService() {
        return PriorityService.builder()
                .name("test")
                .code("test")
                .chargingTriggerInfo("test")
                .prices(Collections.singletonList(createPrice()))
                .minimum(createMinimum())
                .maximum(createMaximum())
                .build();
    }

    private Maximum createMaximum() {

        return Maximum.builder()
                .currency("123")
                .value("123")
                .build();
    }

    private Minimum createMinimum() {

        return Minimum.builder()
                .currency("123")
                .value("123")
                .build();
    }

    private Price createPrice() {
        return Price.builder()
                .interval("123")
                .value("123")
                .currency("123")
                .customers(createCustomers())
                .monthlyFee("123")
                .build();
    }

    private Customers createCustomers() {

        return Customers.builder()
                .rate("123")
                .build();
    }

}
