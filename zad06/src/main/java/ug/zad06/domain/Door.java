package ug.zad06.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "door.getAll", query = "SELECT d FROM Door d LEFT JOIN FETCH d.insurances"),
        @NamedQuery(name = "door.findById", query = "SELECT d FROM Door d LEFT JOIN FETCH d.insurances WHERE d.id = :id"),
        @NamedQuery(name = "door.deleteAll", query = "DELETE FROM Door"),
        @NamedQuery(name = "door.findByExterior", query = "SELECT d FROM Door d LEFT JOIN FETCH d.insurances WHERE d.exterior = :exterior"),
        @NamedQuery(name = "door.deleteById", query = "DELETE FROM Door d WHERE d.id = :id"),
        @NamedQuery(name = "door.deleteOlder", query = "DELETE FROM Door d WHERE d.productionDate < :date")
//        name = "person.getCarsOfPerson" query = "Select c From Person p Join p.cars c where p.id = :pId"
//        name = "bookAuthor.findByAuthorFirstName"
// query = "Select a.firstName, a.lastName, b.title, b.yop, from Book b
// join b.authors a where a.firstName = :firstName"
})
@XmlRootElement
public class Door {
    private long id;
    private Date productionDate;
    private double weight;
    private boolean exterior;
    private String description;
    private double price;
    private Producer producer;
    private List<Lock> locks;
    private List<Insurance> insurances;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isExterior() {
        return exterior;
    }

    public void setExterior(boolean exterior) {
        this.exterior = exterior;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @OneToMany(fetch = FetchType.EAGER)
    public List<Lock> getLocks() {
        return locks;
    }

    public void setLocks(List<Lock> locks) {
        this.locks = locks;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "doors")
    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }
}
