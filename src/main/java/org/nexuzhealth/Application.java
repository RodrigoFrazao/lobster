package org.nexuzhealth;

import com.embabel.agent.config.annotation.EnableAgents;
import com.embabel.agent.config.annotation.McpServers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAgents(mcpServers = {
        McpServers.DOCKER_DESKTOP
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}