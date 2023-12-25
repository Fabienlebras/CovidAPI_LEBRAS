package org.polytech.covid.Repository;

import org.polytech.covid.Model.SuperAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperAdministratorRepository extends JpaRepository<SuperAdministrator, Long> {

}
