package tup.stockTracking.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tup.stockTracking.Exceptions.ResourceNotFoundException;
import tup.stockTracking.Models.Producto;
import tup.stockTracking.Repository.ProductoRepository;

@RestController
@RequestMapping({ "/api/" })
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductoController {

    // Inyección de dependencias.
    @Autowired
    private ProductoRepository repository;

    // Este metodo sirve para listar todos los productos
    @GetMapping("/productos")
    public List<Producto> listarTodosLosProductos() {
        return repository.findAll();
    }
    

    // Este metodo sirve para guardar un producto
    @PostMapping("/productos")
    public Producto Create(@RequestBody Producto producto) {
        return repository.save(producto);
    }

    // Este metodo sirve para buscar un producto
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el id: " + id));
        return ResponseEntity.ok(producto);
    }

    // Modificar un producto mediante ID
    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto detalleProducto) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el id: " + id));

        producto.setId(detalleProducto.getId());
        producto.setNombre(detalleProducto.getNombre());
        producto.setDescripcion(detalleProducto.getDescripcion());
        producto.setCantidad(detalleProducto.getCantidad());
        producto.setUnidad(detalleProducto.getUnidad());

        Producto productoActualizado = repository.save(producto);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable Long id) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el id: " + id));
        repository.delete(producto);
        Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }

}
