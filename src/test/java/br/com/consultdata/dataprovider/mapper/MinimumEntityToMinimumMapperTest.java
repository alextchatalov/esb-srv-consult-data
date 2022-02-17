package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Minimum;
import br.com.consultdata.dataprovider.entity.MinimumEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.MinimumEntityFixture;
import br.com.consultdata.fixtures.resource.MinimumFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class MinimumEntityToMinimumMapperTest {

    @InjectMocks
    private MinimumEntityToMinimumMapper mapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_minimum_entity_mapper_When_call_convert_to_minimum_Then_return_minimum_() {

        final MinimumEntity minimumEntityMock = Fixture.from(MinimumEntity.class).gimme(MinimumEntityFixture.VALID);
        final Minimum minimumMock = Fixture.from(Minimum.class).gimme(MinimumFixture.VALID);

        final Minimum minimum = mapper.convert(minimumEntityMock);

        assertThat(minimum).isEqualTo(minimumMock);
    }
}
