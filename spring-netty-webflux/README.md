#### Running and testing 

	$ ./gradlew run
	$ curl -s -XGET http://localhost:8080/users/1 | jq .

#### Reference
* https://dzone.com/articles/spring-5-reactive-web-services
* https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html
* https://spring.io/blog/2016/07/28/reactive-programming-with-spring-5-0-m1
* https://github.com/poutsma/web-function-sample/blob/master/src/main/java/org/springframework/samples/web/reactive/function/DummyPersonRepository.java
* https://dzone.com/articles/spring-reactive-samples
* https://docs.spring.io/spring-framework/docs/5.0.0.M1/spring-framework-reference/html/web-reactive.html


#### Testing performance at docker in a limited resources environment

Connect using visualvm `adding jmx connection`

```bash
JAVA_OPTS='-Xmx40m -Xss256k -XX:MaxMetaspaceSize=60m' &&\
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote" &&\
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.port=9010" &&\
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.local.only=false" &&\
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.password.file=passwd.properties" &&\
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.access.file=access.properties" &&\
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.ssl=false" && \
export JAVA_OPTS &&
./spring-web-reactive/bin/spring-web-reactive
```
