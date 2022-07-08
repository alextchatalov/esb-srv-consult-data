package br.com.consultdata.core.usecase;

import br.com.consultdata.core.model.AccountModel;
import br.com.consultdata.core.model.BestServiceBundleAccount;
import br.com.consultdata.core.model.TypeAccount;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class FindBestAccountServiceBundleUserCase {

    private FindBestServiceBundleFromPersonalAccountByTypeBoundary findBestServiceBundleFromPersonalAccountByTypeBoundary;
    private FindBestServiceBundleFromBusinessAccountByTypeBoundary findBestServiceBundleFromBusinessAccountByTypeBoundary;

    public List<BestServiceBundleAccount> execute(final AccountModel accountModel, TypeAccount type) {

        if (TypeAccount.PERSONAL.equals(type)) {
            return findBestServiceBundleFromPersonalAccountByTypeBoundary.execute(accountModel.name());
        } else {
            return findBestServiceBundleFromBusinessAccountByTypeBoundary.execute(accountModel.name());
        }

    }
}
