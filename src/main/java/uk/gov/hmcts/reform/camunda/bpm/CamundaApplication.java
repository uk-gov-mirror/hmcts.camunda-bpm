package uk.gov.hmcts.reform.camunda.bpm;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableProcessApplication("sample-process")
public class CamundaApplication {

    @Autowired
    RuntimeService runtimeService;

    public static void main(String... args) {
        SpringApplication.run(CamundaApplication.class, args);
    }

    // This is only used for testing purposes
    @Bean
    public CommandLineRunner createDemoProcessInstance() {
        return (String[] args) -> runtimeService.startProcessInstanceByKey("sample-process");

    }
}
