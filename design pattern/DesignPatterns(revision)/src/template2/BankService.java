package template2;

public abstract class BankService {

    public void save(String event){
        Logger.log(event);
        onSave();
        Logger.log(event);
    }
    public abstract void onSave();
}
