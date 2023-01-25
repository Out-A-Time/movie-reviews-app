package tech.outatime.moviereviewsapp;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired //It will let Spring know that we want to instantiate this class here
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        System.out.println((movieRepository.findAll().toString()));
        return movieRepository.findAll();
    }

    public Optional<Movie> getSingleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
