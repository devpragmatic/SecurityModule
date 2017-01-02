package pl.devpragmatic.securitymodule.entity.factory;

import org.springframework.stereotype.Component;
import pl.devpragmatic.generalcore.factory.AbstractFactoryDTO;
import pl.devpragmatic.securitymodule.dto.UserDTO;
import pl.devpragmatic.securitymodule.entity.User;

/**
 * Factory for User, UserDTO, UserContextDTO
 *
 * @author devpragmatic
 */
@Component
public class UserFactory extends AbstractFactoryDTO<User, UserDTO> {

    @Override
    public UserDTO createDTO(User entity) {
        UserDTO result = new UserDTO();
        result.setUserName(entity.getUsername());
        return result;
    }

    @Override
    public User createEntity(UserDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
