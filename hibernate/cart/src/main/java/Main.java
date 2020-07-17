import model.Cart;
import model.Items;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Cart cart = new Cart();
        Items firstItem = new Items();
        firstItem.setCart(cart);
        Items secondItem = new Items();
        secondItem.setCart(cart);
        //Set<Items> items = new HashSet<Items>();
        //cart.setItems(items);
        session.save(cart);
        session.save(firstItem);
        session.save(secondItem);

        transaction.commit();

        System.out.println("Cart ID=" + cart.getCartId());
        System.out.println("item1 ID=" + firstItem.getId()
                + ", Foreign Key Cart ID=" + firstItem.getCart().getCartId());
        System.out.println("item2 ID=" + secondItem.getId()
                + ", Foreign Key Cart ID=" + secondItem.getCart().getCartId());
        session.close();
    }
}
