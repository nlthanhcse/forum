package ojt.thanhnl4.forumserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ForumServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumServerApplication.class, args);
	}

}
