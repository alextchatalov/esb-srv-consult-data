package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.BestServiceBundleAccount;
import br.com.consultdata.dataprovider.projections.ProjectionAccountServiceBundle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;

@Slf4j
@Lazy
public class ProjectionAccountServiceBundleToBestServiceBundleFromAccountMapper {

    @NonNull
    public static BestServiceBundleAccount convert(final ProjectionAccountServiceBundle projection) {

        return BestServiceBundleAccount.builder()
                .bank(projection.getBank())
                .bundleName(projection.getBundleName())
                .customerFriendlyLogoUri(projection.getCustomerFriendlyLogoUri())
                .minimum(projection.getMinimum())
                .maximum(projection.getMaximum())
                .id(projection.getId())
                .build();
    }

}
