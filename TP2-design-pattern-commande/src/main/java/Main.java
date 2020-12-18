import java.io.*;




public class Main {

    public static void main(String[] args){

        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light();
        TurnOnCommand turnOnLight = new TurnOnCommand(light);
        TurnOffCommand turnOffLight = new TurnOffCommand(light);
        remoteControl.setCommand(1,turnOnLight);
        remoteControl.setCommand(2,turnOffLight);

        Tv tv = new Tv();
        TurnOnCommand turnOnTv = new TurnOnCommand(light);
        TurnOffCommand turnOffTv = new TurnOffCommand(light);
        remoteControl.setCommand(3,turnOnTv);
        remoteControl.setCommand(4,turnOffTv);


        remoteControl.buttonPressed(2);
        System.out.println("-----------------");
        remoteControl.undoButtonPressed(2);
        System.out.println("-----------------");
        remoteControl.undoButtonPressed(2);

    }

}
