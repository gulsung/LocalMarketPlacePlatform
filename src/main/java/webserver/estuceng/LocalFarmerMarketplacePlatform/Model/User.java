package webserver.estuceng.LocalFarmerMarketplacePlatform.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


    @Entity
    @Table(name = "USERS")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private int userId;

        @Column(name = "name")
        private String name;

        @Column(name = "email", unique = true)
        private String email;

        @Column(name = "password")
        private String password;
        @jakarta.persistence.Id
        private Long id;

        public User() {
        }

        public User(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }

        // getters and setters

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        // methods

        public static User createUser(String name, String email, String password) {
            User user = new User(name, email, password);
            EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            em.close();
            return user;
        }

        public static User getUserById(int userId) {
            EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
            User user = em.find(User.class, userId);
            em.close();
            return user;
        }

        public static User getUserByEmail(String email) {
            EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
            User user = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
            em.close();
            return user;
        }

        public static User authenticateUser(String email, String password) {
            EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
            User user = em.createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
            em.close();
            return user;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }