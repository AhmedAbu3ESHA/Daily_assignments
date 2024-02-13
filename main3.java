import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//we have filmes need to know its category and if we hava category we need films
public class main3 {
    public static void main(String[] args)
    {
        Scanner film = new Scanner(System.in);
        System.out.println(" enter input ");
        String input = "";
        ArrayList<String> films = new ArrayList<>();
        Collections.addAll(films,"saw","finaldistination","lightout");
        ArrayList<String> cat = new ArrayList<>();
        Collections.addAll(cat,"horrer","action","horrer");
        ArrayList<Integer> counter = new ArrayList<>();
        ArrayList<String> matchedNames = new ArrayList<>();

        while (true) {
            input = film.next();
            if (input.equals("exit")) break;
            matchedNames.add(input);
//check input is film
        if (films.contains(input))
        {
            int index=films.indexOf(input);
            System.out.println(cat.get(index));
//check input is category
        } else if (cat.contains(input)) {
            for (int i = 0; i < cat.size(); i++) {
                if (cat.get(i).equals(input)){
                System.out.println(films.get(i));}
            }

        }

        }
        //most searched film
        for (String s : films) {
            counter.add(Collections.frequency(matchedNames, s));
        }
        int max = Collections.max(counter);
        int index = counter.indexOf(max);
        System.out.println(films.get(index));

    }}
