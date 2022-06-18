package br.com.consultdata.dataprovider.repository;

import br.com.consultdata.dataprovider.entity.DataEntity;
import br.com.consultdata.dataprovider.projections.ProjectionAccountServiceBundle;
import br.com.consultdata.dataprovider.projections.ProjectionDetailBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalAccountRepository extends JpaRepository<DataEntity, String> {

    @Query(value = "SELECT participant.customer_friendly_name AS bank,\n" +
            "       service.name AS bundleName,\n" +
            "       participant.customer_friendly_logo_uri AS customerFriendlyLogoUri,\n" +
            "       SUM (CAST(minimum.value AS DECIMAL)) AS minimum,\n" +
            "       SUM(CAST(maximum.value AS DECIMAL)) AS maximum,\n" +
            "       service.id as id\n" +
            "FROM DATA\n" +
            "INNER JOIN brand ON brand.data_id = data.id\n" +
            "INNER JOIN company ON company.brand_id = brand.id\n" +
            "INNER JOIN personal_account personal ON personal.company_id = company.id\n" +
            "INNER JOIN service_bundle service ON service.personal_account_id = personal.id\n" +
            "INNER JOIN minimum ON minimum.service_bundle_id = service.id\n" +
            "INNER JOIN maximum ON maximum.service_bundle_id = service.id\n" +
            "INNER JOIN participant ON participant.organisation_id = brand.participant_organisation_id\n" +
            "WHERE minimum.value <> 'NA'\n" +
            "  AND maximum.value <> 'NA'\n" +
            "  AND service.name <> 'NA'\n" +
            "  AND personal.type = ?1\n" +
            "GROUP BY participant.customer_friendly_name,\n" +
            "         service.name,\n" +
            "         customerFriendlyLogoUri,\n" +
            "         service.id\n" +
            "ORDER BY maximum\n" +
            "FETCH FIRST 5 ROWS ONLY"
            , nativeQuery = true)
    List<ProjectionAccountServiceBundle> findBestServiceBundleFromPersonalAccountsByType(String type);

    @Query(value = "SELECT bundle.name as bundle,\n" +
            "       services.code as code,\n" +
            "       services.charging_trigger_info as info,\n" +
            "       services.event_limit_quantity as eventLimit,\n" +
            "       services.free_event_quantity as freeLimit,\n" +
            "       minimum.value as minimum,\n" +
            "       maximum.value\n as maximum\n" +
            "FROM service_bundle bundle\n" +
            "INNER JOIN service_from_service_bundle services ON bundle.id = services.service_bundle_id\n" +
            "INNER JOIN minimum ON minimum.service_bundle_id = bundle.id\n" +
            "INNER JOIN maximum ON maximum.service_bundle_id = bundle.id\n" +
            "where bundle.id = ?1"
            , nativeQuery = true)
    List<ProjectionDetailBundle> getDetailFromBundle(Long bundleId);
}
