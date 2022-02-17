package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.MinimumBalance;
import br.com.consultdata.dataprovider.entity.MinimumBalanceEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.MinimumBalanceEntityFixture;
import br.com.consultdata.fixtures.resource.MinimumBalanceFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class MinimumBalanceEntityToMinimumBalanceMapperTest {

    @InjectMocks
    private MinimumBalanceEntityToMinimumBalanceMapper mapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_minimum_entity_mapper_When_call_convert_to_minimum_Then_return_minimum() {

        final MinimumBalance minimumBalanceMock = Fixture.from(MinimumBalance.class).gimme(MinimumBalanceFixture.VALID);
        final MinimumBalanceEntity minimumBalanceEntityMock = Fixture.from(MinimumBalanceEntity.class).gimme(MinimumBalanceEntityFixture.VALID);

        final MinimumBalance minimumBalance = mapper.convert(minimumBalanceEntityMock);

        assertThat(minimumBalance).isEqualTo(minimumBalanceMock);
    }
}
