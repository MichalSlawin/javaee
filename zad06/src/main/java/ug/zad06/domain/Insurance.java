package ug.zad06.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "insurance.all", query = "SELECT i FROM Insurance i"),
        @NamedQuery(name = "insurance.byId", query = "SELECT i FROM Insurance i WHERE i.id = :id")
})
public class Insurance {
    private Long id;
    private String type;
    private Date startDate;
    private Date endDate;
    private List<Door> doors;

    public Insurance() {}

    public Insurance(String type, Date startDate, Date endDate) {
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Temporal(TemporalType.DATE)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.DATE)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }
}
