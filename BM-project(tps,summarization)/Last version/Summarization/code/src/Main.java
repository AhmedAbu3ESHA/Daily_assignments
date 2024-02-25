
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

///program with IOFILES
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.println(" enter file path : ");
        String filepath = input.nextLine();
        File filerefrance = new File(filepath);
        //check file have content
        if (filerefrance.length()==0){
            System.out.println("file is empty try another file");
            return;
        }
        System.out.println("Enter folder name:");
        String foldername = input.nextLine();
        String inputStatement = "";
        String line;
        int percent = 0;
        //take file path from user (file contane paragraph)
        try (FileReader read = new FileReader(filepath);
             BufferedReader buffer = new BufferedReader(read);) {
            while (true) {
                line = buffer.readLine();
                if (line == null) break;
                inputStatement += line;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Integer> scounter = new ArrayList<>();

        // Count statement weights
        String[] statements = inputStatement.split("\\.");
        LinkedHashSet<String> statmentHS= new LinkedHashSet<>(Arrays.asList(statements));
        ArrayList<String> statmentsAL = new ArrayList<>(statmentHS);
        String y=String.join("," ,statmentsAL);

        String x =y.replaceAll("\\,"," ").toLowerCase();

        // Count word frequency
        Map<String, Integer> wordFrequencyMap = countWordFrequency(x);
        // Output word weights
        System.out.println("Word Weights:");

        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        //take percentage and chick validation
        System.out.println("\n Enter percentage of summarization : ");
        try {
            percent = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("invaled :input must be integer value");
            return;
        }
        if (percent > 0 && percent <= 100) {
            System.out.println("\nStatement Weights:");
            List<Integer> counter = statmentsAL.stream().map(statement -> {
                int stweight = calculateStatementWeight(statement, wordFrequencyMap);
                System.out.println(statement.trim() + " : " + stweight);
                return stweight;
            }).collect(toList());

            System.out.println("\n top Sentance\n " +statmentsAL.get(counter.indexOf(Collections.max(counter)) )+" : "+ Collections.max(counter));
            System.out.println("\n Fiels created into your foler .");
            //       Sentences are arranged from largest to smallest according to their weight
            Map<String, Integer> sentansewithweight = statmentsAL.stream().collect(toMap(state -> statmentsAL.get(statmentsAL.indexOf(state)),
                    state -> counter.get(statmentsAL.indexOf(state))));
            //put statment as key,frequ as values
            // sort counter to make sentances sorted by weight in this map
            LinkedHashMap<String,Integer> sortedmap=new LinkedHashMap<>();
            int max=0;
            int index;
            for (int i = 0; i < counter.size(); i++) {
                max=Collections.max(counter);
                index=counter.indexOf(max);
                scounter.add(max);
                counter.set(index,0);
                for ( String key : sentansewithweight.keySet() ) {
                    for (int j = 0; j < scounter.size(); j++) {
                        if (scounter.get(j)==sentansewithweight.get(key)){
                            sortedmap.put(key,scounter.get(j));
                        }
                    }
                }

            }
            //split keys,values
            ArrayList<String> keys= new ArrayList<>();
            ArrayList<Integer> values = new ArrayList<>();
            for (Map.Entry<String, Integer> Entry : sortedmap.entrySet()) {
                keys.add(Entry.getKey());
                values.add(Entry.getValue());
            }
            //creating files with discard persentage
            int filespercentage= 0;
            ArrayList<String> order = new ArrayList<>();
            ArrayList<Integer> result = new ArrayList<>();
            File Folder=null;
            byte fileName=1;
            for (int j = percent; j >=10; j=j-10) {
                Folder = new File(foldername);
                Folder.mkdir();
                File Filesdifferentpercentages = new File(Folder.getAbsolutePath()+"\\"+" file number  "+fileName++);
                filespercentage =((statements.length*j) /100);
                for (int i = 0; i < filespercentage ; i++){

                    order.add(keys.get(i));
                }
                if (order.isEmpty()){
                    break;
                }
                //prevent dublicate files wich have same content
                if (result.contains(filespercentage))
                  continue;
                //each iteration result take number of sentances must add to file
                result.add(filespercentage);
                //add summarization in file
                try (FileWriter Filesdiffpercent = new FileWriter(Filesdifferentpercentages);
                     BufferedWriter bufferedWriter = new BufferedWriter(Filesdiffpercent);) {
                    Filesdifferentpercentages.createNewFile();
                    bufferedWriter.write("summarization with " + j + "% percent\n");
                    statmentsAL.retainAll(order);
                    order.clear();
                    for (int i = 0; i < statmentsAL.size(); i++) {
                        bufferedWriter.write(statmentsAL.get(i));
                        bufferedWriter.newLine();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }}
        else {
            System.out.println("persentage must be in range 0%:100%");
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