package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Company;
import br.com.consultdata.core.model.Data;
import br.com.consultdata.dataprovider.entity.CompanyEntity;
import br.com.consultdata.dataprovider.entity.DataEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.CompanyFixture;
import br.com.consultdata.fixtures.resource.DataEntityFixture;
import br.com.consultdata.fixtures.resource.DataFixture;
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
class DataEntityToDataMapperTest {

    @InjectMocks
    private DataEntityToDataMapper mapper;

    @Mock
    CompanyEntityToCompanyMapper companyEntityToCompanyMapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_data_mapper_When_call_convert_to_data_entity_Then_return_data_entity() {

        final Data dataMock = Fixture.from(Data.class).gimme(DataFixture.VALID);
        final DataEntity dataEntityMock = Fixture.from(DataEntity.class).gimme(DataEntityFixture.VALID);
        final Company companyMock = Fixture.from(Company.class).gimme(CompanyFixture.VALID);

        when(companyEntityToCompanyMapper.convert(any(CompanyEntity.class))).thenReturn(companyMock);

        final Data data = mapper.convert(dataEntityMock);

        assertThat(data).isEqualTo(dataMock);
    }
}
