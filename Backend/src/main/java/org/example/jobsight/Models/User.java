package org.example.jobsight.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column
    private String email;

    @Setter
    @Getter
    @Column
    private String name;
    @Column
    private String surname;

    @Setter
    private String password;

    @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> authorities;

    public User(Long id, String username, String password,String email, Set<Role> authorities) {
        this.id = id;
        this.name = username;
        this.password = password;
        this.authorities = authorities;
        this.email = email;
    }

    public User() {
        super();
        this.authorities = new HashSet<Role>();
    }

}
