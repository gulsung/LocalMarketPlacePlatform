package webserver.estuceng.LocalFarmerMarketplacePlatform.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class Farmer {

    @Id
    @GeneratedValue
    private int farmer_id;


    @jakarta.persistence.Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "contact_information")
    private String contactInformation;

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
    private List<Product> products;

    // constructors, getters, setters, and other methods

    public Farmer() {}

    public Farmer(String name, String location, String contactInformation) {
        this.name = name;
        this.location = location;
        this.contactInformation = contactInformation;
    }

    public int getFarmerId() {
        return farmer_id;
    }

    public void setFarmerId(int farmer_id) {
        this.farmer_id = farmer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    @Override
    public String toString() {
        return "Farmer [farmer_id=" + farmer_id + ", name=" + name + ", location=" + location + ", contactInformation="
                + contactInformation + "]";
    }

    // method for creating a new farmer record in the database
    public static void createFarmer(String name, String location, String contactInformation) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("localfarmermarketplacedatabase");
        EntityManager em = emf.createEntityManager();

        Farmer farmer = new Farmer(name, location, contactInformation);

        em.getTransaction().begin();
        em.persist(farmer);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    // method for retrieving a farmer record by ID
    public static Farmer getFarmerById(int farmerId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("localfarmermarketplacedatabase");
        EntityManager em = emf.createEntityManager();

        Farmer farmer = em.find(Farmer.class, farmerId);

        em.close();
        emf.close();

        return farmer;
    }

    // method for retrieving all farmer records
    public static List<Farmer> getAllFarmers() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("localfarmermarketplacedatabase");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Farmer> query = em.createQuery("SELECT f FROM Farmer f", Farmer.class);
        List<Farmer> farmers = query.getResultList();

        em.close();
        emf.close();

        return farmers;
    }

    // method for updating a farmer's profile
    public void updateFarmerProfile() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("localfarmermarketplacedatabase");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(this);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
