package ug.zad06.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@NamedQueries({
        @NamedQuery(name = "producer.getAll", query = "SELECT p FROM Producer p"),
        @NamedQuery(name = "producer.deleteAll", query = "DELETE FROM Producer"),
        @NamedQuery(name = "producer.findByName", query = "SELECT p FROM Producer p WHERE p.name = :name"),
        @NamedQuery(name = "producer.deleteById", query = "DELETE FROM Producer p WHERE p.id = :id")
})
@XmlRootElement
public class Producer {
    private Long id;
    private String name;

    public Producer() {}

    public Producer(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
