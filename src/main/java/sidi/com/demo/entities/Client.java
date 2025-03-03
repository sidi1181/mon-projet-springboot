package sidi.com.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "le nom est obligatoire")
    @Size(min = 3, message = "Le nom doit avoir au moins 3 caractères")
    private String nom;
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    private String email;
    @NotBlank(message = "le numéro est obligatoire")
    @Pattern(regexp = "\\d{8,15}", message = "le numéro de téléphone doit être valide")
    private String phone;
    @NotBlank(message = "L'adresse est obligatoire")
    private String address;
    @Temporal(TemporalType.DATE)
    @Past(message = "La date de naissance doit être dans le passé")
    private Date birthday;

}
