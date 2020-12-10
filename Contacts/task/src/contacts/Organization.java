package contacts;

public class Organization extends Contact {

    private String name;
    private String address;

    public Organization(String name, String address, String number) {
        super(number);
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization name: " + getFullName() + "\nAddress: " + getAddress() +
                "\n" + super.toString();
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

    @Override
    public String getFullName() {
        return name;
    }

    @Override
    public String[] getPossibleFields() {
        return new String[] {"name", "address", "number"};
    }

    @Override
    public void setField(String field, String value) {
        switch (field) {
            case "name":
                setName(value);
                break;
            case "address":
                setAddress(value);
                break;
            case "number":
                if (!Util.checkNumberValid(value)) {
                    System.out.println("Wrong number format!");
                    value = null;
                }
                setNumber(value);
                break;
        }
    }

    @Override
    public String getField(String field) {
        switch (field) {
            case "name":
                return getFullName();
            case "address":
                return getAddress();
            case "number":
                return getNumber();
            default:
                return null;
        }
    }

}
