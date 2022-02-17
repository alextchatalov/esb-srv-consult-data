package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Maximum;
import br.com.consultdata.dataprovider.entity.MaximumEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.MaximumEntityFixture;
import br.com.consultdata.fixtures.resource.MaximumFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class MaximumEntityToMaximumMapperTest {

    @InjectMocks
    private MaximumEntityToMaximumMapper mapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_maximum_mapper_When_call_convert_to_maximum_entity_Then_return_maximum_entity() {

        final Maximum maximumMock = Fixture.from(Maximum.class).gimme(MaximumFixture.VALID);
        final MaximumEntity maximumEntityMock = Fixture.from(MaximumEntity.class).gimme(MaximumEntityFixture.VALID);

        final Maximum maximum = mapper.convert(maximumEntityMock);

        assertThat(maximum).isEqualTo(maximumMock);
    }
}
