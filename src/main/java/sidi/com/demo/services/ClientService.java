package sidi.com.demo.services;

import org.springframework.stereotype.Service;
import sidi.com.demo.entities.Client;
import sidi.com.demo.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Ajouter un client
    public Client ajouterClient(Client client) {
        return clientRepository.save(client);
    }

    // Récupérer tous les clients
    public List<Client> obtenirTousLesClients() {
        return clientRepository.findAll();
    }

    // Récupérer un client par ID
    public Optional<Client> obtenirClientParId(Long id) {
        if (clientRepository.existsById(id)) {
            return clientRepository.findById(id);
        }
        return Optional.empty();
    }

    // Modifier un client
    public Client modifierClient(Long id, Client clientMisAJour) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setNom(clientMisAJour.getNom());
                    client.setEmail(clientMisAJour.getEmail());
                    client.setPhone(clientMisAJour.getPhone());
                    client.setAddress(clientMisAJour.getAddress());
                    client.setBirthday(clientMisAJour.getBirthday());
                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new RuntimeException("Client non trouvé !"));
    }

    // Supprimer un client
    public String supprimerClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return "Client supprimé avec succès !";
        } else {
            return "Client non trouvé !";
        }
    }
}
