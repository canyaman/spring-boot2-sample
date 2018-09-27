# Spring Boot Sample Application

### Development run application via gradle

Run on embedded server
```console
$ ./gradlew bootRun
```

Run with active profile
```console
$ ./gradlew bootRun --args='--spring.profiles.active=mssql'
```

Continues build on the second terminal
```console
$ ./gradlew build --continuous
```

### Docker

Generate image via gradle
```console
$ ./gradlew docker
```

Run mssql server
```
export DATABASE_NAME=book
export DATABASE_USER=sa
export DATABASE_PASSWORD=Passw0rd123
export DATABASE_HOST=127.0.0.1
export DATABASE_PORT=1433
$ docker run -e 'ACCEPT_EULA=Y' -e SA_PASSWORD=$DATABASE_PASSWORD -p $DATABASE_PORT:1433 -d microsoft/mssql-server-linux:2017-latest
```

Run docker image if version is not semantic versioning
```console
$ docker run me.yaman.can/sample:latest
```

Run docker image if version is semantic versioning
```console
$ docker run me.yaman.can/sample:0.0.1
docker ${project.group}/${bootJar.baseName}:${project.version}
```

### Formatting

Linting src files
```console
$ ./gradlew ktlintFormat
```

### Liveness
Liveness probe end point is
```
curl http://localhost:8080/sample/actuator/info
``` 

### Readiness
Readiness is controlled by health check
```
curl http://localhost:8080/sample/actuator/health
```

