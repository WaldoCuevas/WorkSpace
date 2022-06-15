package tup.stockTracking.Service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tup.stockTracking.Exceptions.ResourceNotFoundException;
import tup.stockTracking.Models.Credenciales;
import tup.stockTracking.Models.Usuario;
import tup.stockTracking.Repository.CredencialesRepository;
import tup.stockTracking.Repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private CredencialesRepository credentialRepository;

    @Override
    public Usuario getUserById(Long id) {

        Usuario usuario = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el id: " + id));
        return usuario;
    }

    @Override
    public List<Usuario> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public Usuario saveUser(Usuario usuario) {

        return userRepository.save(usuario);
    }

    @Override
    public Usuario updateUser(Usuario usuarioModificado, Long id) {

        Usuario usuario = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el id: " + id));

        usuario.setId(usuarioModificado.getId());
        usuario.setNombre(usuarioModificado.getNombre());
        usuario.setApellido(usuarioModificado.getApellido());
        usuario.setEmail(usuarioModificado.getEmail());
        usuario.setEdad(usuarioModificado.getEdad());
        usuario.setRol(usuarioModificado.getRol()); // False por defecto, configurado en la DB
        usuario.setPassword(usuarioModificado.getPassword());

        Usuario usuarioActualizado = userRepository.save(usuario);
        return usuarioActualizado;
    }

    @Override
    public void deleteUser(Long id) {
        Usuario usuario = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el id: " + id));
        userRepository.delete(usuario);

    }

    @Override
    public Credenciales getcredentialById(Long id) {

        Credenciales credencial = credentialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con ese id: " + id));

        return credencial;
    }

    @Override
    public boolean verifyCredentials(Credenciales RequestCredential) {

        Credenciales credencial = getcredentialById(RequestCredential.getId());

        if (credencial.getId().equals(RequestCredential.getId())
                && credencial.getEmail().equals(RequestCredential.getEmail())
                && credencial.getPassword().equals(RequestCredential.getPassword())) {

            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
