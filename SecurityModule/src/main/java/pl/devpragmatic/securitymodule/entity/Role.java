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
    @Column(name="role_id")
    private Long id;
    
    @Column(unique = true)
    private String name;
    
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
}
