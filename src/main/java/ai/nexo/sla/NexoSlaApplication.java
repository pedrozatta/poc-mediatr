package ai.nexo.sla;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.spring.SpringMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NexoSlaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexoSlaApplication.class, args);
    }

    private final ApplicationContext applicationContext;

    @Autowired
    public NexoSlaApplication(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public Mediator mediator() {
        return new SpringMediator(applicationContext);
    }

}
