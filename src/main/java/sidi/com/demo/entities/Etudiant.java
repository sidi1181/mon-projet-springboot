package sidi.com.demo.entities;

import lombok.*;

import java.io.Serializable;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

public class Etudiant implements Serializable {

    private int id;
    private String nom;
    private String niveau;


}
