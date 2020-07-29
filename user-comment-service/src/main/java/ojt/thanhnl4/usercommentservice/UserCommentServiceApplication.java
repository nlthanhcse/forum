package ojt.thanhnl4.usercommentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserCommentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCommentServiceApplication.class, args);
	}

}
