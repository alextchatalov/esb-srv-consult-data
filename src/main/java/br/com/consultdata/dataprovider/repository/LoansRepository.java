package br.com.consultdata.dataprovider.repository;

import br.com.consultdata.dataprovider.entity.DataEntity;
import br.com.consultdata.dataprovider.projections.ProjectionBestLoan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoansRepository extends JpaRepository<DataEntity, String> {

    @Query(value = "select loan.bank as bank,\n" +
            "       loan.company as company,\n" +
            "       loan.customerFriendlyLogoUri as customerFriendlyLogoUri,\n" +
            "       loan.rate AS rate,\n" +
            "       loan.rate_id as rateId,\n" +
            "       loan.maximum as minimum,\n" +
            "       loan.maximum as maximum\n" +
            "from (\n" +
            "    SELECT \n" +
            "       participant.customer_friendly_name AS bank,\n" +
            "       participant.customer_friendly_logo_uri AS customerFriendlyLogoUri,\n" +
            "       brand.name as brand,\n" +
            "       brand.id as brand_id,\n" +
            "       company.name as company,\n" +
            "       company.id as company_id,\n" +
            "       loan.id as loan_id,\n" +
            "       loan.type as type,\n" +
            "       rate.id as rate_id,\n" +
            "       rate.rate AS rate,\n" +
            "       CAST(rate.minimum_rate AS DECIMAL) AS minimum,\n" +
            "       CAST(rate.maximum_rate AS DECIMAL) AS maximum\n" +
            "    FROM DATA\n" +
            "    INNER JOIN brand ON brand.data_id = data.id\n" +
            "    INNER JOIN company ON company.brand_id = brand.id\n" +
            "    INNER JOIN participant ON participant.organisation_id = brand.participant_organisation_id\n" +
            "    INNER JOIN personal_loan loan ON loan.company_id = company.id\n" +
            "    INNER JOIN interest_rate rate ON rate.personal_loan_id = loan.id\n" +
            "    WHERE rate.ID = (\n" +
            "        SELECT best_rate.id\n" +
            "        FROM interest_rate best_rate\n" +
            "        WHERE best_rate.minimum_rate <> 'NA'\n" +
            "        AND best_rate.maximum_rate <> 'NA'\n" +
            "        AND best_rate.rate <> 'NA'\n" +
            "        AND best_rate.rate <> 'N/A'\n" +
            "        AND best_rate.personal_loan_id = loan.id\n" +
            "        ORDER BY CAST(best_rate.minimum_rate AS DECIMAL) ASC\n" +
            "        FETCH FIRST 1 ROWS ONLY\n" +
            "    ) \n" +
            "    \n" +
            ") loan\n" +
            "WHERE loan.TYPE = ?1\n" +
            "FETCH FIRST 5 ROWS ONLY"
            , nativeQuery = true)
    List<ProjectionBestLoan> findTopFivePersonalLoansByType(String type);

    @Query(value = "select loan.bank as bank,\n" +
            "       loan.company as company,\n" +
            "       loan.customerFriendlyLogoUri as customerFriendlyLogoUri,\n" +
            "       loan.rate AS rate,\n" +
            "       loan.rate_id as rateId,\n" +
            "       loan.maximum as minimum,\n" +
            "       loan.maximum as maximum\n" +
            "from (\n" +
            "    SELECT \n" +
            "       participant.customer_friendly_name AS bank,\n" +
            "       participant.customer_friendly_logo_uri AS customerFriendlyLogoUri,\n" +
            "       brand.name as brand,\n" +
            "       brand.id as brand_id,\n" +
            "       company.name as company,\n" +
            "       company.id as company_id,\n" +
            "       loan.id as loan_id,\n" +
            "       loan.type as type,\n" +
            "       rate.id as rate_id,\n" +
            "       rate.rate AS rate,\n" +
            "       CAST(rate.minimum_rate AS DECIMAL) AS minimum,\n" +
            "       CAST(rate.maximum_rate AS DECIMAL) AS maximum\n" +
            "    FROM DATA\n" +
            "    INNER JOIN brand ON brand.data_id = data.id\n" +
            "    INNER JOIN company ON company.brand_id = brand.id\n" +
            "    INNER JOIN participant ON participant.organisation_id = brand.participant_organisation_id\n" +
            "    INNER JOIN business_loan loan ON loan.company_id = company.id\n" +
            "    INNER JOIN interest_rate rate ON rate.business_loan_id = loan.id\n" +
            "    WHERE rate.ID = (\n" +
            "        SELECT best_rate.id\n" +
            "        FROM interest_rate best_rate\n" +
            "        WHERE best_rate.minimum_rate <> 'NA'\n" +
            "        AND best_rate.maximum_rate <> 'NA'\n" +
            "        AND best_rate.rate <> 'NA'\n" +
            "        AND best_rate.rate <> 'N/A'\n" +
            "        AND best_rate.business_loan_id = loan.id\n" +
            "        ORDER BY CAST(best_rate.minimum_rate AS DECIMAL) ASC\n" +
            "        FETCH FIRST 1 ROWS ONLY\n" +
            "    ) \n" +
            "    \n" +
            ") loan\n" +
            "WHERE loan.TYPE = ?1\n" +
            "FETCH FIRST 5 ROWS ONLY"
            , nativeQuery = true)
    List<ProjectionBestLoan> findTopFiveBusinessLoansByType(String type);

}
