package com.library;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LibraryManagementApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    String baseUrl="http://localhost:";

    @DisplayName("Test 1 library is available to add books")
    @Test
    public void getLibrariesTest() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL(baseUrl+ port + "/getlibraries").toString(), String.class);
        assertTrue(response.getBody().contains("libraryId"));

    }
    
    @DisplayName("get book web service is up and running")
    @Test
    public void getBookService() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL(baseUrl+ port + "/getBooks").toString(), String.class);
        assertEquals("200 OK", response.getStatusCode().toString());
    }
    
    
    @DisplayName("add a new book")
    @Test
    public void addAnewBook() throws Exception {
        ResponseEntity<String> response = restTemplate. getForEntity(
			new URL(baseUrl + port + "/addOrUpdateBooks?bookid=0&&bookname=de&&libid=1").toString(), String.class);
        assertEquals("{\"message\":\"success\"}", response.getBody());
    }
    
    @Sql(scripts = "./scripts/data.sql")
    @DisplayName("update a book")
    @Test
    public void updateABook() throws Exception {
        ResponseEntity<String> response = restTemplate. getForEntity(
			new URL(baseUrl+ port + "/addOrUpdateBooks?bookid=123&&bookname=deva2&&libid=0").toString(), String.class);
        assertEquals("{\"message\":\"success\"}", response.getBody());
    }

}
