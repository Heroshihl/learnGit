package serializable;

import java.io.Serializable;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/29
 * @CLASSNAME
 * @description
 */
public class Employee implements Serializable {
    private String name;
    private String address;
    private transient int SSN;
    private int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", SSN=" + SSN +
                ", number=" + number +
                '}';
    }
}
