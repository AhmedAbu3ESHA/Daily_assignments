import java.util.HashMap;

public class AcountExeptions extends Exception {
    private Enumex code;

    private static HashMap<Enumex,String> message=new HashMap<>();
    static {
        message.put(Enumex.NegativeDeposit,"NegativeDeposit");
        message.put(Enumex.InsuffeicientBalance,"InsuffeicientBalance");
    }
    public AcountExeptions(Enumex code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message.get(code);
    }
}
