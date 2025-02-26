package sidi.com.demo.services;

import sidi.com.demo.entities.Etudiant;

import java.util.ArrayList;

public interface EtudiantServiceInterface {

    ArrayList<Etudiant> findAll();
    int add(Etudiant etudiant);
    int edit(Etudiant etudiant);
    int delete(int id);
}
