package br.com.bestbank.backbestbank.fixtures.resource;

import br.com.bestbank.getdataopenbanking.core.model.Customers;
import br.com.bestbank.getdataopenbanking.core.model.Maximum;
import br.com.bestbank.getdataopenbanking.core.model.Minimum;
import br.com.bestbank.getdataopenbanking.core.model.Price;
import br.com.bestbank.getdataopenbanking.core.model.PriorityService;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.Arrays;

public class PriorityServiceFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(PriorityService.class).addTemplate(VALID, new Rule() {{
            add(PriorityService.Fields.name, "test");
            add(PriorityService.Fields.code, "test");
            add(PriorityService.Fields.chargingTriggerInfo, "test");
            add(PriorityService.Fields.prices, Arrays.asList(createPrice()));
            add(PriorityService.Fields.minimum, createMinimum());
            add(PriorityService.Fields.maximum, createMaximum());

        }});
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
