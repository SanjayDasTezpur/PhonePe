package phonepe;

import java.util.Date;

public class Demo {
    public static final String LOCATION = "Banaglore, Marathahalli";
    public static final String CARD_TYPE = "SEDAN";
    IBranchService branchService = new BranchService();
    VehicleBookingService vehicleBookingService = new VehicleBookingService(branchService);
    IVehicleService vehicleService = new VehicleService(branchService);
    IPriceService priceService = new PriceService(branchService, vehicleService);

    public static void main(String[] args) {
        new Demo().tests();
    }

    public void tests() {
        testAddBranch();
        testAddVehicle();
        testAllocatePrice();
        testBoookVehicle();
    }

    private void testBoookVehicle() {
        BookEvent bookEvent = vehicleBookingService.bookVehicle(CARD_TYPE, System.currentTimeMillis(), System.currentTimeMillis() + 3600000);
        System.out.println("Booked, Booking ID = " + bookEvent.getBookingID() + ", car id =" + bookEvent.getVehicleID() + ", start time = " + new Date(bookEvent.getFrom()) + ", end time=" + new Date(bookEvent.getTo()));
    }

    private void testAllocatePrice() {
        priceService.allocatePrice(LOCATION, CARD_TYPE, 200.00D);
    }

    private void testAddVehicle() {
        vehicleService.addVehicle("Audi", CARD_TYPE, LOCATION);


    }

    private void testAddBranch() {
        branchService.addBranch(LOCATION);
    }
}
