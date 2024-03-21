package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Attendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends BaseRepository<Attendance,Integer> {



//    @Query(value = "SELECT a.*"+
//            "FROM ea_project.dbo.Account a"+
//            "JOIN ea_project.dbo.Attendance at ON at.member_Id = a.member_Id"+
//            "WHERE a.accountId = :accountId "+
//            "AND CAST(at.scanDateTime AS date) BETWEEN startDate AND endDate", nativeQuery = true)
//    List<Attendance> findAllByAccountId(@Param("accountId") Integer accountId, @Param("startDate") String startDate,@Param("endDate") String endDate);

//    @Query("SELECT a FROM Account a " +
//            "WHERE a.accountId = :accountId " +
//            "AND a.memberId IN " +
//            "(SELECT at.memberId FROM Attendance at " +
//            "WHERE at.scanDateTime BETWEEN :startDate AND :endDate)")
//    List<Account> findAccountsByAccountIdAndScanDateRange(Long accountId,
//                                                          LocalDateTime startDate,
//                                                          LocalDateTime endDate);
//@Query(value = "SELECT a.* FROM Account a " +
//        "JOIN Attendance at ON at.member_Id = a.member_Id " +
//        "WHERE a.accountId = :accountId " +
//        "AND CAST(at.scanDateTime AS date) BETWEEN :startDate AND :endDate", nativeQuery = true)
//List<Attendance> findAllByAccountId(@Param("accountId") Integer accountId,
//                                 @Param("startDate") String startDate,
//                                 @Param("endDate") String endDate);



    @Query("SELECT a FROM Attendance a WHERE a.member.memberId = :memberId")
    List<Attendance> findAllByMemberId(@Param("memberId") Integer memberId);

}
