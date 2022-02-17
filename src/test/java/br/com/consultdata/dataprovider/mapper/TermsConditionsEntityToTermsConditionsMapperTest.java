package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.MinimumBalance;
import br.com.consultdata.core.model.TermsConditions;
import br.com.consultdata.dataprovider.entity.MinimumBalanceEntity;
import br.com.consultdata.dataprovider.entity.TermsConditionsEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.MinimumBalanceEntityFixture;
import br.com.consultdata.fixtures.resource.TermsConditionsEntityFixture;
import br.com.consultdata.fixtures.resource.TermsConditionsFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TermsConditionsEntityToTermsConditionsMapperTest {

    @InjectMocks
    private TermsConditionsEntityToTermsConditionsMapper mapper;

    @Mock
    MinimumBalanceEntityToMinimumBalanceMapper minimumBalanceEntityToMinimumBalanceMapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_terms_conditions_entity_mapper_When_call_convert_to_terms_conditions_Then_return_terms_conditions() {

        final MinimumBalance minimumBalance = Fixture.from(MinimumBalance.class).gimme(MinimumBalanceEntityFixture.VALID);
        final TermsConditions termsConditionsMock = Fixture.from(TermsConditions.class).gimme(TermsConditionsFixture.VALID);
        final TermsConditionsEntity termsConditionsEntityMock = Fixture.from(TermsConditionsEntity.class).gimme(TermsConditionsEntityFixture.VALID);

        when(minimumBalanceEntityToMinimumBalanceMapper.convert(any(MinimumBalanceEntity.class))).thenReturn(minimumBalance);

        final TermsConditions termsConditions = mapper.convert(termsConditionsEntityMock);

        assertThat(termsConditions).isEqualTo(termsConditionsMock);
    }
}
