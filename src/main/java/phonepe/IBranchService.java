package phonepe;

import java.util.List;

public interface IBranchService {
    boolean isValidBranch(String branchName);

    Vehicle addVehicleToBranch(String branchName, Vehicle vehicle);

    // API ENDPOINT
    Branch addBranch(String branchName);

    boolean isVehiclePresentForType(String type, String branchName);

    List<Vehicle> getAllVehicles();
}
