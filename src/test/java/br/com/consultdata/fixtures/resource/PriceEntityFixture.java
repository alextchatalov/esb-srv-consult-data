package br.com.consultdata.fixtures.resource;

import br.com.consultdata.dataprovider.entity.CustomersEntity;
import br.com.consultdata.dataprovider.entity.PriceEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class PriceEntityFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(PriceEntity.class).addTemplate(VALID, new Rule() {{
            add(PriceEntity.Fields.interval, "123");
            add(PriceEntity.Fields.value, "123");
            add(PriceEntity.Fields.currency, "123");
            add(PriceEntity.Fields.customers, createCustomers());
            add(PriceEntity.Fields.monthlyFee, "123");

        }});
    }

    private CustomersEntity createCustomers() {

        return CustomersEntity.builder()
                .rate("123")
                .build();
    }

}
