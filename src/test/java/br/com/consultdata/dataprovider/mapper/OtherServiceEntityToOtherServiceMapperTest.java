package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Maximum;
import br.com.consultdata.core.model.Minimum;
import br.com.consultdata.core.model.OtherService;
import br.com.consultdata.core.model.Price;
import br.com.consultdata.dataprovider.entity.MaximumEntity;
import br.com.consultdata.dataprovider.entity.MinimumEntity;
import br.com.consultdata.dataprovider.entity.OtherServiceEntity;
import br.com.consultdata.dataprovider.entity.PriceEntity;
import br.com.consultdata.fixtures.FixtureLoader;
import br.com.consultdata.fixtures.resource.MaximumFixture;
import br.com.consultdata.fixtures.resource.MinimumFixture;
import br.com.consultdata.fixtures.resource.OtherServiceEntityFixture;
import br.com.consultdata.fixtures.resource.OtherServiceFixture;
import br.com.consultdata.fixtures.resource.PriceFixture;
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
class OtherServiceEntityToOtherServiceMapperTest {

    @InjectMocks
    private OtherServiceEntityToOtherServiceMapper mapper;

    @Mock
    PriceEntityToPriceMapper priceEntityToPriceMapper;

    @Mock
    MinimumEntityToMinimumMapper minimumEntityToMinimumMapper;

    @Mock
    MaximumEntityToMaximumMapper maximumEntityToMaximumMapper;


    @BeforeAll
    public static void setup() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    void given_a_other_service__entity_mapper_When_call_convert_to_other_service_Then_return_other_service() {

        final Minimum minimumMock = Fixture.from(Minimum.class).gimme(MinimumFixture.VALID);
        final Price priceMock = Fixture.from(Price.class).gimme(PriceFixture.VALID);
        final Maximum maximumMock = Fixture.from(Maximum.class).gimme(MaximumFixture.VALID);

        final OtherService otherServiceMock = Fixture.from(OtherService.class).gimme(OtherServiceFixture.VALID);
        final OtherServiceEntity otherServiceEntityMock = Fixture.from(OtherServiceEntity.class).gimme(OtherServiceEntityFixture.VALID);

        when(priceEntityToPriceMapper.convert(any(PriceEntity.class))).thenReturn(priceMock);
        when(minimumEntityToMinimumMapper.convert(any(MinimumEntity.class))).thenReturn(minimumMock);
        when(maximumEntityToMaximumMapper.convert(any(MaximumEntity.class))).thenReturn(maximumMock);


        final OtherService otherService = mapper.convert(otherServiceEntityMock);

        assertThat(otherService).isEqualTo(otherServiceMock);
    }
}
