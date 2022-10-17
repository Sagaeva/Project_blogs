
package be.scrumdilicious.blogOpdracht.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, updatable = false)
    private String username;
    @Column(nullable = true)
    private String lastname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, length = 2500)
    private String password;
    private String street;
    private int houseN;
    private String city;
    private Long zip;

    @ElementCollection(targetClass = ERole.class)
    private Set<ERole> role = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,  orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @PrePersist
    protected void oneCreate() {
        this.createdDate = LocalDateTime.now();
    }

    public User() {

    }

    public User(String name, String username, String lastname, String email,
                String password, String street, int houseN, String city, Long zip) {
        this.name = name;
        this.username = username;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.street = street;
        this.houseN = houseN;
        this.city = city;
        this.zip = zip;
    }

    public User(String name, String username, String lastname, String email,
                String password, String street, int houseN, String city, Long zip,
                Set<ERole> role, List<Post> posts, LocalDateTime createdDate) {
        this.name = name;
        this.username = username;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.street = street;
        this.houseN = houseN;
        this.city = city;
        this.zip = zip;
        this.role = role;
        this.posts = posts;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseN() {
        return houseN;
    }

    public void setHouseN(int houseN) {
        this.houseN = houseN;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }



    public Set<ERole> getRole() {
        return role;
    }

    public void setRole(Set<ERole> role) {
        this.role = role;
    }



    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User{"+
                "id="+id+
                ", name='"+name+'\''+
                ", username='"+username+'\''+
                ", lastname='"+lastname+'\''+
                ", email='"+email+'\''+
                ", password='"+password+'\''+
                ", street='"+street+'\''+
                ", houseN="+houseN+
                ", city='"+city+'\''+
                ", zip="+zip+
                ", role="+role+
                ", posts="+posts+
                ", createdDate="+createdDate+
                '}';
    }
}


