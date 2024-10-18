package com.server.soap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.entities.Tienda;
import com.server.entities.Usuario;
import com.server.repositories.ITiendaRepository;
import com.server.repositories.IUsuarioRepository;
import com.server.usuario.CargaMasivaUsuariosRequest; // Asegúrate de que esta importación sea correcta
import com.server.usuario.CargaMasivaUsuariosResponse;

@Service
public class SPusuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private ITiendaRepository tiendaRepository;

    public List<CargaMasivaUsuariosResponse.Errores> cargarUsuarios(List<CargaMasivaUsuariosRequest.Usuario> usuarios) {
        List<CargaMasivaUsuariosResponse.Errores> errores = new ArrayList<>();

        for (int i = 0; i < usuarios.size(); i++) {
            CargaMasivaUsuariosRequest.Usuario usuario = usuarios.get(i);
            boolean tieneErrores = false;

            if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
                agregarError(errores, i, "El nombre está vacío");
                tieneErrores = true;
            }
            if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
                agregarError(errores, i, "El email está vacío");
                tieneErrores = true;
            }
            if (usuario.getClave() == null || usuario.getClave().isEmpty()) {
                agregarError(errores, i, "La clave está vacía");
                tieneErrores = true;
            }

            if (usuarioRepository.existsByEmail(usuario.getEmail())) {
                agregarError(errores, i, "El email ya existe");
                tieneErrores = true;
            }

            Tienda tienda = tiendaRepository.findByCodigo(usuario.getCodigoTienda()).orElse(null);
            if (tienda == null) {
                agregarError(errores, i, "El código de tienda no existe");
                tieneErrores = true;
            } else if (!tienda.isHabilitado()) {
                agregarError(errores, i, "La tienda está deshabilitada");
                tieneErrores = true;
            }

            if (!tieneErrores) {
                Usuario user = new Usuario();
                user.setNombre(usuario.getNombre());
                user.setEmail(usuario.getEmail());
                user.setClave(usuario.getClave());
                user.setHabilitado(true);
                user.setRol("ROLE_TIENDA");
                user.setTienda(tienda);

                usuarioRepository.save(user);
            }
        }
        return errores;
    }

    private void agregarError(List<CargaMasivaUsuariosResponse.Errores> errores, int index, String mensaje) {
        CargaMasivaUsuariosResponse.Errores error = new CargaMasivaUsuariosResponse.Errores();
        error.setLinea(index + 1);
        error.setMensajeError(mensaje);
        errores.add(error);
    }
}
