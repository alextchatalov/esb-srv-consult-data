package br.com.consultdata.core.usecase;

import br.com.consultdata.core.model.BestServiceBundlePersonalAccount;
import br.com.consultdata.core.model.TypeAccount;

import java.util.List;

public interface FindBestServiceBundleFromPersonalAccountByTypeBoundary {

    List<BestServiceBundlePersonalAccount> execute(String type);
}
