package com.s1511.ticketcine;

import java.io.IOException;

import com.s1511.ticketcine.infrastructure.controllers.Scraping;



//TODO: CAMBIAR DATACINEMA SQL POR SCRAPING JSOUP
public class ScrappingTest {

    public static void main(String[] args) throws IOException {
        Scraping scraping = new Scraping(null, null);
        scraping.fetchAndStoreData();
    }
    
}