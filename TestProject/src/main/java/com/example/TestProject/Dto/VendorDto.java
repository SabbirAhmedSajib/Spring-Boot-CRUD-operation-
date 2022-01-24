package com.example.TestProject.Dto;

import lombok.Data;

@Data
public class VendorDto {
    private long VendorId;
    private String VendorName;
    private String Description;
    private String Status;


    public long getVendorId() {
        return VendorId;
    }

    public void setVendorId(long vendorId) {
        VendorId = vendorId;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
