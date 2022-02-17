package br.com.consultdata.fixtures.resource;

import br.com.consultdata.core.model.Brand;
import br.com.consultdata.core.model.Company;
import br.com.consultdata.core.model.Customers;
import br.com.consultdata.core.model.FeesPersonalAccounts;
import br.com.consultdata.core.model.IncomeRate;
import br.com.consultdata.core.model.Maximum;
import br.com.consultdata.core.model.Minimum;
import br.com.consultdata.core.model.MinimumBalance;
import br.com.consultdata.core.model.OtherService;
import br.com.consultdata.core.model.PersonalAccount;
import br.com.consultdata.core.model.Price;
import br.com.consultdata.core.model.PriorityService;
import br.com.consultdata.core.model.ServiceBundle;
import br.com.consultdata.core.model.ServiceFromServiceBundle;
import br.com.consultdata.core.model.TermsConditions;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.Collections;

public class BrandFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(Brand.class).addTemplate(VALID, new Rule() {{
            add(Brand.Fields.name, "test");
            add(Brand.Fields.companies, Collections.singletonList(createCompany()));

        }});
    }

    private Company createCompany() {

        return Company.builder()
                .name("test")
                .cnpjNumber("1212424")
                .urlComplementaryList("test")
                .personalAccounts(Collections.singletonList(createPersonalAccount()))
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
                .code("test")
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
