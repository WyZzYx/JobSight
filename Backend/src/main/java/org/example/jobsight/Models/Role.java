package org.example.jobsight.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "roles")
public class Role  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    private String authority;

    public Role(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Role() {
        super();
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Role(String authority) {
        this.authority = authority;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
