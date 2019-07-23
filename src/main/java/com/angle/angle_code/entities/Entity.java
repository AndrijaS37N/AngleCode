package com.angle.angle_code.entities;

public class Entity {

    private long entityId;
    private String entityName;

    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public String toString() {
        return "Entity{" + "entityId=" + entityId + ", entityName='" + entityName + '\'' + '}';
    }
}
