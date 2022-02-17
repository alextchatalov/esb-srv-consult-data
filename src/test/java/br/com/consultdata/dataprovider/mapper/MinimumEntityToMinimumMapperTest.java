package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.Minimum;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MinimumEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.MinimumEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.MinimumFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class MinimumToMinimumEntityMapperTest {

    @InjectMocks
    private MinimumToMinimumEntityMapper mapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_minimum_mapper_When_call_convert_to_minimum__entity_Then_return_minimum__entity() {

        final MinimumEntity minimumEntityMock = Fixture.from(MinimumEntity.class).gimme(MinimumEntityFixture.VALID);
        final Minimum minimumMock = Fixture.from(Minimum.class).gimme(MinimumFixture.VALID);

        final MinimumEntity minimumEntity = mapper.convert(minimumMock);

        assertThat(minimumEntity).isEqualTo(minimumEntityMock);
    }
}
