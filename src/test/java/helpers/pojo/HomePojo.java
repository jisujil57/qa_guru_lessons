package helpers.pojo;

import java.util.Arrays;

public class HomePojo {
    private String address;
    private String[] bedroomNames;
    private int bathrooms;
    private double area;


    public HomePojo() {
    }

    public HomePojo(String address, String[] bedroomNames, int bathrooms, double area) {
        this.address = address;
        this.bedroomNames = bedroomNames;
        this.bathrooms = bathrooms;
        this.area = area;
    }

    @Override
    public String toString() {
        return "HomePojo{" +
                "address='" + address + '\'' +
                ", bedroomNames=" + Arrays.toString(bedroomNames) +
                ", bathrooms=" + bathrooms +
                ", area=" + area +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getBedroomNames() {
        return bedroomNames;
    }

    public void setBedroomNames(String[] bedroomNames) {
        this.bedroomNames = bedroomNames;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
