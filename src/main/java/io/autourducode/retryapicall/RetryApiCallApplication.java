package io.autourducode.retryapicall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class RetryApiCallApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetryApiCallApplication.class, args);
    }

}
