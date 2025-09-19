# Playwright-training

# Run test
Run test defined in testng.xml
mvn test -DsuiteXmlFile=testng.xml

Run a specific test class instead of the whole suite.
mvn test -Dtest=<Testcase name (can add wildcard /*/ )>

Run only the test methods in a specific group (if you used @Test(groups="...") in your code)
mvn test -Dgroups=<Group name>

Exclude a group from execution.
mvn test -DexcludedGroups=<Group name>

mvn clean install -DskipTests

# Generate report
allure generate allure-results --clean -o target/allure-report-$(date +%Y%m%d_%H%M%S)
allure generate allure-results --single-file --output target/allure-report --clean