package ru.javawebinar.topjava.service;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

/**
 * Created by SergeiRodionov.ru on 05.10.2015.
 */
public class MyUnitRule implements MethodRule {

    private static final ResourceDatabasePopulator POPULATOR = new ResourceDatabasePopulator();

    public MyUnitRule(String script) {
        POPULATOR.addScript(new ClassPathResource(script));
    }

    @Override
    public Statement apply(final Statement base, final FrameworkMethod method, final Object target) {

        DataSource dataSource = (DataSource) ((UserMealServiceTest) target).context.getBean("dataSource");

        DatabasePopulatorUtils.execute(POPULATOR, dataSource);

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                base.evaluate();
            }
        };
    }
}
