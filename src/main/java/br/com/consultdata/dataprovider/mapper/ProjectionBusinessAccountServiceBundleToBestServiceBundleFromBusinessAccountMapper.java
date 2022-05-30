package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.BestServiceBundleBusinessAccount;
import br.com.consultdata.dataprovider.projections.ProjectionBusinessAccountServiceBundle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;

@Slf4j
@Lazy
public class ProjectionBusinessAccountServiceBundleToBestServiceBundleFromBusinessAccountMapper {

    @NonNull
    public static BestServiceBundleBusinessAccount convert(final ProjectionBusinessAccountServiceBundle projection) {

        return BestServiceBundleBusinessAccount.builder()
                .bank(projection.getBank())
                .bundleName(projection.getBundleName())
                .customerFriendlyLogoUri(projection.getCustomerFriendlyLogoUri())
                .minimum(projection.getMinimum())
                .maximum(projection.getMaximum())
                .build();
    }

}
