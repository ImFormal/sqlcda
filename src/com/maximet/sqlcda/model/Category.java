package com.maximet.sqlcda.model;

public class Category {
    //Attributs
    private int id;
    private String categoryName;

    //Constructeur par défaut
    public Category(){}

    //Constructeur
    public Category(String categoryName){
        this.categoryName = categoryName;
    }

    //GETTER_ET_SETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                "}\n";
    }
}
