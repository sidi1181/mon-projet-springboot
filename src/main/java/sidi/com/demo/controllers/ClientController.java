package sidi.com.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import sidi.com.demo.entities.Client;
import sidi.com.demo.services.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/ajouter")
    public Client ajouterClient(@Valid @RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @GetMapping("/tous")
    public List<Client> obtenirTousLesClients() {
        return clientService.obtenirTousLesClients();
    }

    @GetMapping("/{id}")
    public Optional<Client> obtenirClientParId(@PathVariable Long id) {
        return clientService.obtenirClientParId(id);
    }

    @PutMapping("/modifier/{id}")
    public Client modifierClient(@PathVariable Long id, @RequestBody Client clientMisAJour) {
        return clientService.modifierClient(id, clientMisAJour);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimerClient(@PathVariable Long id) {
        return clientService.supprimerClient(id);
    }
}
