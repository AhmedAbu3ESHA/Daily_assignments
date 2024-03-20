package chain;

public class Compression extends handler{
    public Compression(handler next) {
        super(next);
    }

    @Override
    public void doHandle(String image) {
        System.out.println("compressing "+image);
    }
}
