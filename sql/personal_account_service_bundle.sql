select distinct company.name as name,
	personal.type as type,
	CAST(minimum.value as DECIMAL) as minimum ,
	minimum.currency as minimumCurrency ,
	CAST(maximum.value as DECIMAL) as maximum,
	maximum.currency as maximumCurrency,
	participant.customer_friendly_logo_uri as customerFriendlyLogoUri
from data
inner join brand on brand.data_id = data.id
inner join company on company.brand_id = brand.id
inner join personal_account personal on personal.company_id = company.id
inner join service_bundle service on service.personal_account_id = personal.id
inner join minimum on minimum.service_bundle_id = service.id
inner join maximum on maximum.service_bundle_id = service.id
inner join participant on participant.organisation_id = brand.participant_organisation_id
where minimum.value <> 'NA'
and maximum.value <> 'NA'
and personal.type = 'CONTA_DEPOSITO_A_VISTA'
order by maximum asc
FETCH FIRST 5 ROWS ONLY