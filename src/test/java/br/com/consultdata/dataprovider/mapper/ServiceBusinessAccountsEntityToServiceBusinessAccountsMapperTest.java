package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.Maximum;
import br.com.bestbank.getdataopenbanking.core.model.Minimum;
import br.com.bestbank.getdataopenbanking.core.model.Price;
import br.com.bestbank.getdataopenbanking.core.model.ServiceBusinessAccounts;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MaximumEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MinimumEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PriceEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.ServiceBusinessAccountsEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.MaximumEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.MinimumEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.PriceEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.ServiceBusinessAccountsEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.ServiceBusinessAccountsFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ServiceBusinessAccountsToServiceBusinessAccountsEntityMapperTest {

    @InjectMocks
    private ServiceBusinessAccountsToServiceBusinessAccountsEntityMapper mapper;

    @Mock
    PriceToPriceEntityMapper priceToPriceEntityMapper;

    @Mock
    MinimumToMinimumEntityMapper minimumToMinimumEntityMapper;

    @Mock
    MaximumToMaximumEntityMapper maximumToMaximumEntityMapper;



    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_service_business_accounts_mapper_When_call_convert_to_service_business_accounts_entity_Then_return_service_business_accounts_entity() {

        final PriceEntity priceEntityMock = Fixture.from(PriceEntity.class).gimme(PriceEntityFixture.VALID);
        final MinimumEntity minimumEntityMock = Fixture.from(MinimumEntity.class).gimme(MinimumEntityFixture.VALID);
        final MaximumEntity maximumEntityMock = Fixture.from(MaximumEntity.class).gimme(MaximumEntityFixture.VALID);

        final ServiceBusinessAccounts serviceBusinessAccountsMock = Fixture.from(ServiceBusinessAccounts.class).gimme(ServiceBusinessAccountsFixture.VALID);
        final ServiceBusinessAccountsEntity serviceBusinessAccountsEntityAccountsMock = Fixture.from(ServiceBusinessAccountsEntity.class).gimme(ServiceBusinessAccountsEntityFixture.VALID);

        when(priceToPriceEntityMapper.convert(any(Price.class))).thenReturn(priceEntityMock);
        when(minimumToMinimumEntityMapper.convert(any(Minimum.class))).thenReturn(minimumEntityMock);
        when(maximumToMaximumEntityMapper.convert(any(Maximum.class))).thenReturn(maximumEntityMock);


        final ServiceBusinessAccountsEntity serviceBusinessAccountsEntity = mapper.convert(serviceBusinessAccountsMock);

        assertThat(serviceBusinessAccountsEntity).isEqualTo(serviceBusinessAccountsEntityAccountsMock);
    }
}
