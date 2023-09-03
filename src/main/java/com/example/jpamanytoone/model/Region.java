package com.example.jpamanytoone.model;

import com.example.jpamanytoone.repositories.KommuneRepository;
import com.example.jpamanytoone.repositories.Regionrepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Region {

    @Id
    @Column(length = 4)
    private String kode;
    private String navn;
    private String href;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
    @JsonBackReference
    private Set<Kommune> kommuner = new HashSet<>();


    public List<String> getKommunenavnById()
    {
        List<String> navneList = new ArrayList<>();

        for (Kommune kommune:kommuner)
        {
            navneList.add(kommune.getNavn());
        }
        return navneList;
    }

    public String getKode() {
        return kode;
    }

    public String getNavn() {
        return navn;
    }

    public String getHref() {
        return href;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
