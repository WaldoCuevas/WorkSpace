package tup.stockTracking.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tup.stockTracking.Models.Usuario;
import tup.stockTracking.Repository.UsuarioRepository;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repositorio;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return repositorio.findAll();
    }

    @PostMapping("/usuarios")
    public Usuario guardarUsuario(@RequestBody Usuario u) {
        return repositorio.save(u);
    }
}