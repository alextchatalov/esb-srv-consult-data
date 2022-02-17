package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.FeesPersonalAccounts;
import br.com.consultdata.core.model.OtherService;
import br.com.consultdata.core.model.PriorityService;
import br.com.consultdata.dataprovider.entity.FeesPersonalAccountsEntity;
import br.com.consultdata.dataprovider.entity.OtherServiceEntity;
import br.com.consultdata.dataprovider.entity.PriorityServiceEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.FeesPersonalAccountsEntityFixture;
import br.com.consultdata.fixtures.resource.FeesPersonalAccountsFixture;
import br.com.consultdata.fixtures.resource.OtherServiceFixture;
import br.com.consultdata.fixtures.resource.PriorityServiceFixture;
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
class FeesPersonalAccountsEntityToFeesPersonalAccountsMapperTest {

    @InjectMocks
    private FeesPersonalAccountsEntityToFeesPersonalAccountsMapper mapper;

    @Mock
    PriorityServiceEntityToPriorityServiceMapper priorityServiceEntityToPriorityServiceMapper;

    @Mock
    OtherServiceEntityToOtherServiceMapper otherServiceEntityToOtherServiceMapper;

    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_fees_entity_mapper_When_call_convert_to_fees_Then_return_fees() {

        final FeesPersonalAccounts feesPersonalAccountsMock = Fixture.from(FeesPersonalAccounts.class).gimme(FeesPersonalAccountsFixture.VALID);
        final FeesPersonalAccountsEntity feesPersonalAccountsEntityMock = Fixture.from(FeesPersonalAccountsEntity.class).gimme(FeesPersonalAccountsEntityFixture.VALID);
        final PriorityService priorityServiceMock = Fixture.from(PriorityService.class).gimme(PriorityServiceFixture.VALID);
        final OtherService otherServiceMock = Fixture.from(OtherService.class).gimme(OtherServiceFixture.VALID);

        when(priorityServiceEntityToPriorityServiceMapper.convert(any(PriorityServiceEntity.class))).thenReturn(priorityServiceMock);
        when(otherServiceEntityToOtherServiceMapper.convert(any(OtherServiceEntity.class))).thenReturn(otherServiceMock);

        final FeesPersonalAccounts feesPersonalAccounts = mapper.convert(feesPersonalAccountsEntityMock);

        assertThat(feesPersonalAccounts).isEqualTo(feesPersonalAccountsMock);
    }
}
