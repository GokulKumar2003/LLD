package org.example.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MenuItem {
    private String menuId;
    private String name;
    private String description;
    private double price;
    private boolean isVeg;
    private Category category;

    @Override
    public String toString() {
        return "MenuItem{" +
                "menuId='" + menuId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isVeg=" + isVeg +
                ", category=" + category +
                '}';
    }
}
