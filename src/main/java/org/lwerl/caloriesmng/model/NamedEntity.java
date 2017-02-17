package org.lwerl.caloriesmng.model;

/**
 * Created by lWeRl on 17.02.2017.
 */
public class NamedEntity extends BaseEntity {
    protected String name;

    protected NamedEntity(String name) {
        this.name = name;
    }

    public NamedEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
