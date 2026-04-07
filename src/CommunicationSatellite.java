public class CommunicationSatellite extends Satellite {
    private double bandwith;

    public double getBandwith() {
        return bandwith;
    }

    public CommunicationSatellite(String name, double batteryLevel, double bandwith) {
        super(name, batteryLevel);
        this.bandwith = bandwith;
    }

    @Override
    public void performMission() {
        if (state.isActive()) {
            System.out.println(name + ": Передача данных со скоростью " + bandwith + " Мбит/с");
            sendData(bandwith);
            energy.consume(0.08);
        } else {
            System.out.println(name + ": Не может отправить данные - не активен");
        }
    }

    private void sendData(double dataAmount) {
        System.out.println(name + ": Отправил " + dataAmount + " Мбит данных!");
    }

    @Override
    public String toString() {
        return "CommunicationSatellite{bandwith="+bandwith+", name='"+name+"', isActive=" +
                state.isActive()+", batteryLevel="+energy.getBatteryLevel()+"},\n";
    }
}
