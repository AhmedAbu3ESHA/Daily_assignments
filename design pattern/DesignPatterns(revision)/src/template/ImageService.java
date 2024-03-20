package template;

public class ImageService extends MediaService{

    public ImageService(Compression compression) {
        super(compression);
    }


    @Override
    protected void onSave(String file) {
        System.out.println("save image"+file);
    }
}
