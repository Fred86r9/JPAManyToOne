package com.example.jpamanytoone.repositories;

import com.example.jpamanytoone.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KommuneRepository extends JpaRepository<Kommune, String> {
    //List<String> getNavnById(String id);
}
