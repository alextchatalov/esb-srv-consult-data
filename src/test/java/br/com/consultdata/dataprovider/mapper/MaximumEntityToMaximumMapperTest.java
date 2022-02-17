package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.Maximum;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MaximumEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.MaximumEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.MaximumFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class MaximumToMaximumEntityMapperTest {

    @InjectMocks
    private MaximumToMaximumEntityMapper mapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_maximum_mapper_When_call_convert_to_maximum_entity_Then_return_maximum_entity() {

        final Maximum maximumMock = Fixture.from(Maximum.class).gimme(MaximumFixture.VALID);
        final MaximumEntity maximumEntityMock = Fixture.from(MaximumEntity.class).gimme(MaximumEntityFixture.VALID);

        final MaximumEntity maximumEntity = mapper.convert(maximumMock);

        assertThat(maximumEntity).isEqualTo(maximumEntityMock);
    }
}
