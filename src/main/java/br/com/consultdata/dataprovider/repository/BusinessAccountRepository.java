package br.com.consultdata.dataprovider.repository;

import br.com.consultdata.dataprovider.entity.DataEntity;
import br.com.consultdata.dataprovider.projections.ProjectionBusinessAccountServiceBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusinessAccountRepository extends JpaRepository<DataEntity, String> {

    @Query(value = "SELECT participant.customer_friendly_name AS bank,\n" +
            "       service.name AS bundleName,\n" +
            "       participant.customer_friendly_logo_uri AS customerFriendlyLogoUri,\n" +
            "       SUM (CAST(minimum.value AS DECIMAL)) AS minimum,\n" +
            "       SUM(CAST(maximum.value AS DECIMAL)) AS maximum\n" +
            "FROM DATA\n" +
            "INNER JOIN brand ON brand.data_id = data.id\n" +
            "inner join company on brand.id = company.brand_id\n" +
            "inner join business_account business on business.company_id = company.id\n" +
            "inner join service_bundle service on service.business_account_id = business.id\n" +
            "inner join service_from_service_bundle bundle on bundle.service_bundle_id = service.id\n" +
            "inner join price on price.service_bundle_id = service.id\n" +
            "inner join customers on customers.price_id = price.id\n" +
            "inner join minimum on minimum.service_bundle_id = service.id\n" +
            "inner join maximum on maximum.service_bundle_id = service.id\n" +
            "inner join participant on participant.organisation_id = brand.participant_organisation_id\n" +
            "WHERE minimum.value <> 'NA'\n" +
            "  AND maximum.value <> 'NA'\n" +
            "  AND service.name <> 'NA'\n" +
            "GROUP BY participant.customer_friendly_name,\n" +
            "         service.name,\n" +
            "         customerFriendlyLogoUri\n" +
            "ORDER BY maximum\n" +
            "FETCH FIRST 5 ROWS ONLY"
            , nativeQuery = true)
    List<ProjectionBusinessAccountServiceBundle> findBestServiceBundleFromBusinessAccountsByType(String type);
}
