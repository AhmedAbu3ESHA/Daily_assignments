public class Main {
    public static void main(String[] args) {
        String s = ("ah22dsl4ds4");
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                s = s.replaceAll(String.valueOf(s.charAt(i)), " ");
            }
        }
        String l = s.replaceAll("\\s+", " ");
        String u=l.trim();
        String[] y = u.split(" ");
        for (int i = 0; i < y.length; i++) {
            System.out.println(y[i]);
            sum=sum+Integer.parseInt(y[i]);
        }
        System.out.println(sum);
    }}