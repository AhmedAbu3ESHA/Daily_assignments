package chain;

public abstract class handler {
    private handler next;


    public handler(handler next) {
        this.next = next;
    }

    public void handle(String image){
        doHandle(image);
        if (next!=null)
            next.handle(image);
    }
    public abstract void doHandle(String image);
}
