package pl.devpragmatic.securitymodule.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Group of users
 * @author devpragmatic
 */
@Entity
public class UserGroup {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "usergroup_user", joinColumns = {
			@JoinColumn(name="id")},
			inverseJoinColumns = { @JoinColumn(name = "user_id")})
    
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
}
