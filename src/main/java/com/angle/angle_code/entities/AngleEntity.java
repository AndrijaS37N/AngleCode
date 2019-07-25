package com.angle.angle_code.entities;

import javax.persistence.*;

@Table(name = "angle_entity")
@Entity
public class AngleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "angle_entity_id")
    private long angleEntityId;

    @Column(name = "angle_entity_name")
    private String angleEntityName;

    public AngleEntity(String angleEntityName) {
        this.angleEntityName = angleEntityName;
    }

    public AngleEntity() {}

    public long getAngleEntityId() {
        return angleEntityId;
    }

    public void setAngleEntityId(long angleEntityId) {
        this.angleEntityId = angleEntityId;
    }

    public String getAngleEntityName() {
        return angleEntityName;
    }

    public void setAngleEntityName(String angleEntityName) {
        this.angleEntityName = angleEntityName;
    }

    @Override
    public String toString() {
        return "AngleEntity{" + "angleEntityId=" + angleEntityId + ", angleEntityName='" + angleEntityName + '\'' + '}';
    }
}
