// You’re customizing a coffee with add-ons like Milk, Sugar, and Whipped Cream.

public class CoffeeDecorate {
    public static void main(String[] args) {
        Coffee obj = new AddWhipped(new AddSuger(new AddMilk(new BasicMaking())));
        System.out.println(obj.make());
    }
}

interface Coffee {
    String make();
}

class BasicMaking implements Coffee {
    public String make() {
        return "Start Making : | ";
    }
}

class DecorateCoffee implements Coffee {
    protected Coffee coff;
    public DecorateCoffee(Coffee coff) {
        this.coff = coff;
    }
    public String make () {
        return coff.make();
    }
}

class AddMilk extends DecorateCoffee {
    public AddMilk(Coffee coff) {
        super(coff);
    }
    public String make() {
        return coff.make() + "Add milk on coffee. | ";
    }
}
class AddSuger extends DecorateCoffee {
    public AddSuger(Coffee coff) {
        super(coff);
    }
    public String make() {
        return coff.make() + "Add Suger on coffee. | ";
    }
}
class AddWhipped extends DecorateCoffee {
    public AddWhipped(Coffee coff) {
        super(coff);
    }
    public String make() {
        return coff.make() + "Add Whipped on coffee. | ";
    }
}