package com.example.TestProject.Controller;


import com.example.TestProject.Dto.VendorDto;
import com.example.TestProject.Service.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/posts")
public class VendorController {

    private VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/get")
    public List<VendorDto> GetVendor(){
        return vendorService.GetAllVendor();
    }

    @PostMapping("/post")
    public ResponseEntity<VendorDto> createPost(@RequestBody VendorDto vendorDto){
        return new ResponseEntity<>(vendorService.createVendor(vendorDto), HttpStatus.CREATED);

    }


    @PutMapping("/{VendorId}")
    public ResponseEntity<VendorDto> updateRelease(@RequestBody VendorDto vendorDto,@PathVariable(name = "VendorId") long VendorId){
        VendorDto postResponse = vendorService.UpdateVendor(vendorDto,VendorId);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }

}
