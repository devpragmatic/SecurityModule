package pl.devpragmatic.securitymodule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Roles for users
 * @author devpragmatic
 */
@Entity
@Table(name = "roles")
public class Role {
    
    @Id
    @GeneratedValue
    private Long role_id;
    
    @Column(unique = true)
    private String name;
    
    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
