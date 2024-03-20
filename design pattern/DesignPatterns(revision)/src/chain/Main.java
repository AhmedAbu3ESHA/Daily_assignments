package chain;

public class Main {
    public static void main(String[] args) {

        //compression->filter->encode
        EncodingService encodingService=new EncodingService(null);
        FilterService filterService=new FilterService(encodingService);
        Compression compression=new Compression(filterService);
        ImageService imageService=new ImageService(compression);
        imageService.save("data");

    }
}
