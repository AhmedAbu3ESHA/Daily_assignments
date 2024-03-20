package strategy;

public class Main {
    public static void main(String[] args) {
        //ImageService->save(image)
        //imageservice->compression,filter
        //imageservice->context
        //compression,filter->strategies
        ImageService imageService=new ImageService(new JPGCompression());
        imageService.save("employee");
    }
}
