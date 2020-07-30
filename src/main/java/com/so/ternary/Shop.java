package com.so.ternary;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "sh_shops")
public class Shop {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @NotBlank(message = "Shop name can not be left blank")
    private String sh_name;

    @NotBlank(message = "please provide shop icon")
    private String sh_icon;

    @NotBlank(message = "please fill the shop description")
    private String sh_description;

    @NotBlank
    private String sh_tag;

    public Shop() {
    }

    public Shop(String sh_name, String sh_icon, String sh_description, String sh_tag) {
        this.sh_name = sh_name;
        this.sh_icon = sh_icon;
        this.sh_description = sh_description;
        this.sh_tag = sh_tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSh_name() {
        return sh_name;
    }

    public void setSh_name(String sh_name) {
        this.sh_name = sh_name;
    }

    public String getSh_icon() {
        return sh_icon;
    }

    public void setSh_icon(String sh_icon) {
        this.sh_icon = sh_icon;
    }

    public String getSh_description() {
        return sh_description;
    }

    public void setSh_description(String sh_description) {
        this.sh_description = sh_description;
    }

    public String getSh_tag() {
        return sh_tag;
    }

    public void setSh_tag(String sh_tag) {
        this.sh_tag = sh_tag;
    }
}
