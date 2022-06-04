package tup.stockTracking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tup.stockTracking.Models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
