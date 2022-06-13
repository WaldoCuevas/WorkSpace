package tup.stockTracking.Controllers;

import java.util.List;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tup.stockTracking.Exceptions.ResourceNotFoundException;
import tup.stockTracking.Models.Credenciales;
import tup.stockTracking.Models.Usuario;
import tup.stockTracking.Repository.CredencialesRepository;
import tup.stockTracking.Repository.UsuarioRepository;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioRepository UserRepository;

    @Autowired
    private CredencialesRepository credencialesRepository;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return UserRepository.findAll();
    }

    @GetMapping("/credenciales")
    public List<Credenciales> listarCredenciales() {
        return credencialesRepository.findAll();
    }

    @PostMapping("/usuarios")
    public Usuario guardarUsuario(@RequestBody Usuario u) {
        return UserRepository.save(u);
    }

    @GetMapping("/credenciales/{id}")
    public Credenciales obtenerCredencialById(@PathVariable Long id) {

        Credenciales credencial = credencialesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con ese id: " + id));

        return credencial;
    }



    @PostMapping("/credenciales")
    public ResponseEntity<Credenciales> verificarCredenciales(@RequestBody Credenciales requestCredencial) {

        Credenciales credencial = obtenerCredencialById(requestCredencial.getId());

        if (credencial.getId().equals(requestCredencial.getId())) {
            ResponseEntity.ok("id verificado");

            if (credencial.getEmail().equals(requestCredencial.getEmail())){
                ResponseEntity.ok("email verificado");

                if (credencial.getPassword().equals(requestCredencial.getPassword())){
                    ResponseEntity.ok("password verificado");
                    
                    ResponseEntity.ok("Credenciales verificadas");

                    return ResponseEntity.ok(credencial);

                } ResponseEntity.ok("Fallo con el password");
                return null;

            } ResponseEntity.ok("Fallo con el email");
            return null;

        } ResponseEntity.ok("Fallo con el id");
        return null;
}

}