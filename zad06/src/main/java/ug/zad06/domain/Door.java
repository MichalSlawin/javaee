package ug.zad06.domain;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
        @NamedQuery(name = "door.deleteOlder", query = "DELETE FROM Door d WHERE d.productionDate < :date"),
        @NamedQuery(name = "door.getDoorsExpiredInsurance", query = "SELECT d FROM Door d INNER JOIN d.insurances i WHERE i.endDate < CURRENT_DATE "),
        @NamedQuery(name = "door.findByProducerName", query = "SELECT p.name," +
                "d.description, d.price FROM Door d INNER JOIN d.producer p WHERE p.name = :name")
})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany()
    public List<Lock> getLocks() {
        return locks;
    }

    public void setLocks(List<Lock> locks) {
        this.locks = locks;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }
}
