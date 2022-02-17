package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.FeesPersonalAccounts;
import br.com.consultdata.core.model.IncomeRate;
import br.com.consultdata.core.model.PersonalAccount;
import br.com.consultdata.core.model.ServiceBundle;
import br.com.consultdata.core.model.TermsConditions;
import br.com.consultdata.dataprovider.entity.FeesPersonalAccountsEntity;
import br.com.consultdata.dataprovider.entity.IncomeRateEntity;
import br.com.consultdata.dataprovider.entity.PersonalAccountEntity;
import br.com.consultdata.dataprovider.entity.ServiceBundleEntity;
import br.com.consultdata.dataprovider.entity.TermsConditionsEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.FeesPersonalAccountsFixture;
import br.com.consultdata.fixtures.resource.IncomeRateFixture;
import br.com.consultdata.fixtures.resource.PersonalAccountEntityFixture;
import br.com.consultdata.fixtures.resource.PersonalAccountFixture;
import br.com.consultdata.fixtures.resource.ServiceBundleFixture;
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
class PersonalAccountsEntityToPersonalAccountMapperTest {

    @InjectMocks
    private PersonalAccountsEntityToPersonalAccountMapper mapper;

    @Mock
    FeesPersonalAccountsEntityToFeesPersonalAccountsMapper feesPersonalAccountsEntityToFeesPersonalAccountsMapper;

    @Mock
    ServiceBundleEntityToServiceBundleMapper serviceBundleEntityToServiceBundleMapper;

    @Mock
    TermsConditionsEntityToTermsConditionsMapper termsConditionsEntityToTermsConditionsMapper;

    @Mock
    IncomeRateEntityToIncomeRateMapper incomeRateEntityToIncomeRateMapper;



    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_personal_account_entity_mapper_When_call_convert_to_personal_account_Then_return_personal_account() {

        final ServiceBundle serviceBundleMock = Fixture.from(ServiceBundle.class).gimme(ServiceBundleFixture.VALID);
        final FeesPersonalAccounts feesMock = Fixture.from(FeesPersonalAccounts.class).gimme(FeesPersonalAccountsFixture.VALID);
        final TermsConditions termsConditionsMock = Fixture.from(TermsConditions.class).gimme(TermsConditionsFixture.VALID);
        final IncomeRate incomeRateMock = Fixture.from(IncomeRate.class).gimme(IncomeRateFixture.VALID);

        final PersonalAccount personalAccountMock = Fixture.from(PersonalAccount.class).gimme(PersonalAccountFixture.VALID);
        final PersonalAccountEntity personalAccountEntityMock = Fixture.from(PersonalAccountEntity.class).gimme(PersonalAccountEntityFixture.VALID);

        when(serviceBundleEntityToServiceBundleMapper.convert(any(ServiceBundleEntity.class))).thenReturn(serviceBundleMock);
        when(feesPersonalAccountsEntityToFeesPersonalAccountsMapper.convert(any(FeesPersonalAccountsEntity.class))).thenReturn(feesMock);
        when(termsConditionsEntityToTermsConditionsMapper.convert(any(TermsConditionsEntity.class))).thenReturn(termsConditionsMock);
        when(incomeRateEntityToIncomeRateMapper.convert(any(IncomeRateEntity.class))).thenReturn(incomeRateMock);


        final PersonalAccount personalAccount = mapper.convert(personalAccountEntityMock);

        assertThat(personalAccount).isEqualTo(personalAccountMock);
    }
}
