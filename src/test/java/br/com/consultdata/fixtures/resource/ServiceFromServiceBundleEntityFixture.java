package br.com.consultdata.fixtures.resource;

import br.com.consultdata.dataprovider.entity.ServiceFromServiceBundleEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ServiceEntityFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(ServiceFromServiceBundleEntity.class).addTemplate(VALID, new Rule() {{
            add(ServiceFromServiceBundleEntity.Fields.code, "123");
            add(ServiceFromServiceBundleEntity.Fields.chargingTriggerInfo, "test");
            add(ServiceFromServiceBundleEntity.Fields.eventLimitQuantity, "1");
            add(ServiceFromServiceBundleEntity.Fields.freeEventQuantity, "1");

        }});
    }

}
