package springShop.dto;

public class AccountDTO {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    private String zip;

    public AccountDTO() {
    }

    public AccountDTO(String userName, String password, String firstName, String lastName, String email, String phoneNumber, String address, String city, String country, String zip) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.country = country;
        this.zip = zip;
    }
}
