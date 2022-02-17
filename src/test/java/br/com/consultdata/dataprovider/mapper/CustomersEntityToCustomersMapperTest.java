package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.Customers;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.CustomersEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.CustomersEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.CustomersFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CustomersToCustomersEntityMapperTest {

    @InjectMocks
    private CustomersToCustomersEntityMapper mapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_customers_mapper_When_call_convert_to_customers_entity_Then_return_customers_entity() {

        final Customers customersMock = Fixture.from(Customers.class).gimme(CustomersFixture.VALID);
        final CustomersEntity customersEntityMock = Fixture.from(CustomersEntity.class).gimme(CustomersEntityFixture.VALID);

        final CustomersEntity customersEntity = mapper.convert(customersMock);

        assertThat(customersEntity).isEqualTo(customersEntityMock);
    }
}
