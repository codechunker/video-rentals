package energy.rensource.videorentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class VideoRentalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoRentalsApplication.class, args);
	}

}
