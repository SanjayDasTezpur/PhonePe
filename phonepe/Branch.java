package phonepe;

import java.util.List;

public class Branch {
    private String id;
    private String branchName;

    public Branch(String id, String branchName) {
        this.id = id;
        this.branchName = branchName;
    }

    private List<Vehicle> vehicles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

}
