package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.FeesBusinessAccounts;
import br.com.consultdata.core.model.ServiceBusinessAccounts;
import br.com.consultdata.dataprovider.entity.FeesBusinessAccountsEntity;
import br.com.consultdata.dataprovider.entity.ServiceBusinessAccountsEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.FeesBusinessAccountsEntityFixture;
import br.com.consultdata.fixtures.resource.FeesBusinessAccountsFixture;
import br.com.consultdata.fixtures.resource.ServiceBusinessAccountsFixture;
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
class FeesBusinessAccountsEntityToFeesBusinessAccountsMapperTest {

    @InjectMocks
    private FeesBusinessAccountsEntityToFeesBusinessAccountsMapper mapper;

    @Mock
    ServiceBusinessAccountsEntityToServiceBusinessAccountsMapper serviceBusinessAccountsEntityToServiceBusinessAccountsMapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_feesBusiness_accounts_entity_mapper_When_call_convert_to_feesBusiness_accounts_Then_return_feesBusiness_accounts() {

        final ServiceBusinessAccounts serviceBusinessAccountsMock = Fixture.from(ServiceBusinessAccounts.class).gimme(ServiceBusinessAccountsFixture.VALID);

        final FeesBusinessAccounts feesBusinessAccountsMock = Fixture.from(FeesBusinessAccounts.class).gimme(FeesBusinessAccountsFixture.VALID);
        final FeesBusinessAccountsEntity feesBusinessAccountsEntityMock = Fixture.from(FeesBusinessAccountsEntity.class).gimme(FeesBusinessAccountsEntityFixture.VALID);

        when(serviceBusinessAccountsEntityToServiceBusinessAccountsMapper.convert(any(ServiceBusinessAccountsEntity.class))).thenReturn(serviceBusinessAccountsMock);

        final FeesBusinessAccounts feesBusinessAccounts = mapper.convert(feesBusinessAccountsEntityMock);

        assertThat(feesBusinessAccounts).isEqualTo(feesBusinessAccountsMock);
    }
}
