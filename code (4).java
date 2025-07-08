import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.List;

public class ProductRecommender {
    
    public static void main(String[] args) {
        try {
            // Load sample data (user-item preferences)
            DataModel model = new FileDataModel(new File("data.csv"));
            
            // Define similarity metric between users
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
            
            // Define neighborhood of similar users
            UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
            
            // Create recommender engine
            UserBasedRecommender recommender = new GenericUserBasedRecommender(
                model, 
                neighborhood, 
                similarity);
            
            // Get recommendations for user with ID 1 (3 recommendations)
            List<RecommendedItem> recommendations = recommender.recommend(1, 3);
            
            System.out.println("\nProduct Recommendations for User 1:");
            for (RecommendedItem recommendation : recommendations) {
                System.out.printf("Product ID: %d, Estimated Preference: %.2f%n",
                    recommendation.getItemID(),
                    recommendation.getValue());
            }
            
        } catch (Exception e) {
            System.err.println("Error in recommendation engine: " + e.getMessage());
        }
    }
}
