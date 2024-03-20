package strategy;

public class ImageService {
    Compression compression;

    public ImageService(Compression compression) {
        this.compression = compression;
    }

    FilterService filterService=new FilterService();

    public void save(String image){

        compression.compress(image);

        filterService.filter(image);

        System.out.println("save image"+image);

    }
}
