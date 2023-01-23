package tech.outatime.moviereviewsapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "movies") // MongoDB Collection name
@Data //from Lombok - take care of all getters and setters and methods
@AllArgsConstructor // Creating a  constructor that takes all this private fields as arguments
@NoArgsConstructor // Constructor that takes no parameters
public class Movie {
    @Id // It let Spring know that this property should be treated as unique identifier for each movie
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String > genres;
    private List<String > backdrops;
    @DocumentReference //This will cause to DB to store only the IDs of the review and reviews itself will be in separate collection. This is called 'manual reference relationship'
    private List<Review> reviewIds; // Embedded relationship. Ok if modeling relationship 'one to many'. One movie can have many reviews
}
