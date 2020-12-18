public class TurnOffCommand implements ICommand{

    Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        System.out.println("Turning off "+device.getClass());
        device.turnOff();
    }

    @Override
    public void undo() {
        System.out.println("Turning ON "+device.getClass());
        device.turnOn();
    }
}
