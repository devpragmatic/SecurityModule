package pl.devpragmatic.securitymodule.dto;

import java.util.List;

/**
 * Data Transfer object for user context
 *
 * @author devpragmatic
 */
public class UserContextDTO extends UserDTO {

    /**
     * Groups
     */
    private List<UserGroupDTO> groups;

    /**
     * User is logged
     */
    private boolean logged;

    public List<UserGroupDTO> getGroups() {
        return groups;
    }

    public void setGroups(List<UserGroupDTO> groups) {
        this.groups = groups;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

}
