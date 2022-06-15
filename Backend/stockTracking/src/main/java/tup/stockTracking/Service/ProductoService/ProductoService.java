package tup.stockTracking.Service.ProductoService;

import java.util.List;

import tup.stockTracking.Models.Producto;

public interface ProductoService {

    public Producto getProductById(Long id);

    public List<Producto> getAllProduct();

    public Producto saveProduct(Producto producto);

    public Producto updateProduct(Producto producto, Long id);

    public void deleteProduct(Long id);

}
