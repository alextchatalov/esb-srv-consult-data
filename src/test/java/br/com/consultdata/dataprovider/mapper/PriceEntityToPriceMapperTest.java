package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Customers;
import br.com.consultdata.core.model.Price;
import br.com.consultdata.dataprovider.entity.CustomersEntity;
import br.com.consultdata.dataprovider.entity.PriceEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.CustomersFixture;
import br.com.consultdata.fixtures.resource.PriceEntityFixture;
import br.com.consultdata.fixtures.resource.PriceFixture;
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
class PriceEntityToPriceMapperTest {

    @InjectMocks
    private PriceEntityToPriceMapper mapper;

    @Mock
    CustomersEntityToCustomersMapper customersEntityToCustomersMapper;


    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_price_entity_mapper_When_call_convert_to_price_Then_return_price() {

        final Customers customersMock = Fixture.from(Customers.class).gimme(CustomersFixture.VALID);
        final Price priceMock = Fixture.from(Price.class).gimme(PriceFixture.VALID);
        final PriceEntity priceEntityMock = Fixture.from(PriceEntity.class).gimme(PriceEntityFixture.VALID);

        when(customersEntityToCustomersMapper.convert(any(CustomersEntity.class))).thenReturn(customersMock);


        final Price price = mapper.convert(priceEntityMock);

        assertThat(price).isEqualTo(priceMock);
    }
}
