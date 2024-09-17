package com.server.servicesGrpc;

import java.util.List;

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
import com.server.grpc.CrudProductoResponse;
import com.server.grpc.DetalleProductoRequest;
import com.server.grpc.DetalleProductoResponse;
import com.server.grpc.FiltrosProducto;
import com.server.grpc.ProductoId;
import com.server.grpc.ProductoModificarRequest;
import com.server.grpc.ProductoRequest;
import com.server.grpc.ProductoResponse;
import com.server.grpc.ProductoResponse2;
import com.server.grpc.StockResponse;
import com.server.grpc.TiendaId;
import com.server.grpc.TiendaResponse;
import com.server.grpc.getProductos;
import com.server.grpc.getProductosNoAsociados;
import com.server.grpc.getProductosAsociados;
import com.server.grpc.productoGrpc.productoImplBase;
import com.server.repositories.IProductoRepository;
import com.server.repositories.ITiendaRepository;
import com.server.repositories.IUsuarioRepository;
import com.server.util.Utility;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductoGrpc extends productoImplBase {

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private ITiendaRepository tiendaRepository;

    @Override
    public void crearProducto(ProductoRequest request, StreamObserver<CrudProductoResponse> responseObserver) {
        try {
            Producto producto = Producto.builder()
                    .codigo(Utility.generarCaracteresAlAzar())
                    .nombre(request.getNombre())
                    .talle(request.getTalle())
                    .color(request.getColor())
                    .imagen(request.getImagen())
                    .habilitado(true)
                    .build();

            productoRepository.save(producto);

            CrudProductoResponse response = CrudProductoResponse.newBuilder()
                    .setEstado(true)
                    .setMensaje("Producto creado con éxito")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            CrudProductoResponse response = CrudProductoResponse.newBuilder()
                    .setEstado(false)
                    .setMensaje("No se pudo crear el producto")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void modificarProducto(ProductoModificarRequest request, StreamObserver<CrudProductoResponse> responseObserver) {
        try {
            Producto producto = productoRepository.findById(request.getIdProducto())
                    .orElseThrow(() -> new ServerException("Producto no encontrado", HttpStatus.BAD_REQUEST));
            producto.setNombre(request.getNombre());
            producto.setColor(request.getColor());
            producto.setTalle(request.getTalle());
            producto.setImagen(request.getImagen());
            producto.setHabilitado(request.getHabilitado());

            productoRepository.save(producto);

            CrudProductoResponse response = CrudProductoResponse.newBuilder()
                    .setEstado(true)
                    .setMensaje("Producto modificado con éxito")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            CrudProductoResponse response = CrudProductoResponse.newBuilder()
                    .setEstado(false)
                    .setMensaje(e.getMensaje())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void eliminarProducto(ProductoId request, StreamObserver<CrudProductoResponse> responseObserver) {
        try {
            Producto producto = productoRepository.findById(request.getIdProducto())
                    .orElseThrow(() -> new ServerException("Producto no encontrado", HttpStatus.BAD_REQUEST));

            productoRepository.delete(producto);

            CrudProductoResponse response = CrudProductoResponse.newBuilder()
                    .setEstado(true)
                    .setMensaje("Producto eliminado con éxito")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            CrudProductoResponse response = CrudProductoResponse.newBuilder()
                    .setEstado(false)
                    .setMensaje(e.getMensaje())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Transactional
    @Override
    public void traerProductos(FiltrosProducto request, StreamObserver<getProductos> responseObserver) {
        try{
            Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                    .orElseThrow(() -> new ServerException("Usuario no encontrado", HttpStatus.BAD_REQUEST));

            int page = 1; int size = 9999;
            PageRequest pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id"));
            Page<Producto> productosPage;

            if (usuario.getRol().equalsIgnoreCase("ROLE_CASA_CENTRAL")) {
                productosPage = productoRepository.findAll(request.getNombre(), request.getCodigo(), request.getTalle(), request.getColor(), pageable);
            } else if (usuario.getRol().equalsIgnoreCase("ROLE_TIENDA")) {
                if(usuario.getTienda() == null){
                        throw new ServerException("EL usuario no esta asignado a una tienda", HttpStatus.BAD_REQUEST);
                }
                productosPage = productoRepository.findByTienda(usuario.getTienda().getId(), request.getNombre(), request.getCodigo(), request.getTalle(), request.getColor(), pageable);
            } else {
                throw new ServerException("Rol de usuario no permitido", HttpStatus.FORBIDDEN);
            }

            getProductos.Builder productos = getProductos.newBuilder();

            for (Producto p : productosPage.getContent()) {
                ProductoResponse.Builder producto = ProductoResponse.newBuilder()
                        .setNombre(p.getNombre())
                        .setCodigo(p.getCodigo())
                        .setTalle(p.getTalle())
                        .setColor(p.getColor());

                if (!p.getStock().isEmpty()) {
                    Stock stock = p.getStock().get(0);
                    TiendaResponse tiendaResponse = TiendaResponse.newBuilder()
                            .setCodigo(stock.getTienda().getCodigo())
                            .setHabilitado(stock.getTienda().isHabilitado())
                            .build();
                    producto.setTienda(tiendaResponse);
                }

                productos.addProductos(producto.build());
            }

            getProductos response = productos.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            }  catch (ServerException e) {
                responseObserver.onError(io.grpc.Status.fromCode(io.grpc.Status.Code.UNKNOWN)
                        .withDescription(e.getMensaje())
                        .asRuntimeException());
            }
    }

    @Transactional
    @Override
    public void detalle(DetalleProductoRequest request, StreamObserver<DetalleProductoResponse> responseObserver) {
        try {
            Producto producto = productoRepository.findByCodigo(request.getCodigo())
                    .orElseThrow(() -> new ServerException("Producto no encontrado", HttpStatus.BAD_REQUEST));

            DetalleProductoResponse.Builder responseBuilder = DetalleProductoResponse.newBuilder()
                    .setNombre(producto.getNombre())
                    .setImagen(producto.getImagen());

            for (Stock stock : producto.getStock()) {
                StockResponse stockResponse = StockResponse.newBuilder()
                        .setCantidad(stock.getCantidad())
                        .setTienda(TiendaResponse.newBuilder()
                                .setCodigo(stock.getTienda().getCodigo())
                                .setHabilitado(stock.getTienda().isHabilitado())
                                .build())
                        .build();
                responseBuilder.addStock(stockResponse);
            }

            DetalleProductoResponse response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ServerException e) {
            responseObserver.onError(io.grpc.Status.fromCode(io.grpc.Status.Code.NOT_FOUND)
                    .withDescription(e.getMensaje())
                    .asRuntimeException());
        }
    }

    @Transactional
    @Override
    public void getProductosNoAsociados(TiendaId request, StreamObserver<getProductosNoAsociados> responseObserver) {
            Tienda tienda = tiendaRepository.findById(request.getIdTienda())
                    .orElseThrow(() -> new ServerException("Tienda no encontrada", HttpStatus.BAD_REQUEST));

            List<Producto> productos = productoRepository.findProductosNoAsociados(tienda.getId());

            getProductosNoAsociados.Builder productosB = getProductosNoAsociados.newBuilder();

            for (Producto p : productos) {
                ProductoResponse2 producto = ProductoResponse2.newBuilder()
                        .setNombre(p.getNombre())
                        .setCodigo(p.getCodigo())
                        .setTalle(p.getTalle())
                        .setColor(p.getColor())
                        .build();

                productosB.addProductos(producto);
            }

            getProductosNoAsociados response = productosB.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
    }

    @Override
    public void getProductosAsociados(TiendaId request,
            StreamObserver<getProductosAsociados> responseObserver) {
                Tienda tienda = tiendaRepository.findById(request.getIdTienda())
                .orElseThrow(() -> new ServerException("Tienda no encontrada", HttpStatus.BAD_REQUEST));

        List<Producto> productos = productoRepository.findProductosAsociados(tienda.getId());

        getProductosAsociados.Builder productosB = getProductosAsociados.newBuilder();

        for (Producto p : productos) {
            ProductoResponse2 producto = ProductoResponse2.newBuilder()
                    .setNombre(p.getNombre())
                    .setCodigo(p.getCodigo())
                    .setTalle(p.getTalle())
                    .setColor(p.getColor())
                    .build();

            productosB.addProductos(producto);
        }

        getProductosAsociados response = productosB.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}