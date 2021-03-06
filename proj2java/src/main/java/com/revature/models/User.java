package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", updatable = false, nullable = false)
    private int id;
    private String email;
    private String password;
    private int userconf;
    @Column(name = "first_name")
    private String fName;
    @Column(name = "last_name")
    private String lName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    @Column(name = "is_male")
    private boolean isMale;
    @Transient
    private String token;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(int id, String email, String password, int userconf, String fName, String lName, String address1,
                String address2, String city, String state, String zip, boolean isMale, String token) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.userconf = userconf;
        this.fName = fName;
        this.lName = lName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.isMale = isMale;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String key) {
        this.token = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserconf() {
        return userconf;
    }

    public void setUserconf(int userconf) {
        this.userconf = userconf;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", password=" + password + ", userconf=" + userconf + ", fName="
                + fName + ", lName=" + lName + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
                + ", state=" + state + ", zip=" + zip + ", isMale=" + isMale + ", token=" + token + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
        result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((fName == null) ? 0 : fName.hashCode());
        result = prime * result + id;
        result = prime * result + (isMale ? 1231 : 1237);
        result = prime * result + ((lName == null) ? 0 : lName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
        result = prime * result + userconf;
        result = prime * result + ((zip == null) ? 0 : zip.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (address1 == null) {
            if (other.address1 != null)
                return false;
        } else if (!address1.equals(other.address1))
            return false;
        if (address2 == null) {
            if (other.address2 != null)
                return false;
        } else if (!address2.equals(other.address2))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (fName == null) {
            if (other.fName != null)
                return false;
        } else if (!fName.equals(other.fName))
            return false;
        if (id != other.id)
            return false;
        if (isMale != other.isMale)
            return false;
        if (lName == null) {
            if (other.lName != null)
                return false;
        } else if (!lName.equals(other.lName))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (token == null) {
            if (other.token != null)
                return false;
        } else if (!token.equals(other.token))
            return false;
        if (userconf != other.userconf)
            return false;
        if (zip == null) {
            return other.zip == null;
        } else return zip.equals(other.zip);
    }


}
