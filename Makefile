ALLURE_BIN := .allure/allure-2.29.0/bin/allure

# Run all tests (ignore failures so report still generates)
test:
	mvn clean test -Dmaven.test.failure.ignore=true

# Generate Allure HTML report from results
report:
	mvn allure:report

# Open the generated report in browser
open:
	$(ALLURE_BIN) open target/site/allure-maven-plugin

# Run tests + generate + open report in one command
all: test report open

# Run only smoke tests
smoke:
	mvn clean test -Dcucumber.filter.tags="@smoke" -Dmaven.test.failure.ignore=true

# Run only negative tests
negative:
	mvn clean test -Dcucumber.filter.tags="@negative" -Dmaven.test.failure.ignore=true

# Run only E2E tests
e2e:
	mvn clean test -Dcucumber.filter.tags="@e2e" -Dmaven.test.failure.ignore=true

.PHONY: test report open all smoke negative e2e
