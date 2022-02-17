package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.BusinessAccount;
import br.com.consultdata.core.model.FeesBusinessAccounts;
import br.com.consultdata.core.model.IncomeRate;
import br.com.consultdata.core.model.ServiceBundle;
import br.com.consultdata.core.model.TermsConditions;
import br.com.consultdata.dataprovider.entity.BusinessAccountEntity;
import br.com.consultdata.dataprovider.entity.FeesBusinessAccountsEntity;
import br.com.consultdata.dataprovider.entity.IncomeRateEntity;
import br.com.consultdata.dataprovider.entity.ServiceBundleEntity;
import br.com.consultdata.dataprovider.entity.TermsConditionsEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.BusinessAccountEntityFixture;
import br.com.consultdata.fixtures.resource.BusinessAccountFixture;
import br.com.consultdata.fixtures.resource.FeesBusinessAccountsFixture;
import br.com.consultdata.fixtures.resource.IncomeRateFixture;
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
class BusinessAccountEntityToBusinessAccountMapperTest {

    @InjectMocks
    private BusinessAccountEntityToBusinessAccountMapper mapper;

    @Mock
    FeesBusinessAccountsEntityToFeesBusinessAccountsMapper feesBusinessAccountsEntityToFeesBusinessAccountsMapper;

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
    void given_a_business_account_entity_mapper_When_call_convert_to_business_account_Then_return_business_account() {

        final ServiceBundle serviceBundleMock = Fixture.from(ServiceBundle.class).gimme(ServiceBundleFixture.VALID);
        final FeesBusinessAccounts feesBusinessAccountMock = Fixture.from(FeesBusinessAccounts.class).gimme(FeesBusinessAccountsFixture.VALID);
        final TermsConditions termsConditionsMock = Fixture.from(TermsConditions.class).gimme(TermsConditionsFixture.VALID);
        final IncomeRate incomeRateMock = Fixture.from(IncomeRate.class).gimme(IncomeRateFixture.VALID);

        final BusinessAccount businessAccountMock = Fixture.from(BusinessAccount.class).gimme(BusinessAccountFixture.VALID);
        final BusinessAccountEntity businessAccountEntityMock = Fixture.from(BusinessAccountEntity.class).gimme(BusinessAccountEntityFixture.VALID);

        when(serviceBundleEntityToServiceBundleMapper.convert(any(ServiceBundleEntity.class))).thenReturn(serviceBundleMock);
        when(feesBusinessAccountsEntityToFeesBusinessAccountsMapper.convert(any(FeesBusinessAccountsEntity.class))).thenReturn(feesBusinessAccountMock);
        when(termsConditionsEntityToTermsConditionsMapper.convert(any(TermsConditionsEntity.class))).thenReturn(termsConditionsMock);
        when(incomeRateEntityToIncomeRateMapper.convert(any(IncomeRateEntity.class))).thenReturn(incomeRateMock);


        final BusinessAccount businessAccount = mapper.convert(businessAccountEntityMock);

        assertThat(businessAccount).isEqualTo(businessAccountMock);
    }
}
