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

    @Query(value = "select a.* from attendance a, member m, account acc where a.member_id = m.id and m.id = acc.member_id and acc.id = :accountId and format(date_time,'yyyy-mm-dd') between :startDate and :endDate", nativeQuery = true)
    List<Attendance> findAllByAccountId(@Param("accountId") Long accountId, @Param("startDate") String startDate,@Param("endDate") String endDate);

}
