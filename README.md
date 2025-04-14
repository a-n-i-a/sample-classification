# 🧞‍♂️ Sample Classification using kNN Algorithm

## How this works?
The program gets as an input two samples: iris_training.txt and iris_test.txt. Once the program is up and running, the user is prompted to enter k - number of closest neighbours to be considered. 
The program informs the user of accuracy with which the result will be returned. Later, the user is prompted again to provide dimensions of the flower - Sepal Length, Sepal Width, Petal Length and Petal Width,
after which the user receives a flower classification

## How classification works?
Classification part can be divided into 3 major components:
1. Calculating the distance
2. Using kNN Algorithm
3. Calculating the accuracy

### Calculating the distance
The distance is calculated using Euclidean Algorithm. Formula used is shown below.

$$ 
d = \sqrt{\sum_{i=1}^{n} (a_i - b_i)^2} 
$$

### Using kNN Algorithm
The **k-Nearest Neighbors (k-NN)** algorithm is a simple algorithm used for classification and regression. It works by finding the closest data points to a given input and making predictions based on the majority class (for classification) or the average (for regression) of those nearest neighbors.


#### Graph by Sepal
<img width="676" alt="Screenshot 2025-04-14 at 02 03 47" src="https://github.com/user-attachments/assets/fb8c5002-ba62-4e17-8fcc-9de0b2e7a6f0" />


#### Graph by Petal
<img width="659" alt="Screenshot 2025-04-14 at 02 03 32" src="https://github.com/user-attachments/assets/309b3486-8d2a-4eea-ab2c-abf2eaaaa409" />

### Calculating the accuracy
The program performs a majority vote for the most common class for given k. For best results, it is best to keep k relatively small but bigger than 3. After some point, the bigger k is, the least accurate the output will be.

### Interesting question I was asked during my project defence
#### Q: How does this program predict a type of flower for k = 40?
A: There are 120 flowers that fit into 3 categories in training file. Taking random 40 flowers out of this sample gives us 33.33% chance of guessing the correct kind. 
My program performs a majority vote in order to pick with as much certainty as its possible (giving the unfavorable conditions of taking 40 flowers) closest type of the flower
