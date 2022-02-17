package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.Customers;
import br.com.bestbank.getdataopenbanking.core.model.Price;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.CustomersEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PriceEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.CustomersEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.PriceEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.PriceFixture;
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
class PriceToPriceEntityMapperTest {

    @InjectMocks
    private PriceToPriceEntityMapper mapper;

    @Mock
    CustomersToCustomersEntityMapper customersToCustomersEntityMapper;


    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_price_mapper_When_call_convert_to_price_entity_Then_return_price_entity() {

        final CustomersEntity customersEntityMock = Fixture.from(CustomersEntity.class).gimme(CustomersEntityFixture.VALID);
        final Price priceMock = Fixture.from(Price.class).gimme(PriceFixture.VALID);
        final PriceEntity priceEntityMock = Fixture.from(PriceEntity.class).gimme(PriceEntityFixture.VALID);

        when(customersToCustomersEntityMapper.convert(any(Customers.class))).thenReturn(customersEntityMock);


        final PriceEntity priceEntity = mapper.convert(priceMock);

        assertThat(priceEntity).isEqualTo(priceEntityMock);
    }
}
