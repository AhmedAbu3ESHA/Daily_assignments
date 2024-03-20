package strategy;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileService service=new FileService();
            service.load((content)-> System.out.println(content)
                    ,(error)-> System.out.println(error));


    }
}
