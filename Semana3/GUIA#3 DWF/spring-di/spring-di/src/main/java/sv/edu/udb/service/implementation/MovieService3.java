package sv.edu.udb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sv.edu.udb.repository.MovieRepository;
import sv.edu.udb.repository.implementation.MovieRepositoryImpl;
import sv.edu.udb.service.MovieService;
import sv.edu.udb.service.implementation.MovieServiceImplConstructor;

@Configuration
public class AppConfig {

    @Bean
    public MovieRepository movieRepository() {
        return new MovieRepositoryImpl(); // Tu implementación real
    }

    @Bean
    public MovieService movieService() {
        return new MovieServiceImplConstructor(movieRepository());
    }
}