package com.example.nahiduddinahammed.minidoctorproject;


public class Medicine {
    private String DrugFor;
    private String DragClass;
    private String BrandeName;
    private String Contains;
    private String DosageForm;
    private String Price;



    public Medicine(String drugFor, String dragClass, String brandeName, String contains, String dosageForm, String price, int image) {
        DrugFor = drugFor;
        DragClass = dragClass;
        BrandeName = brandeName;
        Contains = contains;
        DosageForm = dosageForm;
        Price = price;

    }

    public String getDrugFor() {
        return DrugFor;
    }

    public String getDragClass() {
        return DragClass;
    }

    public String getBrandeName() {
        return BrandeName;
    }

    public String getContains() {
        return Contains;
    }

    public String getDosageForm() {
        return DosageForm;
    }

    public String getPrice() {
        return Price;
    }


}

