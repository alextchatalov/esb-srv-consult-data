package br.com.consultdata.dataprovider.gateway;

import br.com.consultdata.core.model.BestServiceBundleAccount;
import br.com.consultdata.core.usecase.FindBestServiceBundleFromBusinessAccountByTypeBoundary;
import br.com.consultdata.dataprovider.mapper.ProjectionAccountServiceBundleToBestServiceBundleFromAccountMapper;
import br.com.consultdata.dataprovider.projections.ProjectionAccountServiceBundle;
import br.com.consultdata.dataprovider.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindBestServiceBundleFromBusinessAccountByTypeGateway implements FindBestServiceBundleFromBusinessAccountByTypeBoundary {

    private final AccountRepository repository;

    @Override
    public List<BestServiceBundleAccount> execute(final String type) {
        final List<ProjectionAccountServiceBundle> result = repository.findBestTopFiveBusinessAccountService(type);

        if (result == null || result.isEmpty()) {
            return new ArrayList<>();
        }

        return result.stream().map(ProjectionAccountServiceBundleToBestServiceBundleFromAccountMapper::convert).collect(Collectors.toList());
    }
}
