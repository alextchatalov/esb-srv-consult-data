package br.com.consultdata.core.usecase;

import br.com.consultdata.core.model.AccountModel;
import br.com.consultdata.core.model.BestServiceBundleAccount;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class FindBestServiceBundleFromPersonalAccountUserCase {

    private FindBestServiceBundleFromPersonalAccountByTypeBoundary findBestServiceBundleFromPersonalAccountByTypeBoundary;

    public List<BestServiceBundleAccount> execute(final AccountModel accountModel) {
        return findBestServiceBundleFromPersonalAccountByTypeBoundary.execute(accountModel.name());
    }
}
