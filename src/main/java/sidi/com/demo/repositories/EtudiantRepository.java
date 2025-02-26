package sidi.com.demo.repositories;


import org.springframework.stereotype.Repository;
import sidi.com.demo.entities.Etudiant;

import java.util.ArrayList;

@Repository
public class EtudiantRepository {

    private ArrayList<Etudiant> etudiants;

    public EtudiantRepository() {
        this.etudiants = new ArrayList<>();
        this.etudiants.add(new Etudiant(1, "ahmed", "Mohamed"));
        this.etudiants.add(new Etudiant(2, "SIDI", "ali"));
    }

    public int addEtudiant(Etudiant etudiant) {
        if(this.rechercherEtudiant(etudiant.getId()) == -1){
            this.etudiants.add(etudiant);
            return 1;
        }
        else {
            return 0;
        }
    }

    public int rechercherEtudiant(int number) {
        for (int i = 0; i < this.etudiants.size(); i++) {
            if (this.etudiants.get(i).getId() == number) {
                return i;
            }
        }
        return -1;
    }

    public int modifierEtudiant( int position, Etudiant etudiant) {
        this.etudiants.get(position).setNom(etudiant.getNom());
        this.etudiants.get(position).setNiveau(etudiant.getNiveau());
        return position;
    }

    public ArrayList<Etudiant> getall() {
        return this.etudiants;
    }


    public int deleteEtudiant(int id) {
        int position = this.rechercherEtudiant(id);
        if (position == -1) {
            return 0;
        }
        this.etudiants.remove(position);
        return 1;
    }

}