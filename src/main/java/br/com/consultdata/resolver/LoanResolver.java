package br.com.consultdata.resolver;

import br.com.consultdata.core.model.AccountModel;
import br.com.consultdata.core.model.BestLoan;
import br.com.consultdata.core.model.TypeAccount;
import br.com.consultdata.core.model.TypeLoan;
import br.com.consultdata.core.usecase.FindBestLoanUserCase;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LoanResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final FindBestLoanUserCase findBestLoanUserCase;

    public List<BestLoan> getBestTopFiveLoans(final TypeAccount type, final TypeLoan typeLoan) {
        return findBestLoanUserCase.execute(typeLoan, type);
    }
}
