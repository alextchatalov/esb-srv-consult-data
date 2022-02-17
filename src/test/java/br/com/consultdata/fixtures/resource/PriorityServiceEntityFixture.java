package br.com.bestbank.backbestbank.fixtures.resource;

import br.com.bestbank.getdataopenbanking.dataprovider.entity.CustomersEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MaximumEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MinimumEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PriceEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PriorityServiceEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.Arrays;

public class PriorityServiceEntityFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(PriorityServiceEntity.class).addTemplate(VALID, new Rule() {{
            add(PriorityServiceEntity.Fields.name, "test");
            add(PriorityServiceEntity.Fields.code, "test");
            add(PriorityServiceEntity.Fields.chargingTriggerInfo, "test");
            add(PriorityServiceEntity.Fields.prices, Arrays.asList(createPrice()));
            add(PriorityServiceEntity.Fields.minimum, createMinimum());
            add(PriorityServiceEntity.Fields.maximum, createMaximum());

        }});
    }

    private MaximumEntity createMaximum() {

        return MaximumEntity.builder()
                .currency("123")
                .value("123")
                .build();
    }

    private MinimumEntity createMinimum() {

        return MinimumEntity.builder()
                .currency("123")
                .value("123")
                .build();
    }

    private PriceEntity createPrice() {
        return PriceEntity.builder()
                .interval("123")
                .value("123")
                .currency("123")
                .customers(createCustomers())
                .monthlyFee("123")
                .build();
    }

    private CustomersEntity createCustomers() {

        return CustomersEntity.builder()
                .rate("123")
                .build();
    }

}
