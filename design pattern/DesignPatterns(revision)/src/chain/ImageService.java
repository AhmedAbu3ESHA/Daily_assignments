package chain;

public class ImageService {

    private handler handler;

    public ImageService(chain.handler handler) {
        this.handler = handler;
    }

    public void save(String image){

        handler.handle(image);

//        if (compression!=null)
//            compression.compress(image);
//
//        if (filterService!=null)
//            filterService.filter(image);
//
//        if (encodingService!=null)
//            encodingService.encode(image);

        System.out.println("save image"+image);

    }
}
