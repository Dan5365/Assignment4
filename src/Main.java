public class Main {
    public static void main(String[] args) {
        Charger usbC = new UsbCCharger();
        Charger wireless = new WirelessCharger();

        Device phone = new Phone("iPhone 15", wireless);
        Device laptop = new Laptop("MacBook Pro", usbC);

        phone.charge();
        laptop.charge();
    }
}
