package br.com.consultdata.resolver;

import br.com.consultdata.core.model.AccountModel;
import br.com.consultdata.core.model.BestServiceBundleAccount;
import br.com.consultdata.core.model.DetailBundle;
import br.com.consultdata.core.model.TypeAccount;
import br.com.consultdata.core.usecase.FindBestServiceBundleFromBusinessAccountUserCase;
import br.com.consultdata.core.usecase.FindBestServiceBundleFromPersonalAccountUserCase;
import br.com.consultdata.core.usecase.GetDetailBundleUserCase;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AccountResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final FindBestServiceBundleFromPersonalAccountUserCase findBestServiceBundleFromPersonalAccountUserCase;
    private final FindBestServiceBundleFromBusinessAccountUserCase findBestServiceBundleFromBusinessAccountUserCase;
    private final GetDetailBundleUserCase getDetailBundleUserCase;

    public List<BestServiceBundleAccount> getBestTopFiveBundleFromAccount(final TypeAccount type, final AccountModel accountModel) {
        if (TypeAccount.PERSONAL.equals(type)) {
            return findBestServiceBundleFromPersonalAccountUserCase.execute(accountModel);
        } else {
            return findBestServiceBundleFromBusinessAccountUserCase.execute(accountModel);
        }
    }

    public List<DetailBundle> getDetailBundle(final Long bundleId) {
        return getDetailBundleUserCase.execute(bundleId);
    }
}
