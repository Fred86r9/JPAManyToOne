package com.example.jpamanytoone.controller;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.repositories.KommuneRepository;
import com.example.jpamanytoone.repositories.Regionrepository;
import com.example.jpamanytoone.service.ApiServiceGetKommuner;
import com.example.jpamanytoone.service.ApiServiceGetRegions;
import com.example.jpamanytoone.exceptiontrial.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RegionRestController
{
    @Autowired
    ApiServiceGetRegions apiServiceGetRegions;
    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @Autowired
    Regionrepository regionRepository;
    @Autowired
    KommuneRepository kommuneRepository;

    //Mapping for retrieving regions from DB
    @GetMapping("/getregiondb")
    public List<Region> getRegionerDB()
    {
        return regionRepository.findAll();
    }

    //Mapping for retrieving kommuner from DB
    @GetMapping("/getkommunedb")
    public List<Kommune> getKommunerDB()
    {
        return kommuneRepository.findAll();
    }

    //Mapping for retrieving regions from api
    @GetMapping("/getregioner")
    public List<Region> getRegioner()
    {
        List<Region> lstRegioner = apiServiceGetRegions.getRegioner();
        return lstRegioner;
    }

    //Mapping for retrieving kommuner from api
    @GetMapping("/getkommuner")
    public List<Kommune> getKommuner()
    {
        List<Kommune> lstKommuner = apiServiceGetKommuner.getKommuner();
        return lstKommuner;
    }

    @DeleteMapping("/region/{id}")
    public ResponseEntity<String> deleteRegion(@PathVariable String id)
    {
        Optional<Region> orgRegion = regionRepository.findById(id);
        if(orgRegion.isPresent())
        {
            regionRepository.deleteById(id);
            return ResponseEntity.ok("Region deleted");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Region not found");
        }
    }

    @GetMapping("/kommunenavne/{id}")
    public List<String> getKommuneNavne(@PathVariable String id)
    {
        Optional<Region> region = regionRepository.findById(id);
        if(region.isEmpty())
        {
            System.out.println("No regions found");
            throw new NotFoundException("Region not found");

        }

        List<String> kommunenavne = region.get().getKommunenavnById();

        return kommunenavne;
    }
}
