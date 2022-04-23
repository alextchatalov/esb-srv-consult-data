package br.com.consultdata.core.usecase;

import br.com.consultdata.core.model.BestServiceBundlePersonalAccount;
import br.com.consultdata.core.model.Type;
import br.com.consultdata.core.model.TypeAccount;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class FindBestServiceBundleFromPersonalAccountUserCase {

    private FindBestServiceBundleFromPersonalAccountByTypeBoundary findBestServiceBundleFromPersonalAccountByTypeBoundary;

    public List<BestServiceBundlePersonalAccount> execute(final TypeAccount type) {
        return findBestServiceBundleFromPersonalAccountByTypeBoundary.execute(type.name());
    }
}
