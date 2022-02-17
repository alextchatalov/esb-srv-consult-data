package br.com.consultdata.fixtures.resource;

import br.com.consultdata.core.model.Customers;
import br.com.consultdata.core.model.Maximum;
import br.com.consultdata.core.model.Minimum;
import br.com.consultdata.core.model.OtherService;
import br.com.consultdata.core.model.Price;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.Arrays;

public class OtherServiceFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(OtherService.class).addTemplate(VALID, new Rule() {{
            add(OtherService.Fields.name, "test");
            add(OtherService.Fields.code, "test");
            add(OtherService.Fields.chargingTriggerInfo, "test");
            add(OtherService.Fields.prices, Arrays.asList(createPrice()));
            add(OtherService.Fields.minimum, createMinimum());
            add(OtherService.Fields.maximum, createMaximum());

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
