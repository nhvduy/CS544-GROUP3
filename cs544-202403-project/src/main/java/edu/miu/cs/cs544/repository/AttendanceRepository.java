package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Attendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends BaseRepository<Attendance,Integer> {

    @Query("SELECT a FROM Attendance a WHERE a.scanner.event IN (SELECT e FROM Member m JOIN m.events e WHERE m.memberId = :memberId)")
    List<Attendance> findAttendanceByMemberId(@Param("memberId") Integer memberId);

    @Query("SELECT a FROM Attendance a WHERE a.member.memberId = :memberId")
    List<Attendance> findAllByMemberId(@Param("memberId") Integer memberId);
}
