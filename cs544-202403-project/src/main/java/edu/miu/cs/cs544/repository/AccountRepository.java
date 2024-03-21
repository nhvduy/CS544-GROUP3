package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Attendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AccountRepository extends BaseRepository<Account, Integer>{
    @Query(value = "select m.email from Account a, Member m where a.member_id = m.id and cvalue < dvalue*0.05", nativeQuery = true)
    List<String> findAccountsByBalanceCondition();

//    @Query(value = "SELECT a.* FROM Account a " +
//            "JOIN Attendance at ON at.member_Id = a.member_Id " +
//            "WHERE a.accountId = :accountId " +
//            "AND CAST(at.scanDateTime AS date) BETWEEN :startDate AND :endDate", nativeQuery = true)
//    List<Attendance> findAllByAccountId(@Param("accountId") Integer accountId,
//                                        @Param("startDate") String startDate,
//                                        @Param("endDate") String endDate);

    @Query(value = "SELECT a FROM Attendance a " +
            " inner JOIN a.member m inner JOIN m.accounts acc " +
            "WHERE acc.accountId = :accountId " +
            "AND a.scanDate BETWEEN :startDate AND :endDate")

    List<Attendance> findAllByAccountId(@Param("accountId") Integer accountId,
                                        @Param("startDate") LocalDateTime startDate,
                                        @Param("endDate") LocalDateTime endDate);




}
