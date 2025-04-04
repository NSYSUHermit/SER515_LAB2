public class Act3VehicleService {
    private static final Act3VehicleService INSTANCE;
    private final IVehicleInspector inspector;
    private final IEmissionsStrategy emissionsStrategy;

    static {
        String viProp = System.getProperty("vi");
        String esProp = System.getProperty("es");
        INSTANCE = new Act3VehicleService(viProp, esProp);
    }

    private Act3VehicleService(String viProp, String esProp) {
        this.inspector = VehicleFactory.getVehicleInspector(viProp);
        if ("one".equals(esProp)) {
            this.emissionsStrategy = new OneEmissionsStrategy();
        } else if ("two".equals(esProp)) {
            this.emissionsStrategy = new TwoEmissionsStrategy();
        } else {
            this.emissionsStrategy = new NullEmissionsStrategy();
        }
    }

    public static Act3VehicleService getInstance() {
        return INSTANCE;
    }

    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for (IVehicle vehicle : vehicles) {
            total += emissionsStrategy.computeEmissionsFee(vehicle) + vehicle.accept(inspector);
        }
        return total;
    }
}