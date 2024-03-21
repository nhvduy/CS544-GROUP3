package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionRepository extends BaseRepository<Session, Integer>{

    @Query(value = "select s from Session s  where s.event.eventId =:eventId and s.sessionId =:sessionId")
    Session findByEventIdAndSessionId(@Param("eventId")Integer eventId,@Param("sessionId")Integer sessionId);
}
