import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class MPP1 {
    private List<String> trainingNames = new ArrayList<>();
    private List<List<Double>> trainingVectors = new ArrayList<>();
    private List<String> testNames = new ArrayList<>();
    private List<List<Double>> testVectors = new ArrayList<>();
    String BLUE = "\u001B[94m";
    String RESET = "\u001B[0m";



    public void readFile(String filepath) {
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");

                List<Double> vectors = new ArrayList<>();
                for (int i = 0; i < parts.length - 1; i++) {
                    String number = parts[i].replace(',', '.');
                    vectors.add(Double.parseDouble(number));
                }
                if(filepath.contains("training")){
                    trainingVectors.add(vectors);
                    trainingNames.add(parts[parts.length-1]);
                } else {
                    testVectors.add(vectors);
                    testNames.add(parts[parts.length-1]);
                }

            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public double euclidean(List<Double> a, List<Double> b) {
        double sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += Math.pow(a.get(i) - b.get(i), 2);
        }
        return Math.sqrt(sum);
    }

    public String classifyUsingK(List<Double> testSamples, int k) {
        List<Map.Entry<Double, String>> distances = new ArrayList<>();

        for (int i = 0; i < trainingVectors.size(); i++) {
            double distance = euclidean(testSamples, trainingVectors.get(i));
            distances.add(new AbstractMap.SimpleEntry<>(distance, trainingNames.get(i)));
        }

        Collections.sort(distances, (a,b) -> Double.compare(a.getKey(), b.getKey()));

        List<Map.Entry<Double, String>> nn = distances.subList(0, Math.min(k, distances.size()));

        Map<String, Integer> votes = new HashMap<>();
        for(Map.Entry<Double, String> neignbour : nn) {
            String name = neignbour.getValue();
            votes.put(name, votes.getOrDefault(name, 0) + 1);
        }

        String mostPopularCategory = "";
        int mostVotes = 0;
        for(Map.Entry<String, Integer> entry : votes.entrySet()) {
            if(entry.getValue() > mostVotes) {
                mostVotes = entry.getValue();
                mostPopularCategory = entry.getKey();
            }
        }

//        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
//            System.out.println("Vote for " + entry.getKey() + ": " + entry.getValue());
//        }


        return mostPopularCategory;

    }

    public void accuracy(int k) {
        int correct = 0;
        for (int i = 0; i < testVectors.size(); i++) {
          String classification = classifyUsingK(testVectors.get(i), k);

          if(classification.equals(testNames.get(i))){
              correct++;
              //System.out.println("classification: " + classification + " actual " + testNames.get(i));
          }

//          if(!classification.equals(testNames.get(i))) {
//              System.out.println("!classification: " + classification + " actual " + testNames.get(i));
//          }

        }
        double acccuracy = (correct / (double) testVectors.size()) * 100;

        System.out.println(BLUE + "Accuracy: " + RESET + String.format("%.3f", acccuracy) + "%");
        System.out.println(BLUE + correct + RESET + " correctly classified samples out of " + BLUE + testVectors.size() + RESET);
    }

    public static void main(String[] args) {
        MPP1 mpp = new MPP1();
        mpp.readFile("src/iris_training.txt");
        mpp.readFile("src/iris_test.txt");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k: ");
        int k = sc.nextInt();

        mpp.accuracy(k);

        while (true) {
            System.out.println("Enter sample of an Iris. Type in [STOP] to exit");
            String in = sc.next();
            if(in.equalsIgnoreCase("stop")) {
                System.out.println("Exiting...");
                return;
            }
            
            List<Double> sampleOfIris = new ArrayList<>();
            sampleOfIris.add(Double.parseDouble(in.replace(',', '.')));

            for (int i = 1; i < 4; i++) {
                sampleOfIris.add(sc.nextDouble());
            }

            String name = mpp.classifyUsingK(sampleOfIris, k);
            System.out.println("This iris is " + name);
        }

    }

}
