package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.FeesPersonalAccounts;
import br.com.bestbank.getdataopenbanking.core.model.OtherService;
import br.com.bestbank.getdataopenbanking.core.model.PriorityService;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.FeesEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.OtherServiceEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PriorityServiceEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.FeesEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.FeesFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.OtherServiceEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.PriorityServiceEntityFixture;
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
class FeesPersonalAccountsToFeesPersonalAccountsEntityMapperTestPersonalAccounts {

    @InjectMocks
    private PersonalAccountsEntityToPersonalAccountMapper mapper;

    @Mock
    PriorityServiceToPriorityServiceEntityMapper priorityServiceToPriorityServiceEntityMapper;

    @Mock
    OtherServiceToOtherServiceEntityMapper otherServiceToOtherServiceEntityMapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_fees_mapper_When_call_convert_to_fees_entity_Then_return_fees_entity() {

        final FeesPersonalAccounts feesPersonalAccountsMock = Fixture.from(FeesPersonalAccounts.class).gimme(FeesFixture.VALID);
        final FeesEntity feesEntityMock = Fixture.from(FeesEntity.class).gimme(FeesEntityFixture.VALID);
        final PriorityServiceEntity priorityServiceEntityMock = Fixture.from(PriorityServiceEntity.class).gimme(PriorityServiceEntityFixture.VALID);
        final OtherServiceEntity otherServiceEntityMock = Fixture.from(OtherServiceEntity.class).gimme(OtherServiceEntityFixture.VALID);

        when(priorityServiceToPriorityServiceEntityMapper.convert(any(PriorityService.class))).thenReturn(priorityServiceEntityMock);
        when(otherServiceToOtherServiceEntityMapper.convert(any(OtherService.class))).thenReturn(otherServiceEntityMock);

        final FeesEntity feesEntity = mapper.convert(feesPersonalAccountsMock);

        assertThat(feesEntity).isEqualTo(feesEntityMock);
    }
}
