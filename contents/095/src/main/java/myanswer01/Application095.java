package myanswer01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application095 {
    public static void main(String[] args) {
        SpringApplication.run(Application095.class, args);
        // -Djava.net.preferIPv4Stack=true
//        2023-10-27T01:21:46.632+09:00  INFO 2470 --- [nio-8080-exec-2] myanswer01.aop.AopComponent                  : 127.0.0.1
    }
}
