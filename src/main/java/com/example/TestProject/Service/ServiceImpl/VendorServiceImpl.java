package com.example.TestProject.Service.ServiceImpl;

import com.example.TestProject.Dto.VendorDto;
import com.example.TestProject.Entity.VendorEntity;
import com.example.TestProject.Exception.ResourceNotFoundException;
import com.example.TestProject.Repository.VendorRepository;
import com.example.TestProject.Service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<VendorDto> GetAllVendor() {
        List<VendorEntity> vendorEntities= vendorRepository.findAll();
        return vendorEntities.stream().map
                (VendorEntity -> mapToDTO(VendorEntity)).collect(Collectors.toList());
    }

    @Override
    public VendorDto UpdateVendor(VendorDto vendorDto, long VendorId) {
        VendorEntity vendorEntity = vendorRepository.findById(VendorId).orElseThrow(()-> new ResourceNotFoundException("LSDRWRRELEntity","VendorId",VendorId));
        vendorEntity.setVendorId(vendorDto.getVendorId());
        vendorEntity.setVendorName(vendorDto.getVendorName());
        vendorEntity.setDescription(vendorDto.getDescription());
        vendorEntity.setStatus(vendorDto.getStatus());

        VendorEntity updateRelease= vendorRepository.save(vendorEntity);
        return mapToDTO(updateRelease);
    }

    @Override
    public VendorDto createVendor(VendorDto vendorDto) {
        VendorEntity vendorEntity= mapToEntity(vendorDto);
        VendorEntity newVendor=vendorRepository.save(vendorEntity);

        VendorDto vendorResponse = mapToDTO(newVendor);
        return vendorResponse;
    }



    private VendorDto mapToDTO(VendorEntity vendorEntity){
        VendorDto vendorDto=new VendorDto();

        vendorDto.setVendorId(vendorEntity.getVendorId());
        vendorDto.setVendorName(vendorEntity.getVendorName());
        vendorDto.setDescription(vendorEntity.getDescription());
        vendorDto.setStatus(vendorEntity.getStatus());

        return vendorDto;
    }


    private VendorEntity mapToEntity(VendorDto vendorDto) {

        VendorEntity vendorEntity = new VendorEntity();

        vendorEntity.setVendorId(vendorDto.getVendorId());
        vendorEntity.setVendorName(vendorDto.getVendorName());
        vendorEntity.setDescription(vendorDto.getDescription());
        vendorEntity.setStatus(vendorDto.getStatus());

        return vendorEntity;
    }




}
