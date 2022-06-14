package com.aprendiendo.android.Models;

public class CategoryModel {
    Integer categoryLogo;
    String categoryName;

    public void setCategoryLogo(Integer categoryLogo) {
        this.categoryLogo = categoryLogo;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryModel(Integer categoryLogo, String categoryName)
    {
        this.categoryLogo = categoryLogo;
        this.categoryName = categoryName;

    }

    public Integer getCategoryLogo() {
        return categoryLogo;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
