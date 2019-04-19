package com.revature.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "quote")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp timestamp;
    private String zipcode;
    @Transient
    private String vehicleClass;
    @Transient
    private String year;
    @Transient
    private String gender;
    @Transient
    private String age;

    public Quote() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public Quote(long id, String zipcode, String vehicleClass, String year, String gender, String age) {
        super();
        this.id = id;
        this.zipcode = zipcode;
        this.vehicleClass = vehicleClass;
        this.year = year;
        this.gender = gender;
        this.age = age;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return id == quote.id &&
                Objects.equals(timestamp, quote.timestamp) &&
                Objects.equals(zipcode, quote.zipcode) &&
                Objects.equals(vehicleClass, quote.vehicleClass) &&
                Objects.equals(year, quote.year) &&
                Objects.equals(gender, quote.gender) &&
                Objects.equals(age, quote.age);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", zipcode='" + zipcode + '\'' +
                ", vehicleClass='" + vehicleClass + '\'' +
                ", year='" + year + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, zipcode, vehicleClass, year, gender, age);
    }

    public void setAge(String age) {
        this.age = age;
    }


}
	