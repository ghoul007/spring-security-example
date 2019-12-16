package org.ghoul.dao;

import org.ghoul.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, String>   {

}
