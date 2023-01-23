package tech.outatime.moviereviewsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies") // Controller to endpoint
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
//         We are returning a response entity of type list movie.
        return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);

//        public ResponseEntity<String> getAllMovies(){
//        return new ResponseEntity<String >("All movies list HERE!", HttpStatus.OK);
    }
}
