package com.server.soap.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.server.catalogo.AsignarProductoRequest;
import com.server.catalogo.AsignarProductoResponse;
import com.server.catalogo.CrearCatalogoRequest;
import com.server.catalogo.CrearCatalogoResponse;
import com.server.catalogo.DesasignarProductoRequest;
import com.server.catalogo.DesasignarProductoResponse;
import com.server.catalogo.DetalleCatalogoRequest;
import com.server.catalogo.DetalleCatalogoResponse;
import com.server.catalogo.EditarCatalogoRequest;
import com.server.catalogo.EditarCatalogoResponse;
import com.server.catalogo.ExportarCatalogoAPDFRequest;
import com.server.catalogo.ExportarCatalogoAPDFResponse;
import com.server.catalogo.TraerCatalogosRequest;
import com.server.catalogo.TraerCatalogosResponse;
import com.server.catalogo.TraerProductosAsignadosRequest;
import com.server.catalogo.TraerProductosAsignadosResponse;
import com.server.catalogo.TraerProductosNoAsignadosRequest;
import com.server.catalogo.TraerProductosNoAsignadosResponse;
import com.server.entities.Catalogo;
import com.server.entities.Producto;
import com.server.entities.Usuario;
import com.server.exceptions.ServerException;
import com.server.repositories.ICatalogoRepository;
import com.server.repositories.IProductoRepository;
import com.server.repositories.IUsuarioRepository;
import com.server.util.CatalogoPDF;

@Service
public class SPcatalogoService {

    @Autowired
    private ICatalogoRepository catalogoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IProductoRepository productoRepository;

    public CrearCatalogoResponse crearCatalogo(CrearCatalogoRequest request) {
        Catalogo catalogo = new Catalogo();
        catalogo.setTitulo(request.getTitulo());
        Usuario usuario = usuarioRepository.findById(request.getIdUsuario()).orElseThrow(() -> new ServerException("Tienda no encontrada para ese usuario", HttpStatus.BAD_REQUEST));
        catalogo.setTienda(usuario.getTienda());

        catalogoRepository.save(catalogo);

        CrearCatalogoResponse response = new CrearCatalogoResponse();
        response.setMensaje("Catalogo creado!");
        response.setIdCatalogo(catalogo.getId());

        return response;
    }

    public EditarCatalogoResponse editarCatalogo(EditarCatalogoRequest request) {
        Catalogo catalogo = catalogoRepository.findById(request.getIdCatalogo()).orElseThrow(() -> new ServerException("Catalogo no encontrado", HttpStatus.BAD_REQUEST));
        catalogo.setTitulo(request.getTitulo());
        catalogoRepository.save(catalogo);

        EditarCatalogoResponse response = new EditarCatalogoResponse();
        response.setMensaje("Catalogo editado!");

        return response;
    }

    public TraerProductosAsignadosResponse traerProductosAsignados(TraerProductosAsignadosRequest request) {
        Catalogo catalogo = catalogoRepository.findById(request.getIdCatalogo()).orElseThrow(() -> new ServerException("Catalogo no encontrado", HttpStatus.BAD_REQUEST));

        TraerProductosAsignadosResponse response = new TraerProductosAsignadosResponse();
        List<Producto> productos = catalogo.getProductos();

        for (Producto producto : productos) {
            TraerProductosAsignadosResponse.Producto pResponse = new TraerProductosAsignadosResponse.Producto();
            pResponse.setIdProducto(producto.getId());
            pResponse.setNombre(producto.getNombre());
            pResponse.setTalle(producto.getTalle());
            pResponse.setColor(producto.getColor());
            pResponse.setImagen(producto.getImagen());
            response.getProducto().add(pResponse);
        }

        return response;
    }

