package br.com.consultdata.fixtures.resource;

import br.com.consultdata.core.model.Customers;
import br.com.consultdata.core.model.FeesBusinessAccounts;
import br.com.consultdata.core.model.Maximum;
import br.com.consultdata.core.model.Minimum;
import br.com.consultdata.core.model.Price;
import br.com.consultdata.core.model.ServiceBusinessAccounts;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.Arrays;
import java.util.Collections;

public class FeesBusinessAccountsFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(FeesBusinessAccounts.class).addTemplate(VALID, new Rule() {{
            add(FeesBusinessAccounts.Fields.services, Arrays.asList(createServiceBusinessAccounts()));

        }});
    }

    private ServiceBusinessAccounts createServiceBusinessAccounts() {

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