package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends BaseRepository<Account, Integer>{
//    @Query(value = "select m.email from Account a, Member m where a.member_id = m.id and cvalue < dvalue*0.05", nativeQuery = true)
//    List<String> findAccountsByBalanceCondition();


}
