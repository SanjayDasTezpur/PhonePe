package phonepe;

public interface IPriceService {
    // API ENDPOINT

    void allocatePrice(String branchName, String vehicleType, Double price);
}
