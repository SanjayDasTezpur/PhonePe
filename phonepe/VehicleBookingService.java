package phonepe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class VehicleBookingService {
    private static final Map<String, BookEvent> bookDB = new ConcurrentHashMap<>();

    private final IBranchService branchService;

    public VehicleBookingService(IBranchService branchService) {
        this.branchService = branchService;
    }

    public Object bookVehicle(String vehicleType, long startTime, long endTime) {
        System.out.println("Trying to book vehicle");
        Set<String> allVehicleIDsForType = branchService.getAllVehicles().stream().filter(v -> v.getType().name().equalsIgnoreCase(vehicleType)).map(Vehicle::getId).collect(Collectors.toSet());
        // found log
        Set<String> bookedVehicle = bookDB.values().stream().filter(be -> {
            return be.getTo() >= startTime;
        }).map(BookEvent::getVehicleID).collect(Collectors.toSet());
        allVehicleIDsForType.removeAll(bookedVehicle);
        List<String> available = new ArrayList<>(allVehicleIDsForType);
        if (available.isEmpty()) {
            throw new RuntimeException("No car avaivle");
        }
        BookEvent be = new BookEvent();
        be.setBookingID(UUID.randomUUID().toString());
        be.setVehicleID(available.get(0));
        be.setFrom(startTime);
        be.setTo(endTime);
        bookDB.put(be.getBookingID(), be);
        return be;
    }
}
