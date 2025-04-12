## 🧞‍♂️ Sample Classification using kNN Algorithm

### How this works?
The program gets as an input two samples: iris_training.txt and iris_test.txt. Once the program is up and running, the user is prompted to enter k - number of closest neighbours to be considered. 
The program informs the user of accuracy with which the result will be returned. Later, the user is prompted again to provide dimensions of the flower - Sepal Length, Sepal Width, Petal Length and Petal Width,
after which the user receives a flower classification

### How classification works?
Classification part can be divided into 3 major components:
1. Calculating the distance
2. Using kNN Algorithm
3. Calculating the accuracy

#### Calculating the distane
The distance is calculated using Euclidean Algorithm. Formula used is shown below.

$$ 
d = \sqrt{\sum_{i=1}^{n} (a_i - b_i)^2} 
$$

#### Using kNN Algorithm

# k-Nearest Neighbors (k-NN) Algorithm

The **k-Nearest Neighbors (k-NN)** algorithm is a simple, yet powerful **supervised machine learning** algorithm used for classification and regression. It works by finding the closest data points to a given input and making predictions based on the majority class (for classification) or the average (for regression) of those nearest neighbors.

## How k-NN Works

1. **Training Phase**:
   - The k-NN algorithm does not involve any explicit training process. The algorithm simply stores the entire dataset during the training phase.

2. **Prediction Phase**:
   - When predicting a class or value for a new input, the algorithm:
     1. Calculates the **distance** between the input data point and all other points in the training set.
     2. Sorts the training points based on these distances.
     3. Selects the **k** nearest neighbors (i.e., the **k** smallest distances).
     4. **Classifies** the input based on the majority class label of the nearest neighbors (for classification).
     5. For **regression**, the output is the average of the values of the k nearest neighbors.

## Steps in k-NN

1. **Choose the number of neighbors (k)**: The value of **k** determines how many neighbors to consider for making a prediction. A small **k** can make the model sensitive to noise, while a large **k** makes it more generalized.
2. **Calculate the distance** between the input and each training example. The most common distance measure is **Euclidean distance**.
3. **Sort** the distances and **select the k-nearest neighbors**.
4. **Make the prediction**:
   - For **classification**, assign the class label that appears the most among the nearest neighbors.
   - For **regression**, compute the mean of the neighbors' values.

## Example Use Case

In this project, the k-NN algorithm is used to classify Iris flowers based on their physical measurements (e.g., sepal length, sepal width, petal length, and petal width).

For a given test sample, the algorithm:
- Computes the Euclidean distance between the test sample and each training sample.
- Selects the **k-nearest neighbors**.
- Predicts the flower type based on the majority vote of the k neighbors.

## Advantages of k-NN

- Simple and intuitive.
- Works well with small to medium-sized datasets.
- Can be used for both classification and regression tasks.

## Disadvantages of k-NN

- Computationally expensive during prediction, as it requires calculating the distance to every training point.
- Sensitive to the choice of **k** and the distance measure.
- Struggles with large datasets due to memory and time limitations.

## Usage

In this implementation, you can input the value of **k** to specify how many neighbors the algorithm should consider. The model will then calculate the accuracy on the test set and provide predictions based on new data points.
  


### Interesting question I was asked during my project defence
#### Q: How does this program predict a type of flower for k = 40?
A: There are 120 flowers that fit into 3 categories in training file. Taking random 40 flowers out of this sample gives us 33.33% chance of guessing the correct kind. 
My program performs a majority vote in order to pick with as much certainty as its possible (giving the unfavorable conditions of taking 40 flowers) closest type of the flower
