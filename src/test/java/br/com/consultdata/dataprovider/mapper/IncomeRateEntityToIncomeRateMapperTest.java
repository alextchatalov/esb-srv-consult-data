package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.IncomeRate;
import br.com.consultdata.dataprovider.entity.IncomeRateEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.IncomeRateEntityFixture;
import br.com.consultdata.fixtures.resource.IncomeRateFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class IncomeRateEntityToIncomeRateMapperTest {

    @InjectMocks
    private IncomeRateEntityToIncomeRateMapper mapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_incomeRate_entity_mapper_When_call_convert_to_incomeRate_Then_return_incomeRate() {

        final IncomeRate incomeRateMock = Fixture.from(IncomeRate.class).gimme(IncomeRateFixture.VALID);
        final IncomeRateEntity incomeRateEntityMock = Fixture.from(IncomeRateEntity.class).gimme(IncomeRateEntityFixture.VALID);

        final IncomeRate incomeRate = mapper.convert(incomeRateEntityMock);

        assertThat(incomeRate).isEqualTo(incomeRateMock);
    }
}
