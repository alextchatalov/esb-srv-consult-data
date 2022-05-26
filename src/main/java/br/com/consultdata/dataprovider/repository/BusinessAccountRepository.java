package br.com.consultdata.dataprovider.repository;

import br.com.consultdata.dataprovider.entity.DataEntity;
import br.com.consultdata.dataprovider.projections.ProjectionBusinessAccountServiceBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusinessAccountRepository extends JpaRepository<DataEntity, String> {

    @Query(value = "select distinct company.name as name, \n" +
            "business.type as type, \n" +
            "CAST(minimum.value as DECIMAL) as minimum \n" +
            ", minimum.currency as minimumCurrency , \n" +
            "CAST(maximum.value as DECIMAL) as maximum, \n" +
            "maximum.currency as maximumCurrency, \n" +
            "participant.customer_friendly_logo_uri as customerFriendlyLogoUri\n" +
            "from brand\n" +
            "inner join company on brand.id = company.brand_id\n" +
            "inner join business_account business on business.company_id = company.id\n" +
            "inner join service_bundle service on service.business_account_id = business.id\n" +
            "inner join service_from_service_bundle bundle on bundle.service_bundle_id = service.id\n" +
            "inner join price on price.service_bundle_id = service.id\n" +
            "inner join customers on customers.price_id = price.id\n" +
            "inner join minimum on minimum.service_bundle_id = service.id\n" +
            "inner join maximum on maximum.service_bundle_id = service.id\n" +
            "inner join participant on participant.organisation_id = brand.participant_organisation_id\n" +
            "where minimum.value <> 'NA'\n" +
            "and maximum.value <> 'NA'\n" +
            "and business.type = ?1\n" +
            "order by maximum asc\n" +
            "FETCH FIRST 5 ROWS ONLY"
            , nativeQuery = true)
    List<ProjectionBusinessAccountServiceBundle> findBestServiceBundleFromBusinessAccountsByType(String type);
}
