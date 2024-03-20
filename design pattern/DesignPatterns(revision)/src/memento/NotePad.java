package memento;

public class NotePad {

    private NotepadState state;
    private History history=new History();

    public NotepadState getState() {
        return state;
    }

    public void setState(NotepadState state) {
        this.state = state;
    }

    public void createState(String content){
        state=new NotepadState(content);
        history.add(state);
    }
    public void undo(){
        NotepadState last=history.remove();
        if (last!=null)
            this.state=last;
    }
}
