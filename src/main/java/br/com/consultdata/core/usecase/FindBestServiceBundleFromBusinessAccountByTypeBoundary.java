package br.com.consultdata.core.usecase;

import br.com.consultdata.core.model.BestServiceBundleAccount;

import java.util.List;

public interface FindBestServiceBundleFromBusinessAccountByTypeBoundary {

    List<BestServiceBundleAccount> execute(String type);
}
