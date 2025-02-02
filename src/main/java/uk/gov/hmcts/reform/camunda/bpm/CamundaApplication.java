package uk.gov.hmcts.reform.camunda.bpm;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableProcessApplication("example-processs")
@EnableFeignClients(basePackages =
    {
        "uk.gov.hmcts.reform.authorisation",
        "uk.gov.hmcts.reform.camunda.bpm",
    })
public class CamundaApplication {

    @Autowired
    RuntimeService runtimeService;

    public static void main(String... args) {
        SpringApplication.run(CamundaApplication.class, args);
    }

    // This is only used for testing purposes
    @Bean
    public CommandLineRunner createDemoProcessInstance() {
        return (String[] args) -> runtimeService.startProcessInstanceByKey("example-processs");

    }
}
