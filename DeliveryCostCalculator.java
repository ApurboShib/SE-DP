

public class DeliveryCostCalculator {
    public static void main(String[] args) {
        Context dhl = new Context(new DHL());
        System.out.println(dhl.cost(5000));

        Context fed = new Context(new FedEx());
        System.out.println(fed.cost(500));

        Context local = new Context(new LocalQurier());
        System.out.println(local.cost(50));
    }
}

interface calculateDelevery {
    String cost (int amount);
   }
   
   class DHL implements calculateDelevery {
       
       public String cost(int amount) {
           return "Delevery is done by DHL with cost : " + amount + " USD";
       }
   }
   
   class FedEx implements calculateDelevery {
       
       public String cost(int amount) {
           return "Delevery is done by FedEx with cost : " + amount + " USD";
       }
   }
   
   class LocalQurier implements calculateDelevery {
       public String cost(int amount) {
           return "Delevery is done by LocalQurier with cost : " + amount + " USD";
       }
   }
   
   class Context {
       private calculateDelevery delevery;
       
        public Context (calculateDelevery delevery) {
           this.delevery = delevery;
       }
       
       public String cost(int amount) {
           return delevery.cost(amount);
       }
   }
   
