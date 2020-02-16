package pl.sda.zad15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class Zad15Application {

	public static void main(String[] args) {
		SpringApplication.run(Zad15Application.class, args);
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 =
				User.withDefaultPasswordEncoder()
						.username("user")
						.password("user123")
						.roles("USER")
						.build();

		UserDetails user2 =
				User.withDefaultPasswordEncoder()
						.username("admin")
						.password("admin123")
						.roles("USER", "ADMIN")
						.build();

		return new InMemoryUserDetailsManager(user1, user2);
	}

}
