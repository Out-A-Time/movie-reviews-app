package tech.outatime.moviereviewsapp;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies") // Controller to the endpoint
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
//         We are returning a response entity of type list movie.
        return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK); //gets request from a user and returning a response.
        //it's using a service class and delegating that task of fetching all the movies from the DB.
        // it calls all movies method inside

//        public ResponseEntity<String> getAllMovies(){
//        return new ResponseEntity<String >("All movies list HERE!", HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.getSingleMovie(imdbId), HttpStatus.OK);
    }
}
