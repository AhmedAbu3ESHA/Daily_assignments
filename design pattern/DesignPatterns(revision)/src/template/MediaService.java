package template;

public abstract class MediaService {
    Compression compression;
    FilterService filterService=new FilterService();

    public MediaService(Compression compression) {
        this.compression = compression;
    }

    public void save(String file){
        compression.compress(file);
        filterService.filter(file);
        onSave(file);
    }
    protected abstract void onSave(String file);

}
