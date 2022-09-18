package phonepe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBranchService {
    boolean isValidBranch(String branchName);

    Vehicle addVehicleToBranch(String branchName, Vehicle vehicle);

    // API ENDPOINT
    Branch addBranch(String branchName);

    boolean isVehiclePresentForType(String type, String branchName);

    List<Vehicle> getAllVehicles();
}
