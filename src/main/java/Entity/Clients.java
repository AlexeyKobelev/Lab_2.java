package Entity;

import javax.persistence.*;

@Entity
@Table(name = "Clients")
@NamedQuery(name = "Clients.getAll", query = "SELECT c from Clients c")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "surname", length = 255)
    private String surname;
    @ManyToOne
    @JoinColumn(name = "idStylists")
    private Stylist idStylists;
    @Column(name = "isDeleted")
    private boolean del;

    public Clients(Integer id, String name, String surname,Stylist idStylists, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.idStylists = idStylists;
        this.del = isDeleted;
    }
    public Clients() {}
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
    public Stylist getIdStylists() {
        return idStylists;
    }
    public void setIdStylists(Stylist idStylists) {
        this.idStylists = idStylists;
    }
    public boolean isDeleted() {
        return del;
    }
    public void setDeleted(boolean deleted) {
        del = deleted;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id_client=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", exist=" + del +
                '}';
    }
}
