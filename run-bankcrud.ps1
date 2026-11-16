$ErrorActionPreference = 'Stop'
Push-Location $PSScriptRoot
try {
    & mvn test `
        '-Dtest=RunCucumberTest' `
        '-Dcucumber.features=src/test/java/com/osa/features/BankCrud.feature' `
        '-Dcucumber.filter.tags=@bankCrudGET' `
        '-Dcucumber.execution.dry-run=false'
    if ($LASTEXITCODE -ne 0) {
        throw 'BankCRUD tests failed. Check the Maven output and target/cucumber-reports/index.html.'
    }
}
finally {
    Pop-Location
}
