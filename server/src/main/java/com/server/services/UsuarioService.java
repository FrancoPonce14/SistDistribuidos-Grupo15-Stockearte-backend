package com.server.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.server.dto.request.LoginRequest;
import com.server.dto.request.UsuarioRequest;
import com.server.dto.response.UsuarioDetalleResponse;
import com.server.dto.response.UsuarioResponse;
import com.server.entities.Usuario;
import com.server.exceptions.ServerException;
import com.server.repositories.IUsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    final private ModelMapper mapper = new ModelMapper();

    public Usuario login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ServerException("Ya existe un usuario registrado con ese email", HttpStatus.NOT_FOUND));
        if (!usuario.getClave().equals(request.getClave())) {
            throw new ServerException("Usuario o contraseña incorrecta", HttpStatus.BAD_REQUEST);
        }
        return usuario;
    }
    
    public boolean crearUsuario(UsuarioRequest request) {
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .clave(request.getClave())
                .habilitado(true)
                .rol(request.getRol())
                .build();
        try {
            usuarioRepository.save(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean modificarUsuario(Long idUsuario, UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new ServerException("Usuario no encontrado", HttpStatus.BAD_REQUEST));
                usuario.setNombre(request.getNombre());
                usuario.setEmail(request.getEmail());
                usuario.setClave(request.getClave());
                usuario.setHabilitado(request.isHabilitado());
        try {
            usuarioRepository.save(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarUsuario(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new ServerException("Usuario no encontrado", HttpStatus.BAD_REQUEST));
        try {
            usuarioRepository.delete(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<UsuarioResponse> traerUsuarios(String nombre, String codigo) {

        int page = 1;
        int size = 9999;
        PageRequest pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id"));
        Page<Usuario> usuariosPage;

            usuariosPage = usuarioRepository.findAll(nombre, codigo, pageable);

        return usuariosPage.getContent().stream().map(user -> mapper.map(user, UsuarioResponse.class))
                .collect(Collectors.toList());
                
    }

    public UsuarioDetalleResponse detalle(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new ServerException("Usuario no encontrado", HttpStatus.BAD_REQUEST));
        return mapper.map(usuario, UsuarioDetalleResponse.class);
    }

    public List<UsuarioResponse> getUsuariosNoAsignados(){
        List<Usuario> usuarios = usuarioRepository.findByTiendaIsNull();
        return usuarios.stream().map(usuario -> mapper.map(usuario, UsuarioResponse.class)).collect(Collectors.toList());
    }
    
}
