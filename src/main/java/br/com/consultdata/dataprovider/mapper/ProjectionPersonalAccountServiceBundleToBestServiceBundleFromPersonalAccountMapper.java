package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.BestServiceBundlePersonalAccount;
import br.com.consultdata.dataprovider.projections.ProjectionPersonalAccountServiceBundle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;

@Slf4j
@Lazy
public class ProjectionPersonalAccountServiceBundleToBestServiceBundleFromPersonalAccountMapper {

    @NonNull
    public static BestServiceBundlePersonalAccount convert(final ProjectionPersonalAccountServiceBundle projection) {

        return BestServiceBundlePersonalAccount.builder()
                .name(projection.getName())
                .type(projection.getType())
                .minimum(projection.getMinimum())
                .minimumCurrency(projection.getMinimumCurrency())
                .maximum(projection.getMaximum())
                .maximumCurrency(projection.getMaximumCurrency())
                .customerFriendlyLogoUri(projection.getCustomerFriendlyLogoUri())
                .build();
    }

}
