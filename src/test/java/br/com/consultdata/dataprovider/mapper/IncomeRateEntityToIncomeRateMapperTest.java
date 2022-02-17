package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.IncomeRate;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.IncomeRateEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.IncomeRateEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.IncomeRateFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class IncomeRateToIncomeRateEntityMapperTest {

    @InjectMocks
    private IncomeRateToIncomeRateEntityMapper mapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_incomeRate_mapper_When_call_convert_to_incomeRate_entity_Then_return_incomeRate_entity() {

        final IncomeRate incomeRateMock = Fixture.from(IncomeRate.class).gimme(IncomeRateFixture.VALID);
        final IncomeRateEntity incomeRateEntityMock = Fixture.from(IncomeRateEntity.class).gimme(IncomeRateEntityFixture.VALID);

        final IncomeRateEntity incomeRateEntity = mapper.convert(incomeRateMock);

        assertThat(incomeRateEntity).isEqualTo(incomeRateEntityMock);
    }
}
