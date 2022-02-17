package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.BusinessAccount;
import br.com.consultdata.core.model.Company;
import br.com.consultdata.core.model.PersonalAccount;
import br.com.consultdata.dataprovider.entity.BusinessAccountEntity;
import br.com.consultdata.dataprovider.entity.CompanyEntity;
import br.com.consultdata.dataprovider.entity.PersonalAccountEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.BusinessAccountFixture;
import br.com.consultdata.fixtures.resource.CompanyEntityFixture;
import br.com.consultdata.fixtures.resource.CompanyFixture;
import br.com.consultdata.fixtures.resource.PersonalAccountFixture;
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
class CompanyEntityToCompanyMapperTest {

    @InjectMocks
    private CompanyEntityToCompanyMapper mapper;

    @Mock
    PersonalAccountsEntityToPersonalAccountMapper personalAccountsEntityToPersonalAccountMapper;

    @Mock
    BusinessAccountEntityToBusinessAccountMapper businessAccountEntityToBusinessAccountMapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_company_entity_mapper_When_call_convert_to_company_Then_return_company() {

        final Company companyMock = Fixture.from(Company.class).gimme(CompanyFixture.VALID);
        final CompanyEntity companyEntityMock = Fixture.from(CompanyEntity.class).gimme(CompanyEntityFixture.VALID);
        final PersonalAccount personalMock = Fixture.from(PersonalAccount.class).gimme(PersonalAccountFixture.VALID);
        final BusinessAccount businessMock = Fixture.from(BusinessAccount.class).gimme(BusinessAccountFixture.VALID);

        when(personalAccountsEntityToPersonalAccountMapper.convert(any(PersonalAccountEntity.class))).thenReturn(personalMock);
        when(businessAccountEntityToBusinessAccountMapper.convert(any(BusinessAccountEntity.class))).thenReturn(businessMock);

        final Company company = mapper.convert(companyEntityMock);

        assertThat(company).isEqualTo(companyMock);
    }
}
