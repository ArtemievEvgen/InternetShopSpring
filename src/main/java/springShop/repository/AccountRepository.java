package springShop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springShop.entity.Account;

import java.util.List;


@Repository
public interface AccountRepository extends  JpaRepository<Account, Integer>
{


    Account findByUsername(String username);

    Account findByEmail(String email);



   @Query("SELECT u FROM Account u WHERE u.id = :paramId")
   List<Account> accountList(@Param("paramId") Integer id);


}
