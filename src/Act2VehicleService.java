public class Act2VehicleService {
    private static final Act2VehicleService INSTANCE;
    private final IVehicleInspector inspector;

    static {
        String viProp = System.getProperty("vi");
        INSTANCE = new Act2VehicleService(viProp);
    }

    private Act2VehicleService(String viProp) {
        this.inspector = VehicleFactory.getVehicleInspector(viProp);
    }

    public static Act2VehicleService getInstance() {
        return INSTANCE;
    }

    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for (IVehicle vehicle : vehicles) {
            total += vehicle.accept(inspector);
        }
        return total;
    }
}