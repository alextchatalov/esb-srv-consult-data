package br.com.consultdata.dataprovider.repository;

import br.com.consultdata.core.model.TypeAccount;
import br.com.consultdata.dataprovider.entity.DataEntity;
import br.com.consultdata.dataprovider.projections.ProjectionPersonalAccountServiceBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalAccountRepository extends JpaRepository<DataEntity, String> {

    @Query(value = "" +
            "select distinct company.name as name, \n" +
            "personal.type as type, \n" +
            "CAST(minimum.value as DECIMAL) as minimum \n" +
            ", minimum.currency as minimumCurrency , \n" +
            "CAST(maximum.value as DECIMAL) as maximum, \n" +
            "maximum.currency as maximumCurrency, \n" +
            "participant.customer_friendly_logo_uri as customerFriendlyLogoUri\n" +
            "from data\n" +
            "inner join brand on brand.data_id = data.id\n" +
            "inner join company on company.brand_id = brand.id\n" +
            "inner join personal_account personal on personal.company_id = company.id\n" +
            "inner join service_bundle service on service.personal_account_id = personal.id\n" +
            "inner join minimum on minimum.service_bundle_id = service.id\n" +
            "inner join maximum on maximum.service_bundle_id = service.id\n" +
            "inner join participant on participant.organisation_id = brand.participant_organisation_id\n" +
            "where minimum.value <> 'NA'\n" +
            "and maximum.value <> 'NA'\n" +
            "and personal.type = ?1\n" +
            "order by maximum asc\n" +
            "FETCH FIRST 5 ROWS ONLY"
            , nativeQuery = true)
    List<ProjectionPersonalAccountServiceBundle> findBestServiceBundleFromPersonalAccountsByType(String type);
}
