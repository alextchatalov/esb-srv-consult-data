package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.DetailBundle;
import br.com.consultdata.dataprovider.projections.ProjectionDetailBundle;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;

@Slf4j
@Lazy
public class ProjectionDetailBundleToDetailBundleMapper {

    @NonNull
    public static DetailBundle convert(final ProjectionDetailBundle projection) {

        return DetailBundle.builder()
                .bundle(projection.getBundle())
                .code(projection.getCode())
                .info(projection.getInfo())
                .eventLimit(projection.getEventLimit())
                .freeLimit(projection.getFreeLimit())
                .minimum(projection.getMinimum())
                .maximum(projection.getMaximum())
                .build();
    }

}
