package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.BusinessAccount;
import br.com.bestbank.getdataopenbanking.core.model.FeesBusinessAccounts;
import br.com.bestbank.getdataopenbanking.core.model.IncomeRate;
import br.com.bestbank.getdataopenbanking.core.model.ServiceBundle;
import br.com.bestbank.getdataopenbanking.core.model.TermsConditions;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.BusinessAccountEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.FeesBusinessAccountsEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.IncomeRateEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.ServiceBundleEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.TermsConditionsEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.BusinessAccountEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.BusinessAccountFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.FeesBusinessAccountsEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.IncomeRateEntityFixture;
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
class BusinessAccountToBusinessAccountEntityMapperTest {

    @InjectMocks
    private BusinessAccountToBusinessAccountEntityMapper mapper;

    @Mock
    FeesBusinessAccountsToFeesBusinessAccountsEntityMapper feesBusinessAccountsToFeesBusinessAccountsEntityMapper;

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
    void given_a_business_account_mapper_When_call_convert_to_business_account_entity_Then_return_business_account_entity() {

        final ServiceBundleEntity serviceBundleEntityMock = Fixture.from(ServiceBundleEntity.class).gimme(ServiceBundleEntityFixture.VALID);
        final FeesBusinessAccountsEntity feesBusinessAccountEntityMock = Fixture.from(FeesBusinessAccountsEntity.class).gimme(FeesBusinessAccountsEntityFixture.VALID);
        final TermsConditionsEntity termsConditionsEntityMock = Fixture.from(TermsConditionsEntity.class).gimme(TermsConditionsEntityFixture.VALID);
        final IncomeRateEntity incomeRateEntityMock = Fixture.from(IncomeRateEntity.class).gimme(IncomeRateEntityFixture.VALID);

        final BusinessAccount businessAccountMock = Fixture.from(BusinessAccount.class).gimme(BusinessAccountFixture.VALID);
        final BusinessAccountEntity businessAccountEntityMock = Fixture.from(BusinessAccountEntity.class).gimme(BusinessAccountEntityFixture.VALID);

        when(serviceBundleToServiceBundleEntityMapper.convert(any(ServiceBundle.class))).thenReturn(serviceBundleEntityMock);
        when(feesBusinessAccountsToFeesBusinessAccountsEntityMapper.convert(any(FeesBusinessAccounts.class))).thenReturn(feesBusinessAccountEntityMock);
        when(termsConditionsToTermsConditionsEntityMapper.convert(any(TermsConditions.class))).thenReturn(termsConditionsEntityMock);
        when(incomeRateToIncomeRateEntityMapper.convert(any(IncomeRate.class))).thenReturn(incomeRateEntityMock);


        final BusinessAccountEntity businessAccountEntity = mapper.convert(businessAccountMock);

        assertThat(businessAccountEntity).isEqualTo(businessAccountEntityMock);
    }
}
