package br.com.consultdata.core.usecase;

import br.com.consultdata.core.model.BestLoan;
import java.util.List;

public interface FindBestPersonalLoanByTypeBoundary {

    List<BestLoan> execute(String type);
}
