package br.com.bestbank.backbestbank.fixtures.resource;

import br.com.bestbank.getdataopenbanking.core.model.MinimumBalance;
import br.com.bestbank.getdataopenbanking.core.model.TermsConditions;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class TermsConditionsFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(TermsConditions.class).addTemplate(VALID, new Rule() {{
            add(TermsConditions.Fields.minimumBalance, createMinimumBalance());
            add(TermsConditions.Fields.elegibilityCriteriaInfo, "test");
            add(TermsConditions.Fields.closingProcessInfo, "1");

        }});
    }

    private MinimumBalance createMinimumBalance() {
        return MinimumBalance.builder()
                .currency("123")
                .value("123")
                .build();
    }

}
