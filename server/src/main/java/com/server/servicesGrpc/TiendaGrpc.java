package com.server.servicesGrpc;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import com.server.entities.Producto;
import com.server.entities.Stock;
import com.server.entities.Tienda;
import com.server.entities.Usuario;
import com.server.exceptions.ServerException;
import com.server.grpc.CrudTiendaResponse;
import com.server.grpc.DetalleTiendaRequest;
import com.server.grpc.DetalleTiendaResponse;
import com.server.grpc.FiltrosTienda;
import com.server.grpc.ManejarProducto;
import com.server.grpc.ManejarUsuario;
import com.server.grpc.ModificarStockRequest;
import com.server.grpc.TiendaId;
import com.server.grpc.TiendaModificarRequest;
import com.server.grpc.TiendaRequest;
import com.server.grpc.TiendaResponse;
import com.server.grpc.getTiendas;
import com.server.grpc.tiendaGrpc.tiendaImplBase;
import com.server.repositories.IProductoRepository;
import com.server.repositories.IStockRepository;
import com.server.repositories.ITiendaRepository;
import com.server.repositories.IUsuarioRepository;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class TiendaGrpc extends tiendaImplBase {

    @Autowired
    private ITiendaRepository tiendaRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IStockRepository stockRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public void crearTienda(TiendaRequest request, StreamObserver<CrudTiendaResponse> responseObserver) {
        try {
            Tienda tienda = Tienda.builder()
                    .codigo(request.getCodigo())
                    .direccion(request.getDireccion())
                    .provincia(request.getProvincia())
                    .ciudad(request.getCiudad())
                    .habilitado(true)
                    .build();

            tiendaRepository.save(tienda);

            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje("Tienda creada con éxito")
                    .setEstado(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje("Error al crear tienda")
                    .setEstado(false)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void modificarTienda(TiendaModificarRequest request, StreamObserver<CrudTiendaResponse> responseObserver) {
        try {
            Tienda tienda = tiendaRepository.findById(request.getIdTienda())
                    .orElseThrow(() -> new ServerException("Tienda no encontrada", HttpStatus.BAD_REQUEST));

            if (tiendaRepository.findByCodigo(request.getCodigo()) != null) {
                throw new ServerException("Ya existe una tienda con ese código", HttpStatus.BAD_REQUEST);
            }

            tienda.setCodigo(request.getCodigo());
            tienda.setDireccion(request.getDireccion());
            tienda.setCiudad(request.getCiudad());
            tienda.setProvincia(request.getProvincia());
            tienda.setHabilitado(request.getHabilitado());

            tiendaRepository.save(tienda);

            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje("Tienda modificada con éxito")
                    .setEstado(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje(e.getMensaje())
                    .setEstado(false)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void eliminarTienda(TiendaId request, StreamObserver<CrudTiendaResponse> responseObserver) {
        try {
            Tienda tienda = tiendaRepository.findById(request.getIdTienda())
                    .orElseThrow(() -> new ServerException("Tienda no encontrada", HttpStatus.NOT_FOUND));

            tiendaRepository.delete(tienda);

            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje("Tienda eliminada con éxito")
                    .setEstado(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje(e.getMensaje())
                    .setEstado(false)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Transactional
    @Override
    public void traerTiendas(FiltrosTienda request, StreamObserver<getTiendas> responseObserver) {
            int page = 1; int size = 9999;
            PageRequest pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id"));

            Page<Tienda> tiendasPage = tiendaRepository.findAll(request.getCodigo(), request.getHabilitado(), pageable);

            getTiendas.Builder tiendas = getTiendas.newBuilder();
            for (Tienda t : tiendasPage) {
                TiendaResponse tiendaResponse = TiendaResponse.newBuilder()
                        .setCodigo(t.getCodigo())
                        .setHabilitado(t.isHabilitado())
                        .build();
                tiendas.addTiendas(tiendaResponse);
            }

            getTiendas response = tiendas.build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
    }

    @Override
    public void detalle(DetalleTiendaRequest request, StreamObserver<DetalleTiendaResponse> responseObserver) {
        try {
            Tienda tienda = tiendaRepository.findByCodigo(request.getCodigo())
                    .orElseThrow(() -> new ServerException("Tienda no encontrada", HttpStatus.NOT_FOUND));

            DetalleTiendaResponse response = DetalleTiendaResponse.newBuilder()
                    .setIdTienda(tienda.getId())
                    .setCodigo(tienda.getCodigo())
                    .setDireccion(tienda.getDireccion())
                    .setCiudad(tienda.getCiudad())
                    .setProvincia(tienda.getProvincia())
                    .setHabilitado(tienda.isHabilitado())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            responseObserver.onError(io.grpc.Status.fromCode(io.grpc.Status.Code.NOT_FOUND)
                    .withDescription(e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void asignarProducto(ManejarProducto request, StreamObserver<CrudTiendaResponse> responseObserver) {
        try {
            Tienda tienda = tiendaRepository.findById(request.getIdTienda())
                    .orElseThrow(() -> new ServerException("Tienda no encontrada", HttpStatus.NOT_FOUND));

            Producto producto = productoRepository.findById(request.getIdProducto())
                    .orElseThrow(() -> new ServerException("Producto no encontrado", HttpStatus.NOT_FOUND));

            Stock stock = stockRepository.findByTiendaAndProducto(tienda, producto);
            if (stock != null) {
                throw new ServerException("El producto ya está asignado a esta tienda", HttpStatus.BAD_REQUEST);
            }

            stock = Stock.builder()
                    .producto(producto)
                    .tienda(tienda)
                    .cantidad(0)
                    .build();

            stockRepository.save(stock);

            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje("Producto asignado con éxito")
                    .setEstado(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje(e.getMensaje())
                    .setEstado(false)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void desasignarProducto(ManejarProducto request, StreamObserver<CrudTiendaResponse> responseObserver) {
        try {
            Tienda tienda = tiendaRepository.findById(request.getIdTienda())
                    .orElseThrow(() -> new ServerException("Tienda no encontrada", HttpStatus.NOT_FOUND));

            Producto producto = productoRepository.findById(request.getIdProducto())
                    .orElseThrow(() -> new ServerException("Producto no encontrado", HttpStatus.NOT_FOUND));

            Stock stock = stockRepository.findByTiendaAndProducto(tienda, producto);
            if (stock == null) {
                throw new ServerException("El producto no está asignado a esta tienda", HttpStatus.BAD_REQUEST);
            }

            stockRepository.delete(stock);

            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje("Producto desasignado con éxito")
                    .setEstado(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje(e.getMensaje())
                    .setEstado(false)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void asignarUsuario(ManejarUsuario request, StreamObserver<CrudTiendaResponse> responseObserver) {
        try {
            Tienda tienda = tiendaRepository.findById(request.getIdTienda())
                    .orElseThrow(() -> new ServerException("Tienda no encontrada", HttpStatus.NOT_FOUND));

            Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                    .orElseThrow(() -> new ServerException("Usuario no encontrado", HttpStatus.NOT_FOUND));

            if (usuario.getTienda() != null) {
                throw new ServerException("Usuario ya está asignado a una tienda", HttpStatus.BAD_REQUEST);
            }

            usuario.setTienda(tienda);
            usuarioRepository.save(usuario);

            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje("Usuario asignado con éxito")
                    .setEstado(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje(e.getMensaje())
                    .setEstado(false)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void desasignarUsuario(ManejarUsuario request, StreamObserver<CrudTiendaResponse> responseObserver) {
        try {
            Tienda tienda = tiendaRepository.findById(request.getIdTienda())
                    .orElseThrow(() -> new ServerException("Tienda no encontrada", HttpStatus.NOT_FOUND));

            Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                    .orElseThrow(() -> new ServerException("Usuario no encontrado", HttpStatus.NOT_FOUND));

            if (usuario.getTienda() == null || !usuario.getTienda().equals(tienda)) {
                throw new ServerException("Usuario no está asignado a esta tienda", HttpStatus.BAD_REQUEST);
            }

            usuario.setTienda(null);
            usuarioRepository.save(usuario);

            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje("Usuario desasignado con éxito")
                    .setEstado(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje(e.getMensaje())
                    .setEstado(false)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void modificarStock(ModificarStockRequest request, StreamObserver<CrudTiendaResponse> responseObserver) {
        try {
            Tienda tienda = tiendaRepository.findById(request.getIdTienda())
                    .orElseThrow(() -> new ServerException("Tienda no encontrada", HttpStatus.NOT_FOUND));

            Producto producto = productoRepository.findById(request.getIdProducto())
                    .orElseThrow(() -> new ServerException("Producto no encontrado", HttpStatus.NOT_FOUND));

            Stock stock = stockRepository.findByTiendaAndProducto(tienda, producto);
            if (stock == null) {
                throw new ServerException("El producto no está asignado a esta tienda", HttpStatus.BAD_REQUEST);
            }

            stock.setCantidad(request.getCantidad());
            stockRepository.save(stock);

            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje("Stock modificado con éxito")
                    .setEstado(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            CrudTiendaResponse response = CrudTiendaResponse.newBuilder()
                    .setMensaje(e.getMensaje())
                    .setEstado(false)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
