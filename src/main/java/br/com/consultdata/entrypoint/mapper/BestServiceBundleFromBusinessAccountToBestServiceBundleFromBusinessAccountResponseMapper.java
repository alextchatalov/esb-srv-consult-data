package br.com.consultdata.entrypoint.mapper;

import br.com.consultdata.core.model.BestServiceBundleBusinessAccount;
import br.com.consultdata.entrypoint.response.BestServiceBundleFromBusinessAccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;

@Slf4j
@Lazy
public class BestServiceBundleFromBusinessAccountToBestServiceBundleFromBusinessAccountResponseMapper {

    @NonNull
    public static BestServiceBundleFromBusinessAccountResponse convert(final BestServiceBundleBusinessAccount bestServiceBundleBusinessAccount) {

        return BestServiceBundleFromBusinessAccountResponse.builder()
                .name(bestServiceBundleBusinessAccount.getName())
                .type(bestServiceBundleBusinessAccount.getType())
                .minimum(bestServiceBundleBusinessAccount.getMinimum())
                .minimumCurrency(bestServiceBundleBusinessAccount.getMinimumCurrency())
                .maximum(bestServiceBundleBusinessAccount.getMaximum())
                .maximumCurrency(bestServiceBundleBusinessAccount.getMaximumCurrency())
                .customerFriendlyLogoUri(bestServiceBundleBusinessAccount.getCustomerFriendlyLogoUri())
                .build();
    }

}
