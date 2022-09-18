package phonepe;

import java.util.*;

public class BranchService implements IBranchService {

    private static final Map<String, Branch> branchDB = new HashMap<>();
    private static final Map<String, List<Vehicle>> vehicleOnBranchesDB = new HashMap<>();

    @Override
    public boolean isValidBranch(String branchName) {
        return getBranchFromName(branchName).isPresent();
    }

    private Optional<Branch> getBranchFromName(String branchName) {
        return branchDB.values().stream().filter(branch -> branch.getBranchName().equals(branchName)).findFirst();
    }

    @Override
    public Vehicle addVehicleToBranch(String branchName, Vehicle vehicle) {
        Optional<Branch> branchFromName = getBranchFromName(branchName);
        branchFromName.ifPresent(branch -> {
            String branchID = branch.getId();
            List<Vehicle> vehicles = vehicleOnBranchesDB.getOrDefault(branchID, new ArrayList<>());
            vehicles.add(vehicle);
            vehicleOnBranchesDB.put(branchID, vehicles);
        });
        return vehicle;
    }

    @Override
    public Branch addBranch(String branchName) {
        System.out.println("Adding branch= " + branchName);
        String id = UUID.randomUUID().toString();
        return branchDB.put(id, new Branch(id, branchName));
    }

    @Override
    public boolean isVehiclePresentForType(String type, String name) {
        Optional<Branch> branchFromName = getBranchFromName(name);
        return vehicleOnBranchesDB.get(branchFromName.get().getId()).stream().anyMatch(vehicle -> vehicle.getType().name().equalsIgnoreCase(type));
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> res = new ArrayList<>();
        vehicleOnBranchesDB.values().forEach(res::addAll);
        return res;
    }

}
