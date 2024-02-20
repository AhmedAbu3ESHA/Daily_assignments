
import java.io.*;
import java.util.*;
import java.util.Map;
///program with IOFILES
public class Main {
    public static void main(String[] args) {
        // if (inputStatement.isEmpty()) return;
        Scanner input=new Scanner(System.in);
        System.out.println(" enter file path : ");
        String filepath = input.nextLine();
        File filerefrance = new File(filepath);
        System.out.println("Enter folder name:");
        String foldername = input.nextLine();
        String inputStatement = "";
        String line;
        int persent = 0;
        //take file path from user (file contane paragraph)
        try (FileReader read = new FileReader(filepath);
             BufferedReader buffer = new BufferedReader(read);) {
            while (true) {
                line = buffer.readLine();
                if (line == null) break;
                inputStatement += line;
            }
            System.out.println(inputStatement);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        ArrayList<Integer> counter = new ArrayList<>();
        ArrayList<Integer> scounter = new ArrayList<>();

        // Count statement weights
        String[] statements = inputStatement.split("\\.");


        LinkedHashSet<String> statmentHS= new LinkedHashSet<>(List.of(statements));

        ArrayList<String> statmentsAL = new ArrayList<>(statmentHS);
        String y=String.join("," ,statmentsAL);
        System.out.println("lllllllllllllllllllllllllllllllllllllllllll");
        System.out.println(y);
        String x =y.replaceAll("\\,"," ").toLowerCase();
        System.out.println(x);
        // Count word frequency
        Map<String, Integer> wordFrequencyMap = countWordFrequency(x);
        // Output word weights
        System.out.println("Word Weights:");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //take persintage
        System.out.println(" Enter perc : ");
        try {
            persent = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("invaled input");
            return;
        }
        if (persent > 0 && persent <= 100) {
           // int percentage=((statmentsAL.size()*persent)/100);
            System.out.println("\nStatement Weights:");
            int statementWeight;
            for (String statement : statmentsAL) {
                statementWeight = calculateStatementWeight(statement, wordFrequencyMap);
                counter.add(statementWeight);
                System.out.println("\"" + statement.trim() + "\": " + statementWeight);
            }
            System.out.println("\n top \n " +statmentsAL.get(counter.indexOf(Collections.max(counter)) )+" : "+ Collections.max(counter));
            //       Sentences are arranged from largest to smallest according to their weight

            LinkedHashMap<String,Integer>  sentansewithweight=new LinkedHashMap<>();
            for (int i = 0; i < counter.size(); i++) {
                sentansewithweight.put(statmentsAL.get(i),counter.get(i));
            }
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.println(sentansewithweight);
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
            //System.out.println(scounter);
            //System.out.println("///////");
            //System.out.println(sortedmap);

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
            for (int j = persent; j >= 10; j=j-10) {
                File Folder = new File(foldername);
                Folder.mkdir();
                File Filesdifferentpercentages = new File(Folder.getAbsolutePath()+"\\"+j+"% percent");
                filespercentage = ((statements.length*j) /100);
                for (int i = 0; i < filespercentage ; i++){
                    // System.out.println(keys.get(i) + " " + values.get(i));
                    order.add(keys.get(i));
                }
                if (order.isEmpty()){
                    break;
                }
                try (FileWriter Filesdiffpercent = new FileWriter(Filesdifferentpercentages, true);
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
            }
        }else {
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

