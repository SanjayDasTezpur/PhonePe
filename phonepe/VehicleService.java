package phonepe;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class VehicleService implements IVehicleService {

    private final IBranchService branchService;

    private static final Map<String, Vehicle> vehicleDB = new HashMap<>();

    public VehicleService(IBranchService branchService) {
        this.branchService = branchService;
    }

    @Override
    public Vehicle addVehicle(String vehicleId, String vehicleType, String branchName) {
        System.out.println("trying to adding vehicle with id = " + vehicleId + ", type =" + vehicleType + ", branch = " + branchName);
        Optional<EVehicleType> type = getTypeFrom(vehicleType);
        if (type.isEmpty()) {
            throw new RuntimeException("Invalid Vehicle Type");
        }
        if (!isValidBranch(branchName)) {
            throw new RuntimeException("Branch doesn't exist");
        }

        Vehicle vehicle = new Vehicle(UUID.randomUUID().toString(), vehicleId, type.get());
        return branchService.addVehicleToBranch(branchName, vehicle);
    }

    @Override
    public boolean isValidType(String type) {
        return getTypeFrom(type).isPresent();
    }

    public boolean isValidBranch(String branchName) {
        return branchService.isValidBranch(branchName);
    }


    private Optional<EVehicleType> getTypeFrom(String type) {
        try {
            return Optional.of(EVehicleType.valueOf(type));
        } catch (IllegalArgumentException e) {
            System.out.println("Type is invalid, given type=  " + type);
        }
        return Optional.empty();
    }

}
