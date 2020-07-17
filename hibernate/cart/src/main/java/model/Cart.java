package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="CART")
public class Cart {

    @Column(name = "cart_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany(mappedBy="cart")
    private Set<Items> items;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }
}
