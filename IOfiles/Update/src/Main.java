
import java.io.*;
import java.util.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
       // String inputStatement = "i love android and java.android is  the key of mobile development.java is the most popular language.Thanks.";
        Scanner input=new Scanner(System.in);
        String filepath=input.nextLine();
        File filep=new File(filepath);
        String inputStatement="";
        String line;
        int p= 0;
        try ( FileReader read=new FileReader(filepath );
              BufferedReader buffer=new BufferedReader(read);){
            while (true){
                line=buffer.readLine();
                if (line==null) break;
                inputStatement+=line;
            }
            System.out.println(inputStatement);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String x =inputStatement.replaceAll("\\."," ").toLowerCase();
        ArrayList<Integer> counter = new ArrayList<>();
        // Count word frequency
        Map<String, Integer> wordFrequencyMap = countWordFrequency(x);
        // Output word weights
        //System.out.println("Word Weights:");
       // for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            //System.out.println(entry.getKey() + ": " + entry.getValue());
       // }

        // Count statement weights
        String[] statements = inputStatement.split("\\.");
        List<String> st=Arrays.asList(statements);
        ArrayList <String> st1=new ArrayList<>(st);
        //persintage

        System.out.println(" Enter perc : ");

        try {
            p = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("invaled input");
            return;
        }
        if (p>0&&p<=100){
            int percentage=(((statements.length)*p)/100);
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
            System.out.println(per);
            //split keys,values
            ArrayList<String> keys= new ArrayList<>();
            ArrayList<Integer> values = new ArrayList<>();
            for (Map.Entry<String, Integer> Entry : per.entrySet()) {
                keys.add(Entry.getKey());
                values.add(Entry.getValue());
            }

            System.out.println("\n percentage : \n");
           int percent2=0;
            ArrayList <String>order=new ArrayList<>();
            ArrayList<Integer> result = new ArrayList<>();
            for (int j = p; j >=10; j-=10) {
                File sumfil=new File(j+"percent.txt");
                percent2=(((statements.length)*j)/100);
                try (FileWriter winer = new FileWriter(sumfil, true);
                     BufferedWriter pr = new BufferedWriter(winer);) {
                    sumfil.createNewFile();
                    pr.write("summarization with " + j + "% percent\n");

                    for (int i = keys.size(); i > ((statements.length) - percent2); i--) {
                        System.out.println(keys.get(i - 1) + " " + values.get(i - 1));
                        order.add(keys.get(i - 1));
                    }
                    st1.retainAll(order);
                    for (int i = 0; i < st1.size(); i++) {
                        pr.write(st1.get(i ));
                        pr.newLine();
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("//////////////////////////");
            System.out.println(st1);
            System.out.println(order);}
        else{
            System.out.println(" percent out of range");
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

