package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "productsale")
public class ProductSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date saleDate;

    @Column
    private int quantity;

    @ManyToOne
    private Product product;

    @Override
    public String toString() {
        return "ProductSale{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", quantity=" + quantity +
                '}';
    }
}
