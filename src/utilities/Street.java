package utilities;

public class Street {
    private String name;
    private District district;

	public Street(String name, District district) {
            this.name = name;
            this.district = district;
    }

    public String getName() {
        return name;
    }

    public District getDistrict() {
        return district;
    }
}

