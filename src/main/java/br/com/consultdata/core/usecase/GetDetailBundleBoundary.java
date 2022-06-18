package br.com.consultdata.core.usecase;

import br.com.consultdata.core.model.DetailBundle;
import java.util.List;

public interface GetDetailBundleBoundary {

    List<DetailBundle> execute(Long bundleId);
}
