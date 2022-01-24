package com.example.TestProject.Repository;

import com.example.TestProject.Entity.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<VendorEntity,Long> {
}
