package com.thehecklers.brpsink220snapshot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@SpringBootApplication
public class BrpSink220snapshotApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrpSink220snapshotApplication.class, args);
    }

}

@Configuration
class GateAgent {
    @Bean
	Consumer<Flux<Customer>> logIt() {
    	return flux -> flux.subscribe(System.out::println);
	}
//    Consumer<Customer> logIt() {
//        return System.out::println;
//    }
}

@Value
class Customer {
    private final String id, name;
}