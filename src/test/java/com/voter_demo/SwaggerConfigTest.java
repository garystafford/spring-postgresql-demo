package com.voter_demo;

import liquibase.integration.spring.SpringLiquibase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.spring.web.plugins.Docket;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SwaggerConfigTest {

    @Autowired
    private SwaggerConfig swaggerConfig;

    @BeforeClass
    public static void switchOffLiquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setShouldRun(false);
    }

    @Test
    public void apiInfo_Docket_DocumentationType_Swagger() {
        Docket docket = swaggerConfig.api();
        assertThat(docket.getDocumentationType().getName().equals("swagger")).isTrue();
        assertThat(docket.getDocumentationType().getVersion().equals("2.0")).isTrue();
    }

}
