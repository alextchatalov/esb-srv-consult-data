package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.FeesPersonalAccounts;
import br.com.bestbank.getdataopenbanking.core.model.IncomeRate;
import br.com.bestbank.getdataopenbanking.core.model.PersonalAccount;
import br.com.bestbank.getdataopenbanking.core.model.ServiceBundle;
import br.com.bestbank.getdataopenbanking.core.model.TermsConditions;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.FeesEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.IncomeRateEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PersonalAccountEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.ServiceBundleEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.TermsConditionsEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.FeesEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.IncomeRateEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.PersonalAccountEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.PersonalAccountFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.ServiceBundleEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.TermsConditionsEntityFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PersonalAccountsToPersonalAccountEntityMapperTest {

    @InjectMocks
    private PersonalAccountsToPersonalAccountEntityMapper mapper;

    @Mock
    FeesPersonalAccountsToFeesPersonalAccountsEntityMapper feesPersonalAccountsToFeesPersonalAccountsEntityMapper;

    @Mock
    ServiceBundleToServiceBundleEntityMapper serviceBundleToServiceBundleEntityMapper;

    @Mock
    TermsConditionsToTermsConditionsEntityMapper termsConditionsToTermsConditionsEntityMapper;

    @Mock
    IncomeRateToIncomeRateEntityMapper incomeRateToIncomeRateEntityMapper;



    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_personal_account_mapper_When_call_convert_to_personal_account_entity_Then_return_personal_account_entity() {

        final ServiceBundleEntity serviceBundleEntityMock = Fixture.from(ServiceBundleEntity.class).gimme(ServiceBundleEntityFixture.VALID);
        final FeesEntity feesEntityMock = Fixture.from(FeesEntity.class).gimme(FeesEntityFixture.VALID);
        final TermsConditionsEntity termsConditionsEntityMock = Fixture.from(TermsConditionsEntity.class).gimme(TermsConditionsEntityFixture.VALID);
        final IncomeRateEntity incomeRateEntityMock = Fixture.from(IncomeRateEntity.class).gimme(IncomeRateEntityFixture.VALID);

        final PersonalAccount personalAccountMock = Fixture.from(PersonalAccount.class).gimme(PersonalAccountFixture.VALID);
        final PersonalAccountEntity personalAccountEntityMock = Fixture.from(PersonalAccountEntity.class).gimme(PersonalAccountEntityFixture.VALID);

        when(serviceBundleToServiceBundleEntityMapper.convert(any(ServiceBundle.class))).thenReturn(serviceBundleEntityMock);
        when(feesPersonalAccountsToFeesPersonalAccountsEntityMapper.convert(any(FeesPersonalAccounts.class))).thenReturn(feesEntityMock);
        when(termsConditionsToTermsConditionsEntityMapper.convert(any(TermsConditions.class))).thenReturn(termsConditionsEntityMock);
        when(incomeRateToIncomeRateEntityMapper.convert(any(IncomeRate.class))).thenReturn(incomeRateEntityMock);


        final PersonalAccountEntity personalAccountEntity = mapper.convert(personalAccountMock);

        assertThat(personalAccountEntity).isEqualTo(personalAccountEntityMock);
    }
}
