This is a benchmark test comparing many java frameworks focused on use minimum ram,cpu,io as possible maximazing throughput. It's also focused on use robost and powerful frameworks like

* Spring Data JPA, MVC, AOP, Security, etc.
* Hibernate

## Preparing environment

Compile packages

	./gradlew installDist

Start benchmark environemnt

	docker-compose up -d

Enter docker container and start the tests

	$ docker exec -it bash java-resources-optimization

## Specs
The test were runned at docker controlled environment then you can see and test it just looking at `docker-compose.yml` anyway my specific computer specs are at `specs` file

## Benchmarks

### Spring Netty Web Flux
Now Spring is reactive with spring webflux, it also uses netty, a lighweight servlet container

#### Resources Limits

Docker

```
mem_limit: 120m
cpus: 0.5
```

JVM

```
JAVA_OPTS='-Xmx40m -Xss256k -XX:MaxMetaspaceSize=60m' &&\
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote" &&\
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.port=9010" &&\
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.local.only=false" &&\
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.password.file=src/main/resources/passwd.properties" &&\
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.access.file=src/main/resources/access.properties" &&\
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.ssl=false" && \
export JAVA_OPTS &&
./spring/netty-webflux/build/install/spring/netty-webflux/bin/spring/netty-webflux
```

#### Stress Test
```
$ siege -v -c5 -t2m http://...:8081/users/1
Lifting the server siege...
Transactions:		        2070 hits
Availability:		      100.00 %
Elapsed time:		      119.64 secs
Data transferred:	        0.00 MB
Response time:		        0.03 secs
Transaction rate:	       17.30 trans/sec
Throughput:		        0.00 MB/sec
Concurrency:		        0.57
Successful transactions:        2070
Failed transactions:	           0
Longest transaction:	        1.04
Shortest transaction:	        0.00
```


#### VisualVM Results

* ![Spring Web Flux Java 8 Metaspace](https://i.imgur.com/rtPUjuf.png)
* ![Spring Web Flux Java 8 Heap/CPU](https://i.imgur.com/ERuiEky.png)
