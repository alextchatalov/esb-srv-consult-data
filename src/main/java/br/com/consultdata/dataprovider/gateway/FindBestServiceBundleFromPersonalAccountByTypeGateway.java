package br.com.consultdata.dataprovider.gateway;

import br.com.consultdata.core.model.BestServiceBundlePersonalAccount;
import br.com.consultdata.core.model.TypeAccount;
import br.com.consultdata.core.usecase.FindBestServiceBundleFromPersonalAccountByTypeBoundary;
import br.com.consultdata.dataprovider.mapper.ProjectionPersonalAccountServiceBundleToBestServiceBundleFromPersonalAccountMapper;
import br.com.consultdata.dataprovider.projections.ProjectionPersonalAccountServiceBundle;
import br.com.consultdata.dataprovider.repository.PersonalAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindBestServiceBundleFromPersonalAccountByTypeGateway implements FindBestServiceBundleFromPersonalAccountByTypeBoundary {

    private final PersonalAccountRepository repository;

    @Override
    public List<BestServiceBundlePersonalAccount> execute(final String type) {
        List<ProjectionPersonalAccountServiceBundle> result = repository.findBestServiceBundleFromPersonalAccountsByType(type);

        if (result == null || result.isEmpty()) {
            return new ArrayList<>();
        }

        return result.stream().map(ProjectionPersonalAccountServiceBundleToBestServiceBundleFromPersonalAccountMapper::convert).collect(Collectors.toList());
    }
}
