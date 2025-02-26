package sidi.com.demo.services;

import org.springframework.stereotype.Service;
import sidi.com.demo.entities.Etudiant;
import sidi.com.demo.repositories.EtudiantRepository;

import java.util.ArrayList;

@Service
public class EtudiantService implements EtudiantServiceInterface {

    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public ArrayList<Etudiant> findAll() {
        return this.etudiantRepository.getall();
    }

    public int add(Etudiant etudiant) {

        if(this.etudiantRepository.rechercherEtudiant(etudiant.getId()) == -1){
            this.etudiantRepository.addEtudiant(etudiant);
            return 1;
        }
        else {
            return 0;
        }
    }

    public int edit(Etudiant etudiant){
        int position = this.etudiantRepository.rechercherEtudiant(etudiant.getId());
        if(position == -1){
            return 0;
        }
        else {
            this.etudiantRepository.modifierEtudiant(position, etudiant);
            return 1;
        }
    }

    public int delete(int id){
        return this.etudiantRepository.deleteEtudiant(id);
    }

}
