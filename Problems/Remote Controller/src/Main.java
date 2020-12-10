import java.util.Scanner;

class Client {

    public static void main(String[] args) {

        Controller controller = new Controller();
        TV tv = new TV();

        Command changeChannel;
        int[] channelList = new int[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            channelList[i] = scanner.nextInt();
        }

        Command turnOnTV = new TurnOnCommand(tv);
        /* write your code here */
        controller.setCommand(turnOnTV);
        controller.executeCommand();

        for (int i = 0; i < 3; i++) {
            changeChannel = new ChangeChannelCommand(new Channel(channelList[i]));
            controller.setCommand(changeChannel);
            changeChannel.execute();
        }

        Command turnOffTV = new TurnOffCommand(tv);
        /* write your code here */
        controller.setCommand(turnOffTV);
        controller.executeCommand();
    }
}

class TV {

    void turnOn() {
        System.out.println("Turning on the TV");
    }

    void turnOff() {
        /* write your code here */
        System.out.println("Turning off the TV");
    }
}

class Channel {
    private int channelNumber;

    Channel(int channelNumber) {
        /* write your code here */
        this.channelNumber = channelNumber;
    }

    void changeChannel() {
        System.out.println("Channel was changed to " + channelNumber);
    }

}

interface Command {
    /* write your code here */
    void execute();
}

class TurnOnCommand implements Command {
    /* write your code here */
    TV tv;

    TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
       /* write your code here */
        tv.turnOn();
    }
}

class TurnOffCommand implements Command {
    /* write your code here */
    TV tv;

    TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        /* write your code here */
        tv.turnOff();
    }
}

class ChangeChannelCommand implements Command {
    private Channel channel;

    ChangeChannelCommand(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void execute() {
        channel.changeChannel();
    }
}

class Controller {
    private Command command;
    void setCommand(Command command) {
        this.command = command;
    }
    void executeCommand() {
        /* write your code here */
        command.execute();
    }
}