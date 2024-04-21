GRADLE := ./gradlew
NAME := graphql-spring
DB_PROCESS_ID = $(shell docker ps | grep postgres | awk '{print $$1}' | head -n 1)

clean:
	${GRADLE} clean

test:
	${GRADLE} test

build:
	${GRADLE} build

run:
	${GRADLE} bootRun

deps:
	${GRADLE} dependencies

docker-bash-db:
	docker exec --user postgres -it ${DB_PROCESS_ID} /bin/bash
