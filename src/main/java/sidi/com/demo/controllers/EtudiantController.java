package sidi.com.demo.controllers;

import org.springframework.web.bind.annotation.*;
import sidi.com.demo.entities.Etudiant;

import sidi.com.demo.services.EtudiantServiceInterface;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {
    private final EtudiantServiceInterface etudiantService;
    public EtudiantController(EtudiantServiceInterface etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public ArrayList<Etudiant> afficher() {
        return this.etudiantService.findAll();
    }

    @PostMapping
    public void add(@RequestBody Etudiant etudiant) {
        this.etudiantService.add(etudiant);
    }

    @PutMapping
    public void edit( @RequestBody Etudiant etudiant){
        this.etudiantService.edit(etudiant);
    }

    @DeleteMapping
    public void delete(@RequestHeader int id){
        this.etudiantService.delete(id);
    }
}



