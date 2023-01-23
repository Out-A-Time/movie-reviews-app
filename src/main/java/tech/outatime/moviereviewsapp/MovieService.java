package tech.outatime.moviereviewsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired //It will let Spring know that we want to instantiate this class here
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        System.out.println((movieRepository.findAll().toString()));
        return movieRepository.findAll();
    }
}
