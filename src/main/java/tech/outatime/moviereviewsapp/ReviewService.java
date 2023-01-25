package tech.outatime.moviereviewsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        //We will for a movie with the given ID, then we will create new review
        //and associate that review with the found movie
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class).
                matching(Criteria.where("imdbId").is(imdbId)).
                apply(new Update().push("reviewIds").value(review)).
                first();
        System.out.println("Movie Review added: " + imdbId + reviewBody+ review);

        return review;
    }
}
