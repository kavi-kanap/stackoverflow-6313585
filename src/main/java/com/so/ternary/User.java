package com.so.ternary;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "us_users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Basic(fetch = FetchType.LAZY, optional = false)
    private String uuid;

    @NotBlank(message = "First name can not be empty")
    @Column(name = "usFname")
    private String usFname;

    @NotBlank(message = "Username can not be left empty")
    @Column(name = "us_lname")
    private String usLname;

    @NotBlank(message = "Email field can not be empty")
    @Column(name = "usEmail", unique = true)
    @Basic(fetch = FetchType.LAZY, optional = false)
    private String usEmail;

    @ManyToMany
    @MapKeyJoinColumn(name = "shop_fk")
    @JoinTable(name = "user_shop_role",
            joinColumns = @JoinColumn(name = "user_fk"), inverseJoinColumns = @JoinColumn(name = "role_fk"))
    private Map<Shop, Role> shopRoleMap = new HashMap<>();

    public User() {
    }

    public User(String uuid, String usFname, String usLname, String usEmail) {
        this.uuid = uuid;
        this.usFname = usFname;
        this.usLname = usLname;
        this.usEmail = usEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsFname() {
        return usFname;
    }

    public void setUsFname(String usFname) {
        this.usFname = usFname;
    }

    public String getUsLname() {
        return usLname;
    }

    public void setUsLname(String usLname) {
        this.usLname = usLname;
    }

    public String getUsEmail() {
        return usEmail;
    }

    public void setUsEmail(String usEmail) {
        this.usEmail = usEmail;
    }

    public Map<Shop, Role> getShopRoleMap() {
        return shopRoleMap;
    }

    public void setShopRoleMap(Map<Shop, Role> shopRoleMap) {
        this.shopRoleMap = shopRoleMap;
    }
}
