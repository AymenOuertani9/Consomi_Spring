package tn.esprit.pidev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    public Role findByRole(String role);

}
