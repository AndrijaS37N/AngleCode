package com.angle.angle_code;

import com.angle.angle_code.entities.AngleEntity;
import com.angle.angle_code.repositories.AngleEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AngleEntityRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AngleEntityRepository angleEntityRepository;

    @Test
    public void testFindAngleEntityByAngleEntityName() {

        entityManager.persist(new AngleEntity("Andrija"));

        List<AngleEntity> angleEntities = angleEntityRepository.findAngleEntityByAngleEntityName("Andrija");
        assertEquals(1, angleEntities.size());

        // Note: Not working? AssertThat cannot resolve angleEntities...
        // assertThat(angleEntities).extracting(AngleEntity::getAngleEntityName).containsOnly("Andrija");
    }
}