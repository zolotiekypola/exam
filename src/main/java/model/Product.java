package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private double cost;

    @Column
    private String description;

    @Column
    private String mainImagePath;

    @Column
    private int isActive;

    @OneToMany(mappedBy = "product")
    private Set<ProductSale> productSales;

    @ManyToOne
    private Manufacturer manufacturer;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", mainImagePath='" + mainImagePath + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
