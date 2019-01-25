package ug.zad06.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "lock.getAll", query = "SELECT l FROM Lock l"),
        @NamedQuery(name = "lock.findById", query = "SELECT l FROM Lock l WHERE l.id = :id")
})
public class Lock {
    private Long id;
    private Producer producer;
    private Boolean electronic;

    public Lock() {}

    public Lock(Producer producer, boolean electronic) {
        this.producer = producer;
        this.electronic = electronic;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Boolean isElectronic() {
        return electronic;
    }

    public void setElectronic(Boolean electronic) {
        this.electronic = electronic;
    }
}
