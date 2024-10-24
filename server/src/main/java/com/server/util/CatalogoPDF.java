package com.server.util;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.server.entities.Producto;

public class CatalogoPDF {
    
    private List<Producto> productosCatalogo;

    public CatalogoPDF(List<Producto> productosCatalogo) {
        this.productosCatalogo = productosCatalogo;
    }

     private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Nombre", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Talle", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Color", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Imagen (URL)", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Producto producto : productosCatalogo) {
            table.addCell(producto.getNombre());
            table.addCell(producto.getTalle());
            table.addCell(producto.getColor());

            if (producto.getImagen() != null && !producto.getImagen().isEmpty()) {
                table.addCell(producto.getImagen());
            } else {
                table.addCell("Sin imagen");
            }
        }
    }

     public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        fontTitle.setColor(Color.BLACK);

        Paragraph title = new Paragraph("Catálogo de Productos", fontTitle);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);
        
        document.add(Chunk.NEWLINE);
        document.add(new Paragraph("Lista de productos:"));

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setSpacingBefore(10);
        table.setWidths(new float[]{3.0f, 2.0f, 2.0f, 3.0f});

        writeTableHeader(table);

        writeTableData(table);

        document.add(table);
        document.close();
    }
    
}
