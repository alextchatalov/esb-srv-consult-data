package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Maximum;
import br.com.consultdata.core.model.Minimum;
import br.com.consultdata.core.model.Price;
import br.com.consultdata.core.model.ServiceBundle;
import br.com.consultdata.core.model.ServiceFromServiceBundle;
import br.com.consultdata.dataprovider.entity.MaximumEntity;
import br.com.consultdata.dataprovider.entity.MinimumEntity;
import br.com.consultdata.dataprovider.entity.PriceEntity;
import br.com.consultdata.dataprovider.entity.ServiceBundleEntity;
import br.com.consultdata.dataprovider.entity.ServiceFromServiceBundleEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.MaximumFixture;
import br.com.consultdata.fixtures.resource.MinimumFixture;
import br.com.consultdata.fixtures.resource.PriceFixture;
import br.com.consultdata.fixtures.resource.ServiceBundleEntityFixture;
import br.com.consultdata.fixtures.resource.ServiceBundleFixture;
import br.com.consultdata.fixtures.resource.ServiceFromServiceBundleFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ServiceBundleEntityToServiceBundleMapperTest {

    @InjectMocks
    private ServiceBundleEntityToServiceBundleMapper mapper;

    @Mock
    PriceEntityToPriceMapper priceEntityToPriceMapper;

    @Mock
    MinimumEntityToMinimumMapper minimumEntityToMinimumMapper;

    @Mock
    MaximumEntityToMaximumMapper maximumEntityToMaximumMapper;

    @Mock
    ServiceEntityToServiceMapper serviceEntityToServiceMapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_service_bundler_entity_mapper_When_call_convert_to_service_bundler_Then_return_service_bundle() {

        final Price priceMock = Fixture.from(Price.class).gimme(PriceFixture.VALID);
        final Minimum minimumMock = Fixture.from(Minimum.class).gimme(MinimumFixture.VALID);
        final Maximum maximumMock = Fixture.from(Maximum.class).gimme(MaximumFixture.VALID);
        final ServiceFromServiceBundle serviceFromServiceBundleMock = Fixture.from(ServiceFromServiceBundle.class).gimme(ServiceFromServiceBundleFixture.VALID);
        final ServiceBundleEntity serviceBundleEntityMock = Fixture.from(ServiceBundleEntity.class).gimme(ServiceBundleEntityFixture.VALID);
        final ServiceBundle serviceBundleMock = Fixture.from(ServiceBundle.class).gimme(ServiceBundleFixture.VALID);


        when(priceEntityToPriceMapper.convert(any(PriceEntity.class))).thenReturn(priceMock);
        when(minimumEntityToMinimumMapper.convert(any(MinimumEntity.class))).thenReturn(minimumMock);
        when(maximumEntityToMaximumMapper.convert(any(MaximumEntity.class))).thenReturn(maximumMock);
        when(serviceEntityToServiceMapper.convert(any(ServiceFromServiceBundleEntity.class))).thenReturn(serviceFromServiceBundleMock);

        final ServiceBundle serviceBundle = mapper.convert(serviceBundleEntityMock);

        assertThat(serviceBundle).isEqualTo(serviceBundleMock);
    }
}
