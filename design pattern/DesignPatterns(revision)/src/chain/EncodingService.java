package chain;

public class EncodingService extends handler{

    public EncodingService(handler next) {
        super(next);
    }

    public void encode(String image){
        System.out.println("encoding "+image);

    }

    @Override
    public void doHandle(String image) {
        System.out.println("encoding "+image);
    }
}
