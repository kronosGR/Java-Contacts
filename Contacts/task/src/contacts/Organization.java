package contacts;

public class Organization extends Contact {
    String orgName;
    String address;

    public Organization(String orgName, String address, String number) {
        super(number);
        this.orgName = orgName;
        this.address = address;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return orgName + " " + address + ", " + number ;
    }
}
