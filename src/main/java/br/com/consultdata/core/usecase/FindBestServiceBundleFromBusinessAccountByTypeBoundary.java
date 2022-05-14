package br.com.consultdata.core.usecase;

import br.com.consultdata.core.model.BestServiceBundleBusinessAccount;

import java.util.List;

public interface FindBestServiceBundleFromBusinessAccountByTypeBoundary {

    List<BestServiceBundleBusinessAccount> execute(String type);
}
