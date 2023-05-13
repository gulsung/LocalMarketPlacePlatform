package webserver.estuceng.LocalFarmerMarketplacePlatform.Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


import java.util.List;

public class OrderItem {
    private EntityManager entityManager;

    public OrderItem(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public OrderItem createOrderItem(Order order, Product product, int quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);


        entityManager.getTransaction().begin();
        entityManager.persist(orderItem);
        entityManager.getTransaction().commit();

        return orderItem;
    }

    private void setQuantity(int quantity) {
    }

    private void setProduct(Product product) {

    }

    private void setOrder(Order order) {

    }

    public List<OrderItem> getOrderItemsByOrder(Order order) {
        String jpql = "SELECT oi FROM OrderItem oi WHERE oi.order = :order";
        TypedQuery<OrderItem> query = entityManager.createQuery(jpql, OrderItem.class);
        query.setParameter("order", order);


        return query.getResultList();
    }
}