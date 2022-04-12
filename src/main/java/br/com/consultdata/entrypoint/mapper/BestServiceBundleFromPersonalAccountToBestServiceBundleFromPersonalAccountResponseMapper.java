package br.com.consultdata.entrypoint.mapper;

import br.com.consultdata.core.model.BestServiceBundlePersonalAccount;
import br.com.consultdata.entrypoint.response.BestServiceBundleFromPersonalAccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;

@Slf4j
@Lazy
public class BestServiceBundleFromPersonalAccountToBestServiceBundleFromPersonalAccountResponseMapper {

    @NonNull
    public static BestServiceBundleFromPersonalAccountResponse convert(final BestServiceBundlePersonalAccount bestServiceBundlePersonalAccount) {

        return BestServiceBundleFromPersonalAccountResponse.builder()
                .name(bestServiceBundlePersonalAccount.getName())
                .type(bestServiceBundlePersonalAccount.getType())
                .minimum(bestServiceBundlePersonalAccount.getMinimum())
                .minimumCurrency(bestServiceBundlePersonalAccount.getMinimumCurrency())
                .maximum(bestServiceBundlePersonalAccount.getMaximum())
                .maximumCurrency(bestServiceBundlePersonalAccount.getMaximumCurrency())
                .build();
    }

}
