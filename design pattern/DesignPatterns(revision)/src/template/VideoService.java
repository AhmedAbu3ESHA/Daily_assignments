package template;

public class VideoService extends MediaService {


    public VideoService(Compression compression) {
        super(compression);
    }

    @Override
    protected void onSave(String file) {
        System.out.println("saving video "+file);
    }
}
