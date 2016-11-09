package pl.devpragmatic.securitymodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.devpragmatic.securitymodule.context.UserContextDTO;
import pl.devpragmatic.securitymodule.entity.User;
import pl.devpragmatic.securitymodule.entity.factory.UserGroupFactory;
import pl.devpragmatic.securitymodule.repository.UserGroupRepository;
import pl.devpragmatic.securitymodule.repository.UserRepository;

/**
 * Implementation {@link SecureService}
 * @author devpragmatic
 */
@Service
public class SecureServiceImpl implements SecureService{

    @Autowired
    private UserGroupRepository userGroupRepository;
    @Autowired
    private UserGroupFactory userGroupFactory;
    @Autowired 
    private UserRepository userRepository;
    
    @Override
    public UserContextDTO getUserContext() {
        UserContextDTO contextDTO = new UserContextDTO();
        contextDTO.setLogged(isNotAnonymousUser());
        String username = getUserName();
        contextDTO.setUserName(username);
        User user = userRepository.findOneByUsername(username);
        if(user != null){
            contextDTO.setGroups(userGroupFactory.convertToDTO(userGroupRepository.findByUser(user.getUserId())));
        }
        return contextDTO;
    }
    
    /**
     * Checking user is not anonymous
     * @return {@code true} if is not anonymous
     */
    private boolean isNotAnonymousUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return !(auth == null || auth instanceof AnonymousAuthenticationToken);
    }

    /**
     * Logged user name
     * @return user name
     */
    @Override
    public String getUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            return auth.getName();
        }
        return "";
    }
    
    
}
