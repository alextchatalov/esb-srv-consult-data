package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.Maximum;
import br.com.bestbank.getdataopenbanking.core.model.Minimum;
import br.com.bestbank.getdataopenbanking.core.model.Price;
import br.com.bestbank.getdataopenbanking.core.model.PriorityService;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MaximumEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MinimumEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PriceEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PriorityServiceEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.MaximumEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.MinimumEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.PriceEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.PriorityServiceEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.PriorityServiceFixture;
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
class PriorityServiceToPriorityServiceFromServiceBundleEntityMapperTestPersonalAccounts {

    @InjectMocks
    private PriorityServiceToPriorityServiceEntityMapper mapper;

    @Mock
    PriceToPriceEntityMapper priceToPriceEntityMapper;

    @Mock
    MinimumToMinimumEntityMapper minimumToMinimumEntityMapper;

    @Mock
    MaximumToMaximumEntityMapper maximumToMaximumEntityMapper;


    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_priority_service_mapper_When_call_convert_to_priority_service_entity_Then_return_priority_service_entity() {

        final PriceEntity priceEntityMock = Fixture.from(PriceEntity.class).gimme(PriceEntityFixture.VALID);
        final MinimumEntity minimumEntityMock = Fixture.from(MinimumEntity.class).gimme(MinimumEntityFixture.VALID);
        final MaximumEntity maximumEntityMock = Fixture.from(MaximumEntity.class).gimme(MaximumEntityFixture.VALID);

        final PriorityServiceEntity priorityServiceEntityMock = Fixture.from(PriorityServiceEntity.class).gimme(PriorityServiceEntityFixture.VALID);
        final PriorityService priorityServiceMock = Fixture.from(PriorityService.class).gimme(PriorityServiceFixture.VALID);


        when(priceToPriceEntityMapper.convert(any(Price.class))).thenReturn(priceEntityMock);
        when(minimumToMinimumEntityMapper.convert(any(Minimum.class))).thenReturn(minimumEntityMock);
        when(maximumToMaximumEntityMapper.convert(any(Maximum.class))).thenReturn(maximumEntityMock);

        final PriorityServiceEntity priorityServiceEntity = mapper.convert(priorityServiceMock);

        assertThat(priorityServiceEntity).isEqualTo(priorityServiceEntityMock);
    }
}
