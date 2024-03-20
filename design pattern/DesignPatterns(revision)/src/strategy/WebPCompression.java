package strategy;

public class WebPCompression implements Compression{
    @Override
    public void compress(String image) {
        System.out.println("compressing using webP"+image);
    }
}
