
import java.net.SocketTimeoutException;
import java.util.*;
import java.util.Map;
///////first edition of this program
public class Main3 {
    public static void main(String[] args) {
        String inputStatement = "i love android and java. android is  the key of mobile development. java is the most popular language. We all fall in the lve of the android. the teamwork is perfect and we are all collaborative. The teams are working very hard to achieve the target. They are trying their best to get the task done. we are trying our best in coding. Facing many errors were challenging for us.But as a teammebers we solve them together.";
        //String inputStatement = " ".replaceAll("\\s+","");
       // if (inputStatement.isEmpty()) return;
        String x =inputStatement.replaceAll("\\."," ").toLowerCase();
        ArrayList<Integer> counter = new ArrayList<>();
        ArrayList<Integer> scounter = new ArrayList<>();
        // Count word frequency
        Map<String, Integer> wordFrequencyMap = countWordFrequency(x);
        // Output word weights
        System.out.println("Word Weights:");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Count statement weights
        String[] statements = inputStatement.split("\\.");
        List<String> st = Arrays.asList(statements);
        ArrayList<String> statmentsAL = new ArrayList<>(st);
        //persintage
        int percentage=(((statmentsAL.size())*50)/100);
        System.out.println("\nStatement Weights:");
        int statementWeight;
        for (String statement : statements) {
            statementWeight = calculateStatementWeight(statement, wordFrequencyMap);
            counter.add(statementWeight);
            System.out.println("\"" + statement.trim() + "\": " + statementWeight);
        }
        System.out.println("\n top \n " +statements[counter.indexOf(Collections.max(counter))] +" : "+ Collections.max(counter));
        LinkedHashMap<String,Integer>  sentansewithweight=new LinkedHashMap<>();
        for (int i = 0; i < counter.size(); i++) {
            sentansewithweight.put(statmentsAL.get(i),counter.get(i));
        }
        //System.out.println(sentansewithweight);
        //put statment as key,frequ as values
        LinkedHashMap<String,Integer> per=new LinkedHashMap<>();
        int max=0;
        int index;
        System.out.println(counter);
        for (int i = 0; i < counter.size(); i++) {
            max=Collections.max(counter);
            index=counter.indexOf(max);
            scounter.add(max);
            counter.set(index,0);
            for ( String key : sentansewithweight.keySet() ) {
                for (int j = 0; j < scounter.size(); j++) {
                    if (scounter.get(j)==sentansewithweight.get(key)){
                        per.put(key,scounter.get(j));
                    }
                }
            }
        }
        System.out.println(scounter);
        System.out.println("///////");
        System.out.println(per);
        //split keys,values
        ArrayList<String> keys= new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();
        for (Map.Entry<String, Integer> Entry : per.entrySet()) {
            keys.add(Entry.getKey());
            values.add(Entry.getValue());
        }
        System.out.println(values);
        System.out.println("\n percentage : \n");
        for (int i = 0; i < percentage ; i++) {
            System.out.println( keys.get(i)+" "+values.get(i));
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

