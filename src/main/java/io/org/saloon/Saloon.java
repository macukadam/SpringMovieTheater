package io.org.saloon;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Saloon {

    @Id
    private String id;
    private String name;

    public Saloon(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
