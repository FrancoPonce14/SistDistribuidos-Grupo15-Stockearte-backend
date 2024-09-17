package com.server.servicesGrpc;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import com.server.entities.Usuario;
import com.server.exceptions.ServerException;
import com.server.grpc.CrudResponse;
import com.server.grpc.DetalleResponse;
import com.server.grpc.Empty;
import com.server.grpc.FiltrosUsuario;
import com.server.grpc.LoginRequest;
import com.server.grpc.LoginResponse;
import com.server.grpc.UsuarioId;
import com.server.grpc.UsuarioModificarRequest;
import com.server.grpc.UsuarioRequest;
import com.server.grpc.UsuarioResponse;
import com.server.grpc.getUsuarios;
import com.server.grpc.usuarioGrpc.usuarioImplBase;
import com.server.repositories.IUsuarioRepository;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UsuarioGrpc extends usuarioImplBase {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        try{
         Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new ServerException("Usuario o contraseña incorrecta", HttpStatus.NOT_FOUND));
            
            if (!usuario.getClave().equals(request.getClave())) {
                throw new ServerException("Usuario o contraseña incorrecta", HttpStatus.BAD_REQUEST);
            }
        
            LoginResponse response = LoginResponse.newBuilder()
                .setIdUsuario(usuario.getId())
                .setNombre(usuario.getNombre())
                .setEmail(usuario.getEmail())
                .setClave(usuario.getClave())
                .setRol(usuario.getRol())
                .setHabilitado(usuario.isHabilitado())
                .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } catch (ServerException e) {
                responseObserver.onError(Status.UNKNOWN.withDescription(e.getMensaje()).asRuntimeException());
            }
    }

    @Override
    public void crearUsuario(UsuarioRequest request, StreamObserver<CrudResponse> responseObserver) {
        try {
           Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .clave(request.getClave())
                .habilitado(request.getHabilitado())
                .rol(request.getRol())
                .build();

                usuarioRepository.save(usuario);

                CrudResponse response = CrudResponse.newBuilder()
                    .setMensaje("Usuario creado con exito")
                    .setEstado(true)
                    .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
        } catch (ServerException e) {
            CrudResponse response = CrudResponse.newBuilder()
                .setMensaje("Usuario no fue creado")
                .setEstado(false)
                .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void modificarUsuario(UsuarioModificarRequest request, StreamObserver<CrudResponse> responseObserver) {
        try {
            Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                    .orElseThrow(() -> new ServerException("Usuario no encontrado", HttpStatus.BAD_REQUEST));
            usuario.setNombre(request.getNombre());
            usuario.setEmail(request.getEmail());
            usuario.setClave(request.getClave());
            usuario.setHabilitado(request.getHabilitado());
    
            usuarioRepository.save(usuario);
    
            CrudResponse response = CrudResponse.newBuilder()
                .setMensaje("Usuario modificado con exito")
                .setEstado(true)
                .build();
    
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            CrudResponse response = CrudResponse.newBuilder()
                .setMensaje(e.getMensaje())
                .setEstado(false)
                .build();
    
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } 
    }

    @Override
    public void eliminarUsuario(UsuarioId request, StreamObserver<CrudResponse> responseObserver) {
        try {
            Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                    .orElseThrow(() -> new ServerException("Usuario no encontrado", HttpStatus.BAD_REQUEST));

    
            usuarioRepository.delete(usuario);
    
            CrudResponse response = CrudResponse.newBuilder()
                .setMensaje("Usuario eliminado con exito")
                .setEstado(true)
                .build();
    
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            CrudResponse response = CrudResponse.newBuilder()
                .setMensaje(e.getMensaje())
                .setEstado(false)
                .build();
    
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } 
    }

    @Override
    public void traerUsuarios(FiltrosUsuario request, StreamObserver<getUsuarios> responseObserver) {
        int page = 1; int size = 999;
        PageRequest pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id"));

        Page<Usuario> usuariosPage = usuarioRepository.findAll(request.getNombre(), request.getCodigo(), pageable);

        getUsuarios.Builder usuarios = getUsuarios.newBuilder();

        for(Usuario u : usuariosPage.getContent()){
            UsuarioResponse usuario = UsuarioResponse.newBuilder()
                    .setIdUsuario(u.getId())
                    .setNombre(u.getNombre())
                    .setEmail(u.getEmail())
                    .setRol(u.getRol())
                    .setHabilitado(u.isHabilitado())
                    .build();
            usuarios.addUsuarios(usuario); 
        }

        getUsuarios response = usuarios.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void detalle(UsuarioId request, StreamObserver<DetalleResponse> responseObserver) {
        try {
        Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                    .orElseThrow(() -> new ServerException("Usuario no encontrado", HttpStatus.NOT_FOUND));

            DetalleResponse response = DetalleResponse.newBuilder()
                    .setIdUsuario(usuario.getId())
                    .setNombre(usuario.getNombre())
                    .setEmail(usuario.getEmail())
                    .setRol(usuario.getRol()) 
                    .setHabilitado(usuario.isHabilitado())
                    .build();
    
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            responseObserver.onError(io.grpc.Status.fromCode(io.grpc.Status.Code.NOT_FOUND)
                    .withDescription(e.getMensaje())
                    .asRuntimeException());
        } 
    }

    @Override
    public void getUsuariosNoAsignados(Empty request, StreamObserver<getUsuarios> responseObserver) {
            List<Usuario> usuarios = usuarioRepository.findByTiendaIsNull();

            List<Usuario> usuariosFiltrados = usuarios.stream()
                .filter(u -> !"ROLE_CASA_CENTRAL".equals(u.getRol()))
                .collect(Collectors.toList());
            
            getUsuarios.Builder builder = getUsuarios.newBuilder();
    
            for (Usuario u : usuariosFiltrados) {
                UsuarioResponse usuario = UsuarioResponse.newBuilder()
                        .setIdUsuario(u.getId())
                        .setNombre(u.getNombre())
                        .setEmail(u.getEmail())
                        .setRol(u.getRol())
                        .setHabilitado(u.isHabilitado())
                        .build();
                builder.addUsuarios(usuario);
            }
    
            getUsuarios response = builder.build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
    }

}
