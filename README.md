This is a benchmark test comparing many java frameworks focused on use minimum ram,cpu,io as possible maximazing throughput. It's also focused on use robost and powerful frameworks like

* Spring Data JPA, MVC, AOP, Security, etc.
* Hibernate

## Preparing environment

Compile packages

	./gradlew installDist

Start benchmark environemnt, enter docker container and start the tests for netty for example

```
docker-compose up -d &&\
docker exec java-resources-optimization ./spring-mvc-undertow/build/install/spring-mvc-undertow/bin/spring-mvc-undertow
```

Running the benchmark (outside docker)

	siege -v -c10 -t1m http://172.17.0.1:8081/users/1


## Specs
The test were runned at docker controlled environment then you can see and test it just looking at `docker-compose.yml` anyway my specific computer specs are at `specs` file

#### Resources Limits

Docker

```
mem_limit: 150m
cpus: 0.5
```

JVM

```
-Xmx40m -Xss256k -XX:MaxMetaspaceSize=60m
```

## Benchmarks

| Tool                 | Startup (Sec) | Transactions | Availability | Time (Sec) | Response time (Sec) | Transaction rate (trans/sec) | Concurrency | Longest transaction | Shortest transaction | Data transferred (Mb) |
|----------------------|---------------|--------------|--------------|------------|---------------------|------------------------------|-------------|---------------------|----------------------|-----------------------|
| Spring WebFlux Netty | 110.059       | 2050         | 100%         | 59.72      | 0.04                | 34.33                        | 1.54        | 1.26                | 0.00                 | 0.06                  |
| Spring MVC Tomcat    | 120.946       | 2191         | 100%         | 59.81      | 0.02                | 36.63                        | 0.87        | 0.72                | 0.0                  | 0.07                  |
| Spring MVC Undertow  | 92.526        | 2299         | 100%         | 59.30      | 0.01                | 38.77                        | 0.56        | 0.93                | 0.00                 | 0.07                  |


#### Spring WebFlow - Netty

* ![](https://i.imgur.com/43SlqMy.png)
* ![](https://i.imgur.com/ZFCiFuD.png)

### Spring MVC - Tomcat
* ![](https://i.imgur.com/p7tfQis.png)
* ![](https://i.imgur.com/jr7De6Z.png)



### Spring MVC - Undertow

* ![](https://i.imgur.com/7jaWKGX.png)
* ![](https://i.imgur.com/8ugIKnb.png)

### Spring Job - Schedule + Rabbit
In 30 seconds it sent 5000msgs to rabbit and consumed it with a 0-10 consumers range
