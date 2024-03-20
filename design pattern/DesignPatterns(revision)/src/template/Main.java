package template;



public class Main {
    public static void main(String[] args) {
       ImageService imageService=new ImageService(new JPGCompression());
       imageService.save("image");

    }
}
