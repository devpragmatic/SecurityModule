package pl.devpragmatic.securitymodule.dto;

import pl.devpragmatic.generalcore.dto.BaseDTO;

/**
 *
 * @author devpragmatic
 */
public class UserDTO implements BaseDTO {

    /**
     * User name
     */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
