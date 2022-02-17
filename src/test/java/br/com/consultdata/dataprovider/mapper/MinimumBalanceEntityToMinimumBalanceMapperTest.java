package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.MinimumBalance;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MinimumBalanceEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.MinimumBalanceEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.MinimumBalanceFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class MinimumBalanceToMinimumBalanceEntityMapperTest {

    @InjectMocks
    private MinimumBalanceToMinimumBalanceEntityMapper mapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_minimum_mapper_When_call_convert_to_minimum_entity_Then_return_minimum_entity() {

        final MinimumBalance minimumBalanceMock = Fixture.from(MinimumBalance.class).gimme(MinimumBalanceFixture.VALID);
        final MinimumBalanceEntity minimumBalanceEntityMock = Fixture.from(MinimumBalanceEntity.class).gimme(MinimumBalanceEntityFixture.VALID);

        final MinimumBalanceEntity minimumBalanceEntity = mapper.convert(minimumBalanceMock);

        assertThat(minimumBalanceEntity).isEqualTo(minimumBalanceEntityMock);
    }
}
