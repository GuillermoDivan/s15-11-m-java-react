package com.s1511.ticketcine.infrastructure.controllers;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.s1511.ticketcine.domain.repository.CinemaRepository;
import com.s1511.ticketcine.domain.repository.ScreenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Scraping {

//TODO: TRAER DATOS CON JSOUP Y GUARDAR EN LA BD. 
    private final CinemaRepository cinemaRepository;
    private final ScreenRepository screenRepository;

    public void fetchAndStoreData () throws IOException{
        String url = "https://www.sinca.gob.ar/DatosBasicosEntidades.aspx?Id=291";
        Document doc = Jsoup.connect(url).get();

        Elements table = doc.select(".google-visualization-table-table"); // Cambia el índice según la tabla que necesites
        
        System.out.println("Tamaño:" + table.html());
       
        Elements rows = table.select("thgoogle-visualization-table-tr-head");

        /* for (Element row : rows) {
            System.out.print(row.select("th.google-visualization-table-th gradient unsorted").text());
           
            System.out.println();
        } */

    }
    
}
