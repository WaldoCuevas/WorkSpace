package tup.stockTracking.Service.ProductoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tup.stockTracking.Exceptions.ResourceNotFoundException;
import tup.stockTracking.Models.Producto;
import tup.stockTracking.Repository.ProductoRepository;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoRepository productRepository;

    @Override
    public Producto getProductById(Long id) {

        Producto producto = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el id: " + id));
        return producto;
    }

    @Override
    public List<Producto> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Producto saveProduct(Producto producto) {
        return productRepository.save(producto);
    }

    @Override
    public Producto updateProduct(Producto productoModificado, Long id) {

        Producto producto = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el id: " + id));

        producto.setId(productoModificado.getId());
        producto.setNombre(productoModificado.getNombre());
        producto.setDescripcion(productoModificado.getDescripcion());
        producto.setCantidad(productoModificado.getCantidad());
        producto.setUnidad(productoModificado.getUnidad());

        Producto productoActualizado = productRepository.save(producto);
        return productoActualizado;
    }

    @Override
    public void deleteProduct(Long id) {

        Producto producto = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el id: " + id));
        productRepository.delete(producto);
    }

}
