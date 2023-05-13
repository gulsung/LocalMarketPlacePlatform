package webserver.estuceng.LocalFarmerMarketplacePlatform.Model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "payment_information")
    private String paymentInformation;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "delivery_time")
    private LocalTime deliveryTime;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public Order() {
        orderItems = new ArrayList<>();
    }

    public Order(String deliveryAddress, String paymentInformation, LocalDate deliveryDate,
                       LocalTime deliveryTime, BigDecimal totalCost, User user) {
        this();
        this.deliveryAddress = deliveryAddress;
        this.paymentInformation = paymentInformation;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.totalCost = totalCost;
        this.user = user;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
        orderItem.setOrder(null);
    }

    // Define a method for retrieving an order record by ID
    public static Order getOrderById(int orderId, EntityManager em) {
        return em.find(Order.class, orderId);
    }

    // Define a method for retrieving all order records for a user
    public static List<Order> getAllOrdersForUser(int userId, EntityManager em) {
        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.user.id = :userId", Order.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    // Define a method for creating a new order record in the database
    public static void createOrder(Order order, EntityManager em) {
        em.persist(order);
    }

    // Define a method for updating an order record
    public static void updateOrder(Order order, EntityManager em) {
        em.merge(order);
    }

    // Define a method for deleting an order record
    public static void deleteOrder(Order order, EntityManager em) {
        em.remove(order);
    }
}