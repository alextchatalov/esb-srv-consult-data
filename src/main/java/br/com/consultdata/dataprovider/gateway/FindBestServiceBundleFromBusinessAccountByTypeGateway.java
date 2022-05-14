package br.com.consultdata.dataprovider.gateway;

import br.com.consultdata.core.model.BestServiceBundleBusinessAccount;
import br.com.consultdata.core.usecase.FindBestServiceBundleFromBusinessAccountByTypeBoundary;
import br.com.consultdata.dataprovider.BusinessAccountRepository;
import br.com.consultdata.dataprovider.mapper.ProjectionBusinessAccountServiceBundleToBestServiceBundleFromBusinessAccountMapper;
import br.com.consultdata.dataprovider.projections.ProjectionBusinessAccountServiceBundle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindBestServiceBundleFromBusinessAccountByTypeGateway implements FindBestServiceBundleFromBusinessAccountByTypeBoundary {

    private final BusinessAccountRepository repository;

    @Override
    public List<BestServiceBundleBusinessAccount> execute(final String type) {
        final List<ProjectionBusinessAccountServiceBundle> result = repository.findBestServiceBundleFromBusinessAccountsByType(type);

        if (result == null || result.isEmpty()) {
            return new ArrayList<>();
        }

        return result.stream().map(ProjectionBusinessAccountServiceBundleToBestServiceBundleFromBusinessAccountMapper::convert).collect(Collectors.toList());
    }
}
