import java.util.HashMap;
import java.util.Map;

public class RemoteControl {


    Map<Integer,ICommand> commands = new HashMap<>();
    Map<Integer,ICommand> history = new HashMap<>();



    public void setCommand(int slot,ICommand command){
        commands.put(slot,command);
    }

    public void buttonPressed(int slot) {
        commands.get(slot).execute();
        history.put(slot,commands.get(slot));
    }


    public void undoButtonPressed(int slot) {
        if (history.get(slot) != null) {
            history.get(slot).undo();
            history.remove(slot);
        }else {
            System.out.println("No more history");
        }
    }



}
