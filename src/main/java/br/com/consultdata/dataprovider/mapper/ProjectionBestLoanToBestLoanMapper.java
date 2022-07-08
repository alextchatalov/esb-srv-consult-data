package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.BestLoan;
import br.com.consultdata.dataprovider.projections.ProjectionBestLoan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;

@Slf4j
@Lazy
public class ProjectionBestLoanToBestLoanMapper {

    @NonNull
    public static BestLoan convert(final ProjectionBestLoan projection) {

        return BestLoan.builder()
                .bank(projection.getBank())
                .company(projection.getCompany())
                .customerFriendlyLogoUri(projection.getCustomerFriendlyLogoUri())
                .minimum(projection.getMinimum())
                .maximum(projection.getMaximum())
                .rateId(projection.getRateId())
                .rate(projection.getRate())
                .build();
    }

}
