
import java.net.SocketTimeoutException;
import java.util.*;
import java.util.Map;

public class Project1 {
    public static void main(String[] args) {
        //String inputStatement = "i love android and java.android is  the key of mobile development.java is the most popular language.Thanks.";
        String inputStatement = " ".replaceAll("\\s+","");
        if (inputStatement.isEmpty()) return;
        String x =inputStatement.replaceAll("\\."," ").toLowerCase();
        ArrayList<Integer> counter = new ArrayList<>();
        // Count word frequency
        Map<String, Integer> wordFrequencyMap = countWordFrequency(x);
        // Output word weights
        System.out.println("Word Weights:");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Count statement weights
        String[] statements = inputStatement.split("\\.");
        //persintage
        int percentage=(((statements.length)*100)/100);
        System.out.println("\nStatement Weights:");
        int statementWeight;
        for (String statement : statements) {
            statementWeight = calculateStatementWeight(statement, wordFrequencyMap);
            counter.add(statementWeight);
            System.out.println("\"" + statement.trim() + "\": " + statementWeight);
        }
        System.out.println("\n top \n " +statements[counter.indexOf(Collections.max(counter))] +" : "+ Collections.max(counter));
      //put statment as key,frequ as values
        HashMap<String,Integer> per=new HashMap<>();
        for (int i = 0; i < counter.size(); i++) {
            per.put(statements[i],counter.get(i));
        }
        //split keys,values
        ArrayList<String> keys= new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();
        for (Map.Entry<String, Integer> Entry : per.entrySet()) {
            keys.add(Entry.getKey());
            values.add(Entry.getValue());
        }

        System.out.println("\n percentage : \n");
       for (int i = keys.size(); i > ((statements.length)-percentage) ; i--) {
           System.out.println( keys.get(i-1)+" "+values.get(i-1));
        }

    }
    private static Map<String, Integer> countWordFrequency(String input) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        String[] words = input.split("\\s+");
        for (String word : words) {
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