    public TraerProductosNoAsignadosResponse traerProductosNoAsignados(TraerProductosNoAsignadosRequest request) {
        List<Producto> productosNoAsignados = productoRepository.findProductosNoAsignadosACatalogo(request.getIdCatalogo());

        TraerProductosNoAsignadosResponse response = new TraerProductosNoAsignadosResponse();
        for (Producto producto : productosNoAsignados) {
            TraerProductosNoAsignadosResponse.Producto pResponse = new TraerProductosNoAsignadosResponse.Producto();
            pResponse.setIdProducto(producto.getId());
            pResponse.setNombre(producto.getNombre());
            pResponse.setTalle(producto.getTalle());
            pResponse.setColor(producto.getColor());
            pResponse.setImagen(producto.getImagen());
            response.getProducto().add(pResponse);
        }

        return response;
    }

    public AsignarProductoResponse asignarProducto(AsignarProductoRequest request) {
        Catalogo catalogo = catalogoRepository.findById(request.getIdCatalogo()).orElseThrow(() -> new ServerException("Catalogo no encontrado", HttpStatus.BAD_REQUEST));
        Producto producto = productoRepository.findById(request.getIdProducto()).orElseThrow(() -> new ServerException("Producto no encontrado", HttpStatus.BAD_REQUEST));

        if (!catalogo.getProductos().contains(producto)) {
            catalogo.getProductos().add(producto);
        }
        catalogoRepository.save(catalogo);

        AsignarProductoResponse response = new AsignarProductoResponse();
        response.setMensaje("Producto asignado!");

        return response;
    }

    public DesasignarProductoResponse desasignarProducto(DesasignarProductoRequest request) {
        Catalogo catalogo = catalogoRepository.findById(request.getIdCatalogo()).orElseThrow(() -> new ServerException("Catalogo no encontrado", HttpStatus.BAD_REQUEST));
        Producto producto = productoRepository.findById(request.getIdProducto()).orElseThrow(() -> new ServerException("Producto no encontrado", HttpStatus.BAD_REQUEST));

        if (catalogo.getProductos().contains(producto)) {
            catalogo.getProductos().remove(producto);
        }
        catalogoRepository.save(catalogo);

        DesasignarProductoResponse response = new DesasignarProductoResponse();
        response.setMensaje("Producto desasignado!");

        return response;
    }

    public TraerCatalogosResponse traerCatalogos(TraerCatalogosRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getIdUsuario()).orElseThrow(() -> new ServerException("Usuario no encontrado", HttpStatus.BAD_REQUEST));

        List<Catalogo> catalogos = catalogoRepository.findByTienda(usuario.getTienda());

        TraerCatalogosResponse response = new TraerCatalogosResponse();
        for (Catalogo catalogo : catalogos) {
            TraerCatalogosResponse.Catalogo cResponse = new TraerCatalogosResponse.Catalogo();
            cResponse.setIdCatalogo(catalogo.getId());
            cResponse.setTitulo(catalogo.getTitulo());
            response.getCatalogo().add(cResponse);
        }

        return response;
    }

    public DetalleCatalogoResponse detalleCatalogo(DetalleCatalogoRequest request) {
        Catalogo catalogo = catalogoRepository.findById(request.getIdCatalogo()).orElseThrow(() -> new ServerException("Catalogo no encontrado", HttpStatus.BAD_REQUEST));

        DetalleCatalogoResponse response = new DetalleCatalogoResponse();
        response.setTitulo(catalogo.getTitulo());

        return response;
    }

    public ExportarCatalogoAPDFResponse exportarCatalogoAPDF(ExportarCatalogoAPDFRequest request, HttpServletResponse responsePDF) throws DocumentException, IOException {
        
        responsePDF.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateTime = dateFormatter.format(new Date());

        String harderKey = "Content-Disposition";
        String harderValue = "attachment; filename=catalogo_" + currentDateTime + ".pdf";

        responsePDF.setHeader(harderKey, harderValue);

        Catalogo catalogo = catalogoRepository.findById(request.getIdCatalogo()).orElseThrow(() -> new ServerException("Catalogo no encontrado", HttpStatus.BAD_REQUEST));
        List<Producto> productosCatalogo = catalogo.getProductos();

        CatalogoPDF pdf = new CatalogoPDF(productosCatalogo);
        pdf.export(responsePDF);
        
        ExportarCatalogoAPDFResponse response = new ExportarCatalogoAPDFResponse();
        response.setMensaje("Catalogo exportado a PDF!");

        return response;
    }

}
