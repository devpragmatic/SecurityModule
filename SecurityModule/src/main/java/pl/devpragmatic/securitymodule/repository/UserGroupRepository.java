package pl.devpragmatic.securitymodule.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.devpragmatic.securitymodule.entity.UserGroup;

/**
 * Repository interface for user group
 * @author devpragmatic
 */
@Repository
public interface UserGroupRepository extends CrudRepository<UserGroup, Long> {

    /**
     * Finding user group by user
     * @param userId id of user
     * @return user groups
     */
    @Query("select ug from UserGroup ug join ug.users u where u.userId = :userId")
    public List<UserGroup> findByUser(@Param("userId") Long userId);
    
}
