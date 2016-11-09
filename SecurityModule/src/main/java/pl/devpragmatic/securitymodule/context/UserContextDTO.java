package pl.devpragmatic.securitymodule.context;

import java.util.List;

/**
 * Data Transfer object for user context
 * @author devpragmatic
 */
public class UserContextDTO {
    
    /**
     * User is logged
     */
    private boolean logged;
    
    /**
     * User name
     */
    private String userName;
    
    /**
     * Groups 
     */
    private List<UserGroupDTO> groups;
    
    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserGroupDTO> getGroups() {
        return groups;
    }

    public void setGroups(List<UserGroupDTO> groups) {
        this.groups = groups;
    }
}
