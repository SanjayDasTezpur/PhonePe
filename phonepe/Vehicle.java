package phonepe;

public class Vehicle {


    private String id;
    private String name;
    private EVehicleType type;


    public Vehicle(String id, String name, EVehicleType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EVehicleType getType() {
        return type;
    }

    public void setType(EVehicleType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
