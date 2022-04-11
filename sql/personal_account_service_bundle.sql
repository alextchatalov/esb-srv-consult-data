select distinct company.name, personal.type, minimum.value::DECIMAL as minimum , minimum.currency ,maximum.value::DECIMAL as maximum, maximum.currency
from data
inner join brand on brand.data_id = data.id
inner join company on company.brand_id = brand.id
inner join personal_account personal on personal.company_id = company.id
inner join service_bundle service on service.personal_account_id = personal.id
inner join minimum on minimum.service_bundle_id = service.id
inner join maximum on maximum.service_bundle_id = service.id
where minimum.value <> 'NA'
and maximum.value <> 'NA'
and personal.type = 'CONTA_DEPOSITO_A_VISTA'
order by maximum desc