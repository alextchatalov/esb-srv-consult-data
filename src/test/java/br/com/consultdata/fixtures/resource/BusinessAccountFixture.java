package br.com.bestbank.backbestbank.fixtures.resource;

import br.com.bestbank.getdataopenbanking.core.model.BusinessAccount;
import br.com.bestbank.getdataopenbanking.core.model.Customers;
import br.com.bestbank.getdataopenbanking.core.model.FeesBusinessAccounts;
import br.com.bestbank.getdataopenbanking.core.model.IncomeRate;
import br.com.bestbank.getdataopenbanking.core.model.Maximum;
import br.com.bestbank.getdataopenbanking.core.model.Minimum;
import br.com.bestbank.getdataopenbanking.core.model.MinimumBalance;
import br.com.bestbank.getdataopenbanking.core.model.Price;
import br.com.bestbank.getdataopenbanking.core.model.ServiceBundle;
import br.com.bestbank.getdataopenbanking.core.model.ServiceBusinessAccounts;
import br.com.bestbank.getdataopenbanking.core.model.ServiceFromServiceBundle;
import br.com.bestbank.getdataopenbanking.core.model.TermsConditions;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.Arrays;
import java.util.Collections;

public class BusinessAccountFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(BusinessAccount.class).addTemplate(VALID, new Rule() {{
            add(BusinessAccount.Fields.type, "test");
            add(BusinessAccount.Fields.fees, createFees());
            add(BusinessAccount.Fields.serviceBundles, Arrays.asList(createServiceBundles()));
            add(BusinessAccount.Fields.openingClosingChannels, Arrays.asList("test"));
            add(BusinessAccount.Fields.additionalInfo, "test");
            add(BusinessAccount.Fields.transactionMethods, Arrays.asList("test"));
            add(BusinessAccount.Fields.termsConditions, createTermsConditions());
            add(BusinessAccount.Fields.incomeRate, createIncomeRate());

        }});
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

    private ServiceBundle createServiceBundles() {

        return ServiceBundle.builder()
                .name("test")
                .services(Collections.singletonList(createServiceFromServiceBundle()))
                .prices(Collections.singletonList(createPrice()))
                .minimum(createMinimum())
                .maximum(createMaximum())
                .build();
    }

    private ServiceBusinessAccounts createService() {

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

    private ServiceFromServiceBundle createServiceFromServiceBundle() {

        return ServiceFromServiceBundle.builder()
                .code("123")
                .chargingTriggerInfo("test")
                .eventLimitQuantity("1")
                .freeEventQuantity("1")
                .build();
    }

    private FeesBusinessAccounts createFees() {

        return FeesBusinessAccounts.builder()
                .services(Collections.singletonList(createService()))
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

    private MinimumBalance createMinimumBalance() {
        return MinimumBalance.builder()
                .currency("123")
                .value("123")
                .build();
    }
}