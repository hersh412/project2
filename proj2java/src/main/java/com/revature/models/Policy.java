package com.revature.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "policy")
public class Policy {

    /*
     *
     *   			<--CODE REVIEW NOTES --andy-->
     *
     * -This class still needs a many to many mapping with the customer class
     * We can possibly access all policy information from an array within the customer class
     * I am not 100% sure on this but I cant really think of a reason off the top of my head why
     * it would not work
     *
     * -I also believe that this would class would benefit from a one to main relation with vehicles
     * inside of this class. My logic goes along the same lines as the above note.
     * I believe thatshould be able to access all information Customer, Demerit, policy and vehicle from
     * a single controller, angular model/service....
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    private double deductible;
    private double premium;
    @Column(name = "policy_owner")
    private User owner;

    public Policy() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", deductible=" + deductible +
                ", premium=" + premium +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return id == policy.id &&
                Double.compare(policy.deductible, deductible) == 0 &&
                Double.compare(policy.premium, premium) == 0 &&
                Objects.equals(startDate, policy.startDate) &&
                Objects.equals(endDate, policy.endDate) &&
                Objects.equals(owner, policy.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, deductible, premium, owner);
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDeductible() {
        return deductible;
    }

    public void setDeductible(double deductible) {
        this.deductible = deductible;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }


}
