package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.BusinessAccount;
import br.com.bestbank.getdataopenbanking.core.model.Company;
import br.com.bestbank.getdataopenbanking.core.model.PersonalAccount;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.BusinessAccountEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.CompanyEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PersonalAccountEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.BusinessAccountEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.CompanyEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.CompanyFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.PersonalAccountEntityFixture;
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
class CompanyToCompanyEntityMapperTest {

    @InjectMocks
    private CompanyToCompanyEntityMapper mapper;

    @Mock
    PersonalAccountsToPersonalAccountEntityMapper personalAccountsToPersonalAccountEntityMapper;

    @Mock
    BusinessAccountToBusinessAccountEntityMapper businessAccountToBusinessAccountEntityMapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_company_mapper_When_call_convert_to_company_entity_Then_return_company_entity() {

        final Company companyMock = Fixture.from(Company.class).gimme(CompanyFixture.VALID);
        final CompanyEntity companyEntityMock = Fixture.from(CompanyEntity.class).gimme(CompanyEntityFixture.VALID);
        final PersonalAccountEntity personalEntityMock = Fixture.from(PersonalAccountEntity.class).gimme(PersonalAccountEntityFixture.VALID);
        final BusinessAccountEntity businessEntityMock = Fixture.from(BusinessAccountEntity.class).gimme(BusinessAccountEntityFixture.VALID);

        when(personalAccountsToPersonalAccountEntityMapper.convert(any(PersonalAccount.class))).thenReturn(personalEntityMock);
        when(businessAccountToBusinessAccountEntityMapper.convert(any(BusinessAccount.class))).thenReturn(businessEntityMock);

        final CompanyEntity companyEntity = mapper.convert(companyMock);

        assertThat(companyEntity).isEqualTo(companyEntityMock);
    }
}
