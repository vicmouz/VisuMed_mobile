package com.example.visumed.entidades;

public class Drug {
    private String name;
    private String indications;
    private String counterIndications;
    private String dosage;

    public Drug(String nome, String indications, String counterIndications) {
        this.name = nome;
        this.indications = indications;
        this.counterIndications = counterIndications;
        this.dosage = dosage;
    }

    public Drug(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public String getCounterIndications() {
        return counterIndications;
    }

    public void setCounterIndications(String counterIndications) {
        this.counterIndications = counterIndications;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
