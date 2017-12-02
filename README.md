This is a benchmark test comparing many java frameworks focused on use minimum ram,cpu,io as possible maximazing throughput. It's also focused on use robost and powerful frameworks like

* Spring Data JPA, MVC, AOP, Security, etc.
* Hibernate

## Specs
The test were runned at docker controlled environment then you can see and test it just looking at `docker-compose.yml` anyway my specific computer specs are at `specs` file

## Benchmarks

### Spring Netty Web Flux
Now Spring is reactive with spring webflux, it also uses netty, a lighweight servlet container

![Spring Web Flux Java 8 Metaspace](https://i.imgur.com/rtPUjuf.png)
![Spring Web Flux Java 8 Heap/CPU](https://i.imgur.com/ERuiEky.png)