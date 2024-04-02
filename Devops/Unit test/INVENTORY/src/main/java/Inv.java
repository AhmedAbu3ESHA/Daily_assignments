import java.util.HashMap;
import java.util.Map;

public class Inv {
    HashMap<String,Integer> product = new HashMap<String, Integer>();
    public Inv() {
        product.put("Chair", 5);
        product.put("Table", 6);
    }

    int p=0;
    public int add(String type,int num) {

        for (Map.Entry<String, Integer> key:product.entrySet()){
            if (type.equals(product.keySet()) && num<=100 && num>0){
                key.setValue((key.getValue())+num);
                p=1;
                break;
            }
            else {
                p= 0;
            }
        }
        return p;
    }

    public int remove(String type,int num) {

        for (Map.Entry<String, Integer> key:product.entrySet()){
            if (type.equals(product.keySet()) && key.getValue()>=num && num>0){
                key.setValue((key.getValue())-num);
                p=1;
                break;
            }
            else {
                p= 0;
            }
        }
        return p;
    }
}
