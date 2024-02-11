public class Main {
    public static void main(String[] args) {
        String s=("ah22dsl4ds4");
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i)))
            {
                s=s.replaceAll(String.valueOf(s.charAt(i)), " ");
            }
        }
        String l=s.replaceAll("\\s+", " ");
        String [] y= l.split(" ");
        for (int i = 0; i < y.length; i++) {
            System.out.println(y[i]);
            //sum=sum+Integer.parseInt(y[i]);
        }
        //System.out.println(sum);







        //number of spaces

        //Skip more than one spaces
      //  String S=s.replaceAll("\\s+", " ");
      //  String[] l = S.split(" ");
       // int num=l.length-1;
       // System.out.println( "Num of spaces: "+num);
//soultion 1
      //  String r=s.replaceAll(" ", "");
       // int space=s.length()-r.length();
       // System.out.println(space);

        //length of each word
      // String[] r = s.split(" ");
      // for (int i = 0; i < r.length; i++) {
        //   System.out.println(r[i]+" :"+r[i].length());
        }

    }



