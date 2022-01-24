package com.example.TestProject.Service;

import com.example.TestProject.Dto.VendorDto;

import java.util.List;

public interface VendorService {

    List<VendorDto> GetAllVendor();

    VendorDto UpdateVendor(VendorDto vendorDto, long VendorId);

    VendorDto createVendor (VendorDto vendorDto);
}
