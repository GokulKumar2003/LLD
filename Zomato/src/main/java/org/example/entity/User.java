package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class User {
    private String userId;
    private String name;
    private String mobileNumber;
    private Address defaultAddress;
    private List<Address> addressList;
    private Cart cart;

    public User(String name, Address address, String mobileNumber){
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.defaultAddress = address;
        this.addressList = new ArrayList<>();
        addressList.add(address);
        cart = new Cart();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", defaultAddress=" + defaultAddress +
                ", addressList=" + addressList +
                ", cart=" + cart +
                '}';
    }
}
