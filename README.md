How to Work

Data Model: The system loads user-item preferences from CSV file
Similarity Metric: Uses Pearson correlation to find users with similar preferences
Neighborhood: Identifies clusters of similar users based on similarity threshold
Recommendation Engine: Generates predictions for items the user hasn't rated yet
Output: Shows top 3 product recommendations for user 1 with predicted preference scores
Running the Program

Running the Program

Compile: javac -cp ".:mahout-core-0.9.jar:mahout-integration-0.9.jar" ProductRecommender.java
Execute: java -cp ".:mahout-core-0.9.jar:mahout-integration-0.9.jar" ProductRecommender
