package br.com.bestbank.backbestbank.fixtures.resource;

import br.com.bestbank.getdataopenbanking.dataprovider.entity.CustomersEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MaximumEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MinimumEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PriceEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.ServiceBundleEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.ServiceFromServiceBundleEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.Arrays;

public class ServiceBundleEntityFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(ServiceBundleEntity.class).addTemplate(VALID, new Rule() {{
            add(ServiceBundleEntity.Fields.name, "test");
            add(ServiceBundleEntity.Fields.services, Arrays.asList(createService()));
            add(ServiceBundleEntity.Fields.prices, Arrays.asList(createPrice()));
            add(ServiceBundleEntity.Fields.minimum, createMinimum());
            add(ServiceBundleEntity.Fields.maximum, createMaximum());

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

    private ServiceFromServiceBundleEntity createService() {

        return ServiceFromServiceBundleEntity.builder()
                .code("123")
                .chargingTriggerInfo("test")
                .eventLimitQuantity("1")
                .freeEventQuantity("1")
                .build();
    }

}
