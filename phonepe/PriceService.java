package phonepe;

import java.util.HashMap;
import java.util.Map;

public class PriceService implements IPriceService {

    private static final Map<String, Map<String, Double>> priceDB = new HashMap<>();

    private final IBranchService branchService;
    private final IVehicleService vehicleService;

    public PriceService(IBranchService branchService, IVehicleService vehicleService) {
        this.branchService = branchService;
        this.vehicleService = vehicleService;
    }

    @Override
    public void allocatePrice(String branchName, String vehicleType, Double price) {
        System.out.println("Allocating price = " + price + ", branch name =" + branchName + ", type= " + vehicleType);
        if (!branchService.isValidBranch(branchName)) {
            throw new RuntimeException("Invalid branch name");
        }
        if (!vehicleService.isValidType(vehicleType)) {
            throw new RuntimeException("Invalid vehicle type");
        }
        if (!branchService.isVehiclePresentForType(vehicleType, branchName)) {
            throw new RuntimeException("For branch =" + branchName + ", vehicle type =" + vehicleType + ", is not present");
        }

        // TODO validation is needed here;
        priceDB.get(branchName).put(vehicleType, price);

    }
}
