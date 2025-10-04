public class Phone extends Device {
   public Phone(String name, Charger charger) {
      super(name, charger);
   }

   @Override
   public void charge() {
      System.out.println(name + " is charging using " + charger.getChargerType());
   }
}