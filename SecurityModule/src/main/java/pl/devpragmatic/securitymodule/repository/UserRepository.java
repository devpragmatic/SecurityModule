package pl.devpragmatic.securitymodule.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.devpragmatic.securitymodule.entity.User;

/**
 * Repository interface for user
 * @author devpragmatic
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Find in repository user by username
     * @param username user name
     * @return found user
     */
    public User findOneByUsername(String username);
}