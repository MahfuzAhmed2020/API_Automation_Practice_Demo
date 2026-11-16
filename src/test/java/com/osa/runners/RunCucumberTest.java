package com.osa.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/com/osa/features/BankCrud.feature",
    glue = "com.osa.steps",
    tags = "@regression",
    //@bankCrud @bankCreate @bankCrudGET @PUT_UPDATE @GET_one @DELETE_one @all_accounts @getAccountsByID  @regression
    plugin = {
        "pretty",
        "html:target/cucumber-reports/index.html",
        "json:target/cucumber-reports/cucumber.json"
    },
    monochrome = true,
    dryRun = false
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
