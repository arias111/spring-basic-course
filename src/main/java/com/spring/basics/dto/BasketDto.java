package com.spring.basics.dto;

import com.spring.basics.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDto {
    private Long id;
    private String name;
    private String size;
    private String image;
    private Long quantity;

    public static List<BasketDto> from(List<Product> product) {
        List<BasketDto> list = new ArrayList<>();
        Map<Product, Long> counts =
                product.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        for (Map.Entry<Product, Long> entry : counts.entrySet()) {
            Product product1 = entry.getKey();
            Long count = entry.getValue();
            BasketDto basketDto = BasketDto.builder()
                    .id(product1.getId())
                    .name(product1.getName())
                    .size(product1.getSize())
                    .image(product1.getImageName())
                    .quantity(count)
                    .build();
            list.add(basketDto);
        }
        return list;
    }
}
