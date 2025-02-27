package com.maximet.sqlcda.model;

public class Roles {
    //Attributs
    private int id;
    private String rolesName;

    //Constructeur par défaut
    public Roles(){}

    //Constructeur
    public Roles(String rolesName){
        this.rolesName = rolesName;
    }

    //GETTER_ET_SETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roleName='" + rolesName + '\'' +
                "}\n";
    }
}
