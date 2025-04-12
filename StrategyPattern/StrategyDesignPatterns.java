public class StrategyDesignPatterns {
    public static void main(String[] args) {
        Checkout payBkash = new Checkout(new BkashPayment());
        System.out.println(payBkash.pay(1000));
        Checkout payNgd = new Checkout(new NagadPayment());
        System.out.println(payNgd.pay(10000));

        Checkout payRoc = new Checkout(new RocketPayment());
        System.out.println(payRoc.pay(5000));
    }
}
interface Paymentstrategy {
    String pay(int amount);
}

class BkashPayment implements Paymentstrategy {
    public String pay(int amount) {
        return "Payment is done using Bkash for BDT" + amount;
    }
}

class NagadPayment implements Paymentstrategy {
    public String pay(int amount) {
        return "payment is done using Nagad for BDT" + amount;
    }
}

class RocketPayment implements Paymentstrategy {
    public String pay(int amount) {
        return "payment is done using Rocket for BDT" + amount;
    }
}

// context class.

class Checkout {
    private Paymentstrategy strategy;
    
    public Checkout(Paymentstrategy strategy) {
        this.strategy = strategy;
    }
    public String pay(int amount){
        return strategy.pay(amount);
    }
}
