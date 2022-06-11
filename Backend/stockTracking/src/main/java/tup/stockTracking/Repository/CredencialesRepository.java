package tup.stockTracking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tup.stockTracking.Models.Credenciales;


@Repository
public interface CredencialesRepository extends JpaRepository<Credenciales,Long>{
    
}
