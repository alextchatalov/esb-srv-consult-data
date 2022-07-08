package br.com.consultdata.core.usecase;

import br.com.consultdata.core.model.BestLoan;
import br.com.consultdata.core.model.TypeAccount;
import br.com.consultdata.core.model.TypeLoan;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class FindBestLoanUserCase {

    private FindBestPersonalLoanByTypeBoundary findBestPersonalLoanByTypeBoundary;
    private FindBestBusinessLoanByTypeBoundary findBestBusinessLoanByTypeBoundary;

    public List<BestLoan> execute(final TypeLoan typeLoan, TypeAccount type) {

        if (TypeAccount.PERSONAL.equals(type)) {
            return findBestPersonalLoanByTypeBoundary.execute(typeLoan.name());
        } else {
            return findBestBusinessLoanByTypeBoundary.execute(typeLoan.name());
        }

    }
}
