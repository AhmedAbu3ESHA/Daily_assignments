package memento;

public class Main {
    public static void main(String[] args) {
        NotePad notePad=new NotePad();
        notePad.createState("hello");
        System.out.println(notePad.getState().getContent());
        notePad.createState("world");
        System.out.println(notePad.getState().getContent());
        notePad.undo();
        System.out.println(notePad.getState().getContent());
        notePad.undo();
        System.out.println(notePad.getState().getContent());
    }
}
