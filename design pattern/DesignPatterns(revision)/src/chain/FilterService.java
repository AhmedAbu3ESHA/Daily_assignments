package chain;

public class FilterService extends handler{
    public FilterService(handler next) {
        super(next);
    }

    @Override
    public void doHandle(String image) {
        System.out.println("filtering "+image);
    }
}
