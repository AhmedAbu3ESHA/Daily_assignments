
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int numberOfTransaction=0;
        int failedTransaction=0 ;
        Scanner s = new Scanner(System.in);
        List<AccountHolder> clientData;
        ArrayList<AccountHolder> accountHolder=new ArrayList<>();
        String line= null;
        String lastWord;
        List<String> Lastwords = new ArrayList<>();
        File balanceSheet = new File("data.txt");
        try (FileReader fileReader = new FileReader("data.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                lastWord = line.substring(line.lastIndexOf(" ") + 1);
                if (!lastWord.equals("----")){
                    Lastwords.add(lastWord);
                    continue;
                }
                clientData=(new ArrayList<AccountHolder>(Arrays.asList(new AccountHolder(Lastwords.get(0),Lastwords.get(1), Double.parseDouble(Lastwords.get(2))))));
                accountHolder.add(clientData.get(0));
                Lastwords.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AccountHolder acc = new AccountHolder();
        while (true) {

            System.out.println("\n"+"-------------------------"+"\n"+"please select transaction "+"\n");
            System.out.println("1 journal");
            System.out.println("2 balance sheet ");
            System.out.println("3 transactions count");
            System.out.println("4 accounts names with highest balances");
            System.out.println("5 exit");
            String selectedTransaction = s.next();
            boolean check= false;
            if (selectedTransaction.equals("5") || selectedTransaction.equalsIgnoreCase("exit")) {
                try (FileWriter writer=new FileWriter("data.txt");
                     BufferedWriter pr=new BufferedWriter(writer);) {
                     for (int i = 0; i < accountHolder.size();i++ ){
                         pr.write(String.valueOf("name: "+accountHolder.get(i).getCustomerName()+"\n"+"accountNumber: "+accountHolder.get(i).getAccountNumber()+ "\n" +"balance: "+(accountHolder.get(i).getAccountBalance())+"\n"+"----"+"\n"));
                     }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                return;}

            else if (selectedTransaction.equals("1") || selectedTransaction.equalsIgnoreCase("journal")) {
                while (true){
                System.out.println("transaction type or Exit");
                String transactionType = s.next();
                if (transactionType .equalsIgnoreCase("exit"))break;
                System.out.println("enter amount");
                Double amount = s.nextDouble();
//             if(!amount.equals("[^a-zA-Z]")){
//                 System.out.println("Wrong Entry");
//             };
                System.out.println("enter account number");
                String accountNo = s.next();
                //credit function
                String oldbalace = null;
                if (transactionType.equalsIgnoreCase("credit")||transactionType.equalsIgnoreCase("cr")) {
                    for (int i = 0; i < accountHolder.size(); i++) {
                        if (accountNo.equals(accountHolder.get(i).getAccountNumber())&&amount>0) {
                            accountHolder.get(i).creditOperation(amount);
                            System.out.println("account holder name " + accountHolder.get(i).getCustomerName());
                            numberOfTransaction++;
                            check= true;
                              break;
                        }
                    }

                    if (!check) {
                        failedTransaction++;
                        System.out.println("wrong operation");
                    }

                    System.out.println("Do you want to continue??(y,n,main)");
                    String choose = s.next();
                    if(choose.equalsIgnoreCase("n")){
                        return;
                    } else if (choose.equalsIgnoreCase("main")) {
                        break;
                    }else continue;
                    // debit function
                } else if (transactionType.equalsIgnoreCase("debit")||transactionType.equalsIgnoreCase("dr")) {
                    for (int i = 0; i < accountHolder.size(); i++) {
                        if (accountNo.equals(accountHolder.get(i).getAccountNumber())&&amount<accountHolder.get(i).getAccountBalance()) {
                            accountHolder.get(i).debitOperation(amount);
                            System.out.println("account holder name " + accountHolder.get(i).getCustomerName());
                            numberOfTransaction++;
                            check = true;
                            break;

                    }
                    }
                    if (!check){
                        failedTransaction++;
                        System.out.println("wrong operation");
                    }
                    System.out.println("Do you want to continue??(y,n,main)");
                    String choose = s.next();
                    if(choose.equalsIgnoreCase("n")){
                        return;
                    } else if (choose.equalsIgnoreCase("main")) {
                        break;
                    }else continue;
                }}
            } else if (selectedTransaction.equals("2") || selectedTransaction.equalsIgnoreCase("balance")) {
                for (int i = 0; i < accountHolder.size(); i++) {
                    System.out.println("Account holder name " + accountHolder.get(i).getCustomerName()+" , Number " + accountHolder.get(i).getAccountNumber()+" , Balance " + accountHolder.get(i).getAccountBalance());

                }
                check= true;
            }
            else if (selectedTransaction.equals("3") || selectedTransaction.equalsIgnoreCase("counted")) {
                System.out.println("Right Transaction " + numberOfTransaction);
                System.out.println("Failed Transaction " + failedTransaction);
                check= true;
            } else if (selectedTransaction.equals("4") || selectedTransaction.equalsIgnoreCase("highest")) {

                OptionalDouble max = accountHolder.stream().mapToDouble(AccountHolder -> AccountHolder.getAccountBalance()).max();

           accountHolder.stream()
                   .sorted(Comparator.<AccountHolder>comparingDouble(accountHolder1-> accountHolder1.getAccountBalance()).reversed())
                   .limit(2)
                   .forEach(accountHolder1 -> System.out.println(accountHolder1.getCustomerName()+ "\t" +accountHolder1.getAccountBalance()));
                check= true;

            }

        }
    }

}