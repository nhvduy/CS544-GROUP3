package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SessionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SessionRepository sessionRepository;

    @Test
    public void whenFindByEventIdAndSessionId_thenReturnSession(){
        //given
        Event event = new Event("EA","EA description",LocalDateTime.of(2024,03,01,10,00),LocalDateTime.of(2024,03,01,10,00));
        Session session = new Session(LocalDateTime.of(2024,03,01,10,00),LocalDateTime.of(2024,03,22,12,00),10);
        Session session2 = new Session(LocalDateTime.of(2024,03,01,14,00),LocalDateTime.of(2024,03,22,16,00),12);
        List<Session> sessions = new ArrayList<>();
        sessions.add(session);
        sessions.add(session2);
        event.setSchedule(sessions);
        session.setEvent(event);
        session2.setEvent(event);
        entityManager.persist(session);
        entityManager.persist(session2);
        entityManager.persist(event);
        entityManager.flush();
        //when
        Session sessions2 = sessionRepository.findByEventIdAndSessionId(1,1);
        assertThat(sessions2.getNumOfSessions(),equalTo(10));
    }

}
