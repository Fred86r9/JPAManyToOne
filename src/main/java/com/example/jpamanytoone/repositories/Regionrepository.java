package com.example.jpamanytoone.repositories;

import com.example.jpamanytoone.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Regionrepository extends JpaRepository<Region, String> {
}
