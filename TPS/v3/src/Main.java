
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
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
                System.out.println(Lastwords);
                clientData=(new ArrayList<AccountHolder>(Arrays.asList(new AccountHolder(Lastwords.get(0),Lastwords.get(1), Double.parseDouble(Lastwords.get(2))))));
                accountHolder.add(clientData.get(0));
                Lastwords.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AccountHolder acc = new AccountHolder();
        while (true) {

        System.out.println("please select transaction ");
        System.out.println("1 journal");
        System.out.println("2 balance sheet ");
        System.out.println("3 transactions count");
        System.out.println("4 accounts names with highest balances");
        System.out.println("5 exit");
        String selectedTransaction = s.nextLine();
        boolean check= false;
            if (selectedTransaction.equals("1") || selectedTransaction.equalsIgnoreCase("journal")) {
                System.out.println("transaction type");
                String transactionType = s.nextLine();
                System.out.println("enter amount");
                double amount = s.nextDouble();
                System.out.println("enter account number");
                String accountNo = s.next();
                //credit function
                String oldbalace = null;
                if (transactionType.equalsIgnoreCase("c")||transactionType.equalsIgnoreCase("cr")) {
                    for (int i = 0; i < accountHolder.size(); i++) {
                        if (accountNo.equals(accountHolder.get(i).getAccountNumber())) {
                            accountHolder.get(i).creditOperation(amount);
                            System.out.println("account holder name " + accountHolder.get(i).getCustomerName());
                            check= true;
                          //  break;
                        }

                        try (FileReader fileReade = new FileReader("data.txt");
                             BufferedReader bufferedReade = new BufferedReader(fileReade)) {
                            while ((line = bufferedReade.readLine()) != null)
                            {
                                if (line.endsWith(accountHolder.get(i).getAccountNumber()))
                                {
                                    line=bufferedReade.readLine();
                                    oldbalace = line.substring(line.lastIndexOf(" ") + 1);
                                }
                            }

                        }catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }    catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    if (!check) System.out.println("account number is not valid");

                    // debit function
                    } else if (transactionType.equalsIgnoreCase("debit")||transactionType.equalsIgnoreCase("dr")) {
                        for (int i = 0; i < accountHolder.size(); i++) {
                            if (accountNo.equals(accountHolder.get(i).getAccountNumber())) {
                                accountHolder.get(i).debitOperation(amount);
                                System.out.println("account holder name " + accountHolder.get(i).getCustomerName());
                                check = true;
                                break;
                            }
                        }
                        if (!check) System.out.println("not enough balance");

                } else if (selectedTransaction.equals("2") || selectedTransaction.equalsIgnoreCase("balance")) {
                for (int i = 0; i < accountHolder.size(); i++) {
                    System.out.println("account holder name " + accountHolder.get(i).getCustomerName());
                    System.out.println("account holder number " + accountHolder.get(i).getAccountNumber());
                    System.out.println("account holder balance" + accountHolder.get(i).getAccountBalance());
                    }
                }
            else if (selectedTransaction.equals("3") || selectedTransaction.equalsIgnoreCase("counted")) {
                    System.out.println("count " + acc.getNumberOfTransaction());
                    System.out.println("count " + acc.getFailedTransaction());
//                } else if (selectedTransaction.equals("4") || selectedTransaction.equalsIgnoreCase("highest")) {
//
//                } else if (selectedTransaction.equals("5") || selectedTransaction.equalsIgnoreCase("exit")) {
//                 flag =true;
                }

                }}}}
