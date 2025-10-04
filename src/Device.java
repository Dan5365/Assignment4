public abstract class Device {
    protected Charger charger;
    protected String name;

    public Device(String name, Charger charger) {
        this.name = name;
        this.charger = charger;
    }

    public abstract void charge();
}
