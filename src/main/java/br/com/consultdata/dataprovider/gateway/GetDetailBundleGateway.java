package br.com.consultdata.dataprovider.gateway;

import br.com.consultdata.core.model.DetailBundle;
import br.com.consultdata.core.usecase.GetDetailBundleBoundary;
import br.com.consultdata.dataprovider.mapper.ProjectionDetailBundleToDetailBundleMapper;
import br.com.consultdata.dataprovider.projections.ProjectionDetailBundle;
import br.com.consultdata.dataprovider.repository.PersonalAccountRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetDetailBundleGateway implements GetDetailBundleBoundary {

    private final PersonalAccountRepository repository;

    @Override
    public List<DetailBundle> execute(Long bundleId) {
        List<ProjectionDetailBundle> projectionResult = repository.getDetailFromBundle(bundleId);
        if (projectionResult.isEmpty()){
            return new ArrayList<>();
        }

        return projectionResult.stream().map(ProjectionDetailBundleToDetailBundleMapper::convert).collect(Collectors.toList());
    }
}
