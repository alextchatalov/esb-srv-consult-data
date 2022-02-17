package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.ServiceFromServiceBundle;
import br.com.consultdata.dataprovider.entity.ServiceFromServiceBundleEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.ServiceFromServiceBundleEntityFixture;
import br.com.consultdata.fixtures.resource.ServiceFromServiceBundleFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class ServiceEntityToServiceMapperTest {

    @InjectMocks
    private ServiceEntityToServiceMapper mapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_service_entity_mapper_When_call_convert_to_service_Then_return_service() {

        final ServiceFromServiceBundle serviceFromServiceBundleMock = Fixture.from(ServiceFromServiceBundle.class).gimme(ServiceFromServiceBundleFixture.VALID);
        final ServiceFromServiceBundleEntity serviceFromServiceBundleEntityMock = Fixture.from(ServiceFromServiceBundleEntity.class).gimme(ServiceFromServiceBundleEntityFixture.VALID);

        final ServiceFromServiceBundle serviceFromServiceBundle = mapper.convert(serviceFromServiceBundleEntityMock);

        assertThat(serviceFromServiceBundle).isEqualTo(serviceFromServiceBundleMock);
    }
}
