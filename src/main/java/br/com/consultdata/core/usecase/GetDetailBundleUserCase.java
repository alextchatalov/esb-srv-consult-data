package br.com.consultdata.core.usecase;

import br.com.consultdata.core.model.DetailBundle;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class GetDetailBundleUserCase {

    private GetDetailBundleBoundary getDetailBundleBoundary;

    public List<DetailBundle> execute(final Long bundleId) {
        return getDetailBundleBoundary.execute(bundleId);
    }
}
