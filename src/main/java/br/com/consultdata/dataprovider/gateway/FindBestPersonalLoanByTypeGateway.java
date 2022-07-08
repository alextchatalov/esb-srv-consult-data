package br.com.consultdata.dataprovider.gateway;

import br.com.consultdata.core.model.BestLoan;
import br.com.consultdata.core.usecase.FindBestPersonalLoanByTypeBoundary;
import br.com.consultdata.dataprovider.mapper.ProjectionBestLoanToBestLoanMapper;
import br.com.consultdata.dataprovider.projections.ProjectionBestLoan;
import br.com.consultdata.dataprovider.repository.LoansRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindBestPersonalLoanByTypeGateway implements FindBestPersonalLoanByTypeBoundary {

    private final LoansRepository repository;

    @Override
    public List<BestLoan> execute(final String type) {
        List<ProjectionBestLoan> result = repository.findTopFivePersonalLoansByType(type);

        if (result == null || result.isEmpty()) {
            return new ArrayList<>();
        }

        return result.stream().map(ProjectionBestLoanToBestLoanMapper::convert).collect(Collectors.toList());
    }
}
