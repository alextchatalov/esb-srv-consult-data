package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Customers;
import br.com.consultdata.dataprovider.entity.CustomersEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.CustomersEntityFixture;
import br.com.consultdata.fixtures.resource.CustomersFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class CustomersEntityToCustomersMapperTest {

    @InjectMocks
    private CustomersEntityToCustomersMapper mapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_customers_entity_mapper_When_call_convert_to_customers_Then_return_customers() {

        final Customers customersMock = Fixture.from(Customers.class).gimme(CustomersFixture.VALID);
        final CustomersEntity customersEntityMock = Fixture.from(CustomersEntity.class).gimme(CustomersEntityFixture.VALID);

        final Customers customers = mapper.convert(customersEntityMock);

        assertThat(customers).isEqualTo(customersMock);
    }
}
