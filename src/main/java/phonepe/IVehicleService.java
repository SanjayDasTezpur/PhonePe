package phonepe;

public interface IVehicleService {
    // API ENDPOINT
    Vehicle addVehicle(String vehicleId, String vehicleType, String branchName);

    boolean isValidType(String type);
}
