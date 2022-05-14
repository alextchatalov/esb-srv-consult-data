package br.com.consultdata.core.usecase;

import br.com.consultdata.core.model.BestServiceBundleBusinessAccount;
import br.com.consultdata.core.model.TypeAccount;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class FindBestServiceBundleFromBusinessAccountUserCase {

    private FindBestServiceBundleFromBusinessAccountByTypeBoundary findBestServiceBundleFromBusinessAccountByTypeBoundary;

    public List<BestServiceBundleBusinessAccount> execute(final TypeAccount type) {
        return findBestServiceBundleFromBusinessAccountByTypeBoundary.execute(type.name());
    }
}
