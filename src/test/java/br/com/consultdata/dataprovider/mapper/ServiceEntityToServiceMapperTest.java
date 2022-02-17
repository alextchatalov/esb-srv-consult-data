package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.ServiceFromServiceBundle;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.ServiceFromServiceBundleEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.ServiceEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.ServiceFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ServiceToServiceFromServiceBundleEntityMapperTestPersonalAccounts {

    @InjectMocks
    private ServiceToServiceEntityMapper mapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_service_mapper_When_call_convert_to_service_entity_Then_return_service_entity() {

        final ServiceFromServiceBundle serviceFromServiceBundleMock = Fixture.from(ServiceFromServiceBundle.class).gimme(ServiceFixture.VALID);
        final ServiceFromServiceBundleEntity serviceFromServiceBundleEntityMock = Fixture.from(ServiceFromServiceBundleEntity.class).gimme(ServiceEntityFixture.VALID);

        final ServiceFromServiceBundleEntity serviceFromServiceBundleEntity = mapper.convert(serviceFromServiceBundleMock);

        assertThat(serviceFromServiceBundleEntity).isEqualTo(serviceFromServiceBundleEntityMock);
    }
}
