package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Brand;
import br.com.consultdata.core.model.Company;
import br.com.consultdata.core.model.Data;
import br.com.consultdata.dataprovider.entity.BrandEntity;
import br.com.consultdata.dataprovider.entity.CompanyEntity;
import br.com.consultdata.dataprovider.entity.DataEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Lazy
@Component
@AllArgsConstructor
public class DataToDataEntityMapper implements Converter<DataEntity, Data> {

    private final CompanyEntityToCompanyMapper companyEntityToCompanyMapper;

    @Override
    @NonNull
    public Data convert(final DataEntity data) {
        return Data.builder()
                .id(data.getId())
                .createDateTime(data.getCreateDateTime())
                .lastModifiedDateTime(data.getLastModifiedDateTime())
                .brand(convertBrandEntityToBrand(data.getBrand()))
                .build();
    }

    private Brand convertBrandEntityToBrand(final BrandEntity brand) {
        return Brand.builder()
                .name(brand.getName())
                .companies(convertListOfCompaniesEntityToListOfCompanies(brand.getCompanies()))
                .build();
    }

    private List<Company> convertListOfCompaniesEntityToListOfCompanies(final List<CompanyEntity> companies) {
        return companies.stream().map(companyEntityToCompanyMapper::convert).collect(Collectors.toList());
    }
}
