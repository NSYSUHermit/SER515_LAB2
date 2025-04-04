public class AltVehicleInspection implements IVehicleInspector {
    @Override
    public int visit(Car car) {
        int serviceCharge = car.getColor().equals("Black") ? 150 : 75;
        System.out.println("Service Charge for Car: " + serviceCharge);
        return serviceCharge;
    }
    @Override
    public int visit(Van van) {
        int serviceCharge = van.getNumberOfDoors() > 4 ? 600 : 150;
        System.out.println("Service Charge for Van: " + serviceCharge);
        return serviceCharge;
    }
    @Override
    public int visit(Motorbike motorbike) {
        int serviceCharge = motorbike.getEngineCapacity() >= 200 ? 250 : 75;
        System.out.println("Service Charge for Motorbike: " + serviceCharge);
        return serviceCharge;
    }
}