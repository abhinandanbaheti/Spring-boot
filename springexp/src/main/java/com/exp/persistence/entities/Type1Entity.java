package com.exp.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type1")
public class Type1Entity extends BaseEntity {

    //@Id
    int entityId;
    String entityName;
    String entityType;

    public Type1Entity() {
        super();
    }

    public Type1Entity(String dbId, int entityId, String entityName, String entityType) {
        super();
        this.dbId = dbId;
        this.entityId = entityId;
        this.entityName = entityName;
        this.entityType = entityType;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + entityId;
        result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
        result = prime * result + ((entityType == null) ? 0 : entityType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Type1Entity other = (Type1Entity) obj;
        if (entityId != other.entityId)
            return false;
        if (entityName == null) {
            if (other.entityName != null)
                return false;
        } else if (!entityName.equals(other.entityName))
            return false;
        if (entityType == null) {
            if (other.entityType != null)
                return false;
        } else if (!entityType.equals(other.entityType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Type1Entity [entityId=" + entityId + ", entityName=" + entityName + ", entityType=" + entityType + "]";
    }

}
