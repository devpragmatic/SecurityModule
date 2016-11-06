package pl.devpragmatic.securitymodule.service;

import org.springframework.stereotype.Service;
import pl.devpragmatic.securitymodule.context.UserContextDTO;

/**
 * Secure service
 * @author devpragmatic
 */
@Service
public interface SecureService {
    
    UserContextDTO getUserContext();
    
    String getUserName();
}