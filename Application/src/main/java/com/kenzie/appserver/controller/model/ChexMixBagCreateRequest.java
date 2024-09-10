package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class ChexMixBagCreateRequest {

    @NotEmpty(message = "You must request with a type or else app will fail")
    @JsonProperty("type")
    private String type;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("batch_number")
    private String batchNumber;
    private String supplier;
    @JsonProperty("expiration_date")
    private String expirationDate;
    @JsonProperty("nutrional_info")
    private NutritionalInfoRequestResponse nutritionalInfo;

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

    public NutritionalInfoRequestResponse getNutritionalInfo() {
        return nutritionalInfo;
    }

    public void setNutritionalInfo(NutritionalInfoRequestResponse nutritionalInfo) {
        this.nutritionalInfo = nutritionalInfo;
    }
}