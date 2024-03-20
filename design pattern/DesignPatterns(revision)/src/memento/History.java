package memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<NotepadState> states=new ArrayList<>();

    public void add(NotepadState state){
        states.add(state);
    }
    public NotepadState remove(){
        if (states.size()>0) {
            states.remove(states.size() - 1);
            if (states.size()>0) {
                NotepadState lastState = states.get(states.size() - 1);
                return lastState;
            }
        }
        return null;
    }
}
