
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Project1 {
    public static void main(String[] args) {


        String inputStatement = "i love android and java. java is most popular language. android is key to mobile development.";
        ArrayList<Integer> counter = new ArrayList<>();
        int statementWeight;
        // Count word frequency
        Map<String, Integer> wordFrequencyMap = countWordFrequency(inputStatement);

        // Output word weights
        System.out.println("Word Weights:");

        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Count statement weights
        String[] statements = inputStatement.split("\\.");
        System.out.println("\nStatement Weights:");
        for (String statement : statements) {
            statementWeight = calculateStatementWeight(statement, wordFrequencyMap);
            counter.add(statementWeight);
            System.out.println("\"" + statement.trim() + "\": " + statementWeight);

        }
        int index= Collections.max(counter);
        System.out.println("\n top \n " +statements[counter.indexOf(index)] +" : "+ index);
    }
    private static Map<String, Integer> countWordFrequency(String input) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        String[] words = input.split("\\s+");

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase(); // Remove non-alphabetic characters
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        return wordFrequencyMap;
    }

    private static int calculateStatementWeight(String statement, Map<String, Integer> wordFrequencyMap) {
        String[] words = statement.split("\\s+");
        int statementWeight = 0;

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase(); // Remove non-alphabetic characters
            statementWeight += wordFrequencyMap.getOrDefault(word, 0);

        }


        return statementWeight;
    }
}


