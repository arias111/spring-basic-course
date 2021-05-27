package com.spring.basics.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long categoryId;
    @Column(name = "image_name")
    private String imageName;
    private String size;
    private String type;

    public static Product from(Product product) {
        return Product.builder()
                .id(product.getId())
                .name(product.getName())
                .type(product.getType())
                .imageName(product.getImageName())
                .build();
    }

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "basket",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> users;

}