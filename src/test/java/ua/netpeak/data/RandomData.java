package ua.netpeak.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public enum RandomData {
    DATA("ru");

    private String name;
    private String lastName;
    private String email;
    private String phone;
    private int indexBY;
    private int indexBM;
    private int indexBD;

    RandomData(String local) {
        Faker faker = new Faker(new Locale(local));
        this.name = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress(faker.bothify("?????##"));
        this.phone = faker.phoneNumber().phoneNumber();
        this.indexBY = faker.random().nextInt(1, 30);
        this.indexBM = faker.random().nextInt(1, 12);
        this.indexBD = faker.random().nextInt(1, 31);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getIndexBY() {
        return indexBY;
    }

    public int getIndexBM() {
        return indexBM;
    }

    public int getIndexBD() {
        return indexBD;
    }
}
