package book.store.repository;

import book.store.model.Role;
import book.store.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(RoleName roleName);
}
