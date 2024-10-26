package com.onlytrade.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.onlytrade.model.Venta;
import com.onlytrade.service.impl.PdfService;
import com.onlytrade.repository.VentaRepository;

@Controller
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping("/ventas/pdf")
    public ResponseEntity<InputStreamResource> generarPdfVentas() throws IOException {
        List<Venta> ventas = ventaRepository.findAll();

        Map<String, Object> datos = new HashMap<>();
        datos.put("ventas", ventas);

        ByteArrayInputStream pdfStream = pdfService.generarPdf("template_pdf", datos);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=ventas.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdfStream));
    }
}

