package ug.zad06.util;

import ug.zad06.domain.Producer;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ProducerResponse {
    private List<Producer> producer = new ArrayList<>();

    public List<Producer> getProducer() {
        return producer;
    }

    public void setProducer(List<Producer> producer) {
        this.producer = producer;
    }
}
