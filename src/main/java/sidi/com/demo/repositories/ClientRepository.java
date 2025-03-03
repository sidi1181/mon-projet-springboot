package sidi.com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sidi.com.demo.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
