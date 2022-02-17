package br.com.consultdata.dataprovider.mapper;

import br.com.bestbank.getdataopenbanking.core.model.Maximum;
import br.com.bestbank.getdataopenbanking.core.model.Minimum;
import br.com.bestbank.getdataopenbanking.core.model.OtherService;
import br.com.bestbank.getdataopenbanking.core.model.Price;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MaximumEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MinimumEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.OtherServiceEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PriceEntity;
import br.com.bestbank.getdataopenbanking.fixtures.FixtureLoader;
import br.com.bestbank.getdataopenbanking.fixtures.resource.MaximumEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.MinimumEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.OtherServiceEntityFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.OtherServiceFixture;
import br.com.bestbank.getdataopenbanking.fixtures.resource.PriceEntityFixture;
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
class OtherServiceToOtherServiceFromServiceBundleEntityMapperTestPersonalAccounts {

    @InjectMocks
    private OtherServiceToOtherServiceEntityMapper mapper;

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
    void given_a_other_service_mapper_When_call_convert_to_other_service_entity_Then_return_other_service_entity() {

        final MinimumEntity minimumEntityMock = Fixture.from(MinimumEntity.class).gimme(MinimumEntityFixture.VALID);
        final PriceEntity priceEntityMock = Fixture.from(PriceEntity.class).gimme(PriceEntityFixture.VALID);
        final MaximumEntity maximumEntityMock = Fixture.from(MaximumEntity.class).gimme(MaximumEntityFixture.VALID);

        final OtherService otherServiceMock = Fixture.from(OtherService.class).gimme(OtherServiceFixture.VALID);
        final OtherServiceEntity otherServiceEntityMock = Fixture.from(OtherServiceEntity.class).gimme(OtherServiceEntityFixture.VALID);

        when(priceToPriceEntityMapper.convert(any(Price.class))).thenReturn(priceEntityMock);
        when(minimumToMinimumEntityMapper.convert(any(Minimum.class))).thenReturn(minimumEntityMock);
        when(maximumToMaximumEntityMapper.convert(any(Maximum.class))).thenReturn(maximumEntityMock);


        final OtherServiceEntity otherServiceEntity = mapper.convert(otherServiceMock);

        assertThat(otherServiceEntity).isEqualTo(otherServiceEntityMock);
    }
}
