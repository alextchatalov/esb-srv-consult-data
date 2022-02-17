package br.com.bestbank.backbestbank.fixtures;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class FixtureLoader  {
    private static  final String FIXTURE_PACKAGE= "br.com.bestbank.getdataopenbanking.fixtures.resource";

    private FixtureLoader() {

    }

    public static void loadAllFixtures() {
        FixtureFactoryLoader.loadTemplates(FIXTURE_PACKAGE);
    }
}
