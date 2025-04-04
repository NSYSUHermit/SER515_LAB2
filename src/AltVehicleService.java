public class AltVehicleService {
    private IVehicleInspector inspector;

    public AltVehicleService(String viProp) {
        inspector = VehicleFactory.getVehicleInspector(viProp);
    }

    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for (IVehicle vehicle : vehicles) {
            total += vehicle.accept(inspector);
        }
        return total;
    }
}