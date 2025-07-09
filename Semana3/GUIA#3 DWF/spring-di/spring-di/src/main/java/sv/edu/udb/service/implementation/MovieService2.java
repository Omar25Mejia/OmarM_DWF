package sv.edu.udb.service.implementation;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.repository.MovieRepository;
import sv.edu.udb.repository.domain.Movie;
import sv.edu.udb.service.MovieService;

@Getter
@Service
public class MovieService2 implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie findMovieById(final Long id) {
        return movieRepository.findMovieById(id);
    }
}