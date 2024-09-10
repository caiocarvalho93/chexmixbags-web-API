package com.kenzie.appserver.service.model;

import com.kenzie.appserver.repositories.model.NutritionalInfo;

public class ChexMixBagDTO {
    private String id;
    private String type;
    private int quantity;
    private String batchNumber;
    private String supplier;
    private String expirationDate;
    private NutritionalInfoDTO nutritionalInfo;

    public ChexMixBagDTO() {
        super();
    }

    public ChexMixBagDTO(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public NutritionalInfoDTO getNutritionalInfo() {
        return nutritionalInfo;
    }

    public void setNutritionalInfo(NutritionalInfoDTO nutritionalInfo) {
        this.nutritionalInfo = nutritionalInfo;
    }
}

