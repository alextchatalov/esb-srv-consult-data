package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Maximum;
import br.com.consultdata.core.model.Minimum;
import br.com.consultdata.core.model.Price;
import br.com.consultdata.core.model.ServiceBusinessAccounts;
import br.com.consultdata.dataprovider.entity.MaximumEntity;
import br.com.consultdata.dataprovider.entity.MinimumEntity;
import br.com.consultdata.dataprovider.entity.PriceEntity;
import br.com.consultdata.dataprovider.entity.ServiceBusinessAccountsEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.MaximumFixture;
import br.com.consultdata.fixtures.resource.MinimumFixture;
import br.com.consultdata.fixtures.resource.PriceFixture;
import br.com.consultdata.fixtures.resource.ServiceBusinessAccountsEntityFixture;
import br.com.consultdata.fixtures.resource.ServiceBusinessAccountsFixture;
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
class ServiceBusinessAccountsEntityToServiceBusinessAccountsMapperTest {

    @InjectMocks
    private ServiceBusinessAccountsEntityToServiceBusinessAccountsMapper mapper;

    @Mock
    PriceEntityToPriceMapper priceEntityToPriceMapper;

    @Mock
    MinimumEntityToMinimumMapper minimumEntityToMinimumMapper;

    @Mock
    MaximumEntityToMaximumMapper maximumEntityToMaximumMapper;



    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_service_business_accounts_entity_mapper_When_call_convert_to_service_business_accounts_Then_return_service_business_accounts() {

        final Price priceMock = Fixture.from(Price.class).gimme(PriceFixture.VALID);
        final Minimum minimumMock = Fixture.from(Minimum.class).gimme(MinimumFixture.VALID);
        final Maximum maximumMock = Fixture.from(Maximum.class).gimme(MaximumFixture.VALID);

        final ServiceBusinessAccounts serviceBusinessAccountsMock = Fixture.from(ServiceBusinessAccounts.class).gimme(ServiceBusinessAccountsFixture.VALID);
        final ServiceBusinessAccountsEntity serviceBusinessAccountsEntityAccountsMock = Fixture.from(ServiceBusinessAccountsEntity.class).gimme(ServiceBusinessAccountsEntityFixture.VALID);

        when(priceEntityToPriceMapper.convert(any(PriceEntity.class))).thenReturn(priceMock);
        when(minimumEntityToMinimumMapper.convert(any(MinimumEntity.class))).thenReturn(minimumMock);
        when(maximumEntityToMaximumMapper.convert(any(MaximumEntity.class))).thenReturn(maximumMock);


        final ServiceBusinessAccounts serviceBusinessAccounts = mapper.convert(serviceBusinessAccountsEntityAccountsMock);

        assertThat(serviceBusinessAccounts).isEqualTo(serviceBusinessAccountsMock);
    }
}
