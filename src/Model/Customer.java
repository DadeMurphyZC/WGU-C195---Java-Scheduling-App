/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.*;
import static java.time.LocalDate.now;
/**
 *
 * @author cfonseca
 */

public class Customer {
    private int id, addressId, active;
    private String customerName, createdBy, lastUpdateBy;
    private LocalDate createDate;
    private Address address;
    
    public Customer(){};

    public Customer(int id, String customerName, int addressId, int active) {
        this.id = id;
        this.customerName = customerName;
        this.addressId = addressId;
        this.active = active;
        this.createDate = now();
        this.createdBy = "test";
        //this.lastUpdate = new Timestamp(System.currentTimeMillis());
        this.lastUpdateBy = "test";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
    
    
    
}
