package org.lwerl.caloriesmng.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

//import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.*;

@MappedSuperclass
@Access(AccessType.FIELD)
//@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class BaseEntity {
    @Id
    @SequenceGenerator(name="global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    public BaseEntity() {
    }

    public BaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNew() {
        return (id == null);
    }
}
