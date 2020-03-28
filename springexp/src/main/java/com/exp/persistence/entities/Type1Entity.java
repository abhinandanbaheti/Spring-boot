package com.exp.persistence.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "type1")
public class Type1Entity extends BaseEntity {

    //@Id
    int entityId;
    String entityName;
    String entityType;


    @ElementCollection
    @CollectionTable(name = "user_phone_numbers", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "phone_number")
    private Set<String> phoneNumbers = new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_addresses", joinColumns = @JoinColumn(name = "user_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Set<Address> addresses = new HashSet<>();

    public Type1Entity() {
        super();
    }

    public Type1Entity(String dbId, int entityId, String entityName, String entityType, Set<String> phoneNumbers, Set<Address> addresses) {
        super();
        this.dbId = dbId;
        this.entityId = entityId;
        this.entityName = entityName;
        this.entityType = entityType;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Type1Entity that = (Type1Entity) o;
        return entityId == that.entityId &&
                Objects.equals(entityName, that.entityName) &&
                Objects.equals(entityType, that.entityType) &&
                Objects.equals(phoneNumbers, that.phoneNumbers) &&
                Objects.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), entityId, entityName, entityType, phoneNumbers, addresses);
    }
}
