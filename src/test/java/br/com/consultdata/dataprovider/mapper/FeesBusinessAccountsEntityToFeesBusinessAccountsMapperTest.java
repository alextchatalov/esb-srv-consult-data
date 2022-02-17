package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.FeesBusinessAccounts;
import br.com.bestbank.getdataopenbanking.core.model.ServiceBusinessAccounts;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.FeesBusinessAccountsEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.ServiceBusinessAccountsEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.FeesBusinessAccountsEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.FeesBusinessAccountsFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.ServiceBusinessAccountsEntityFixture;
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
class FeesBusinessAccountsToFeesBusinessAccountsEntityMapperTest {

    @InjectMocks
    private FeesBusinessAccountsToFeesBusinessAccountsEntityMapper mapper;

    @Mock
    ServiceBusinessAccountsToServiceBusinessAccountsEntityMapper serviceBusinessAccountsToServiceBusinessAccountsEntityMapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_feesBusiness_accounts_mapper_When_call_convert_to_feesBusiness_accounts_entity_Then_return_feesBusiness_accounts_entity() {

        final ServiceBusinessAccountsEntity serviceBusinessAccountsEntityMock = Fixture.from(ServiceBusinessAccountsEntity.class).gimme(ServiceBusinessAccountsEntityFixture.VALID);

        final FeesBusinessAccounts feesBusinessAccountsMock = Fixture.from(FeesBusinessAccounts.class).gimme(FeesBusinessAccountsFixture.VALID);
        final FeesBusinessAccountsEntity feesBusinessAccountsEntityMock = Fixture.from(FeesBusinessAccountsEntity.class).gimme(FeesBusinessAccountsEntityFixture.VALID);

        when(serviceBusinessAccountsToServiceBusinessAccountsEntityMapper.convert(any(ServiceBusinessAccounts.class))).thenReturn(serviceBusinessAccountsEntityMock);

        final FeesBusinessAccountsEntity feesBusinessAccountsEntity = mapper.convert(feesBusinessAccountsMock);

        assertThat(feesBusinessAccountsEntity).isEqualTo(feesBusinessAccountsEntityMock);
    }
}
