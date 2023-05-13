package webserver.estuceng.LocalFarmerMarketplacePlatform.Model;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import webserver.estuceng.LocalFarmerMarketplacePlatform.DatabaseConnection;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "availability")
    private boolean availability;

    @Column(name = "images")
    private String images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    // method for creating a new product record
    public void createProduct(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.persist(this);
        entityManager.getTransaction().commit();
    }

    // method for retrieving a product record by ID
    public static Product getProductById(EntityManager entityManager, int id) {
        return entityManager.find(Product.class, id);
    }

    // method for retrieving all product records
    public static List<Product> getAllProducts(EntityManager entityManager) {
        String jpql = "SELECT p FROM Product p";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        return query.getResultList();
    }

    // method for updating a product record
    public void updateProduct(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.merge(this);
        entityManager.getTransaction().commit();
    }

    // method for deleting a product record
    public void deleteProduct(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.remove(this);
        entityManager.getTransaction().commit();
    }
}
