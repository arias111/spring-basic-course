package com.spring.basics.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String description;
    @Column(name = "image_name")
    private String imageName;

    @ManyToMany
    @JoinTable(name = "basket",joinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"))
    private List<User> users;
}