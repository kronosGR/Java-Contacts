public class Main {

    public static void main(String[] args) {

        /* write your code here */

        Broker broker = new Broker();

        BuyCommand buyCommand =  new BuyCommand(new Stock());
        SellCommand sellCommand = new SellCommand(new Stock());

        broker.setCommand(buyCommand);
        broker.executeCommand();

        broker.setCommand(sellCommand);
        broker.executeCommand();
    }
}


class Stock {

    public void buy() {
        System.out.println("Stock was bought");
    }

    public void sell() {
        System.out.println("Stock was sold");
    }
}

interface Command {
    /* write your code here */

    void Execute();
}

class BuyCommand implements Command {
    private Stock stock;

    public BuyCommand(Stock stock) {
        this.stock = stock;
    }

    /* write your code here */
    @Override
    public void Execute() {
        stock.buy();
    }


}

class SellCommand implements Command {
    private Stock stock;

    public SellCommand(Stock stock) {
        this.stock = stock;
    }

    /* write your code here */
    @Override
    public void Execute() {
        stock.sell();
    }

}

class Broker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        /* write your code here */
        command.Execute();
    }
}