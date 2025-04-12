// creating a customizable dashboard where users can add widgets like Weather, News, Stock Ticker, and Calendar.
//Instead of creating a new class for every possible combination, you’re using the Decorator Design Pattern to wrap widgets one by one.

public class Decoretor {
    public static void main(String[] args) {
        DashBoard obj = new weatherWidgets (new NewsWidgets (new StockWidgets (new CalenderWidgets (new BasicDash()))));
        System.out.println(obj.show());
     }
}

interface DashBoard {
    public String show();
}

class BasicDash implements DashBoard {
    public String show () {
        return "Climate info: | ";
    }
}

class DecoratorDash implements DashBoard {
    protected DashBoard dash;
    public DecoratorDash (DashBoard dash) {
        this.dash = dash;
    }
    public String show() {
        return dash.show();
    }
}

class weatherWidgets extends DecoratorDash {
    public weatherWidgets(DashBoard dash) {
        super(dash);
    }
    public String show () {
        return dash.show() + "Weather is rough | ";
    }
}

class NewsWidgets extends DecoratorDash {
    public NewsWidgets(DashBoard dash) {
        super(dash);
    }
    public String show () {
        return dash.show() + "News is Hot | ";
    }
}
class StockWidgets extends DecoratorDash {
    public StockWidgets(DashBoard dash) {
        super(dash);
    }
    public String show () {
        return dash.show() + "Stock is high | ";
    }
}
class CalenderWidgets extends DecoratorDash {
    public CalenderWidgets(DashBoard dash) {
        super(dash);
    }
    public String show () {
        return dash.show() + "Clelender are Closed.";
    }
}
