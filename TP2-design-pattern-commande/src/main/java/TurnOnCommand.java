public class TurnOnCommand implements ICommand{

    Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        System.out.println("Turning ON "+device.getClass());
        device.turnOn();
    }

    @Override
    public void undo() {
        System.out.println("Turning OFF "+device.getClass());
        device.turnOff();
    }

}
