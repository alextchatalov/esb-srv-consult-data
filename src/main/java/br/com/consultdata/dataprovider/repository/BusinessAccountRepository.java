package br.com.consultdata.dataprovider.repository;

import br.com.consultdata.dataprovider.entity.DataEntity;
import br.com.consultdata.dataprovider.projections.ProjectionAccountServiceBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusinessAccountRepository extends JpaRepository<DataEntity, String> {

    @Query(value = "select bundle.bank as bank,\n" +
            "       bundle.company as company,\n" +
            "       bundle.customerFriendlyLogoUri as customerFriendlyLogoUri,\n" +
            "       bundle.bundleName AS bundleName,\n" +
            "       bundle.minimum as minimum,\n" +
            "       bundle.maximum as maximum,\n" +
            "       bundle.id as id,\n" +
            "\t   bundle.business_id\n" +
            "from (\n" +
            "    SELECT \n" +
            "       participant.customer_friendly_name AS bank,\n" +
            "       participant.customer_friendly_logo_uri AS customerFriendlyLogoUri,\n" +
            "       brand.name as brand,\n" +
            "       brand.id as brand_id,\n" +
            "       company.name as company,\n" +
            "       company.id as company_id,\n" +
            "       business.id as business_id,\n" +
            "       business.type as type,\n" +
            "       service.name AS bundleName,\n" +
            "       service.id as bundle_id,\n" +
            "       CAST(minimum.value AS DECIMAL) AS minimum,\n" +
            "       CAST(maximum.value AS DECIMAL) AS maximum,\n" +
            "       service.id as id\n" +
            "    FROM DATA\n" +
            "    INNER JOIN brand ON brand.data_id = data.id\n" +
            "    INNER JOIN company ON company.brand_id = brand.id\n" +
            "    INNER JOIN participant ON participant.organisation_id = brand.participant_organisation_id\n" +
            "    INNER JOIN business_account business on business.company_id = company.id\n" +
            "\tINNER JOIN service_bundle service on service.business_account_id = business.id\n" +
            "\tINNER JOIN minimum on minimum.service_bundle_id = service.id\n" +
            "\tINNER JOIN maximum on maximum.service_bundle_id = service.id\n" +
            "    WHERE SERVICE.ID = (\n" +
            "        SELECT best_service.id\n" +
            "        FROM service_bundle best_service\n" +
            "        INNER JOIN minimum ON minimum.service_bundle_id = best_service.id\n" +
            "        INNER JOIN maximum ON maximum.service_bundle_id = best_service.id\n" +
            "        WHERE minimum.value <> 'NA'\n" +
            "        AND maximum.value <> 'NA'\n" +
            "        AND best_service.name <> 'NA'\n" +
            "        AND best_service.business_account_id = business.id\n" +
            "        ORDER BY CAST(maximum.value AS DECIMAL) ASC\n" +
            "        FETCH FIRST 1 ROWS ONLY\n" +
            "    ) \n" +
            "    \n" +
            ") bundle\n" +
            "WHERE bundle.TYPE = ?1\n" +
            "FETCH FIRST 5 ROWS ONLY"
            , nativeQuery = true)
    List<ProjectionAccountServiceBundle> findBestServiceBundleFromBusinessAccountsByType(String type);
}
