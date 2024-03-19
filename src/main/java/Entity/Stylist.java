package Entity;

import javax.persistence.*;

@Entity
@Table(name = "Stylists")
@NamedQuery(name = "Stylists.getAll", query = "SELECT s from Stylist s")
public class Stylist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "surname", length = 255)
    private String surname;
    @Column(name="isDeleted")
    private boolean isDeleted;
    public Stylist(Integer id, String name, String surname, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.isDeleted = isDeleted;
    }
    public Stylist() {}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isDeleted() {
        return isDeleted;
    }
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
