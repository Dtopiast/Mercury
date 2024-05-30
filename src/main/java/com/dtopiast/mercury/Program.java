package com.dtopiast.mercury;

import com.dtopiast.mercury.model.Book;
import com.dtopiast.mercury.model.Languaje;
import com.dtopiast.mercury.service.IBookSearch;
import com.dtopiast.mercury.wrapper.SearchRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Program {

    @Autowired
    private IBookSearch search;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        int userOption;

        do {
            printMenu();
            userOption = scanner.nextInt();
            scanner.nextLine();

            switch (userOption) {
                case 1:
                    searchByNameOrAuthor();
                    break;
                case 2:
                    searchByLanguage();
                    break;
                case 3:
                    showSearchedResults();
                    break;
                case 4:
                    showTop10Books();
                    break;
                case 5:
                    searchByQuery();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Seleccione una opción válida...");
                    break;
            }
        } while (userOption != 0);
    }

    private void printMenu() {
        String menu = """
                $$\\      $$\\                                                                                       
                $$$\\    $$$ |                                                                                      
                $$$$\\  $$$$ | $$$$$$\\   $$$$$$\\   $$$$$$$\\ $$\\   $$\\  $$$$$$\\  $$\\   $$\\                       
                $$\\$$\\$$ $$ |$$  __$$\\ $$  __$$\\ $$  _____|$$ |  $$ |$$  __$$\\ $$ |  $$ |                      
                $$ \\$$$  $$ |$$$$$$$$ |$$ |  \\__|$$ /      $$ |  $$ |$$ |  \\__|$$ |  $$ |                      
                $$ |\\$  /$$ |$$   ____|$$ |      $$ |      $$ |  $$ |$$ |      $$ |  $$ |                      
                $$ | \\_/ $$ |\\$$$$$$$\\ $$ |      \\$$$$$$$\\ \\$$$$$$  |$$ |      \\$$$$$$$ |                      
                \\__|     \\__| \\_______|\\__|       \\_______| \\______/ \\__|       \\____$$ |                      
                                                                                   $$\\   $$ |                      
                                                                                   \\$$$$$$  |                      
                                                                                    \\______/                       
                                                                                                                   
                    Made with love by Dtopiast;                                                                        
                                                                                                                   
                Buscador de libros didáctico. 
                                                                                    
                    (1) Búsqueda por nombre o autor                                                                    
                    (2) Búsqueda por idioma en resultados guardados                                                                             
                    (3) Mostrar resultados buscados                                                                    
                    (4) Mostrar los 10 más descargados
                    (5) Búsqueda por query                                                            
                    
                    (0) Salir                                                                                           
                                                                                                                   
                Seleccione una opción: """;
        System.out.println(menu);
    }

    private void searchByNameOrAuthor() {
        System.out.println("Escriba el nombre del autor o libro: ");
        String userInput = scanner.nextLine();
        Optional<Book> result = search.getBookByNameOrAuthor(userInput);
        if(result.isEmpty())
        {
            System.out.println("Sin resultados");
        }
        else{
            try {
                var json = objectMapper.writeValueAsString(result);
                System.out.println(json);

            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void searchByLanguage() {
        var submenu = """
                
                es - español
                en - ingles
                fr - frances
                de - aleman
               
                Coloque el idioma a buscar:
                """;
        System.out.println(submenu);
        System.out.println("Coloque los idiomas a buscar (separados por \",\"):");
        String userInput = scanner.nextLine();
        List<Languaje> lenguajes = Arrays.stream(userInput.split(","))
                .map(Languaje::valueOf)
                .collect(Collectors.toList());
        System.out.println("Escoja la cantidad máxima de resultados: ");
        int maxResults = scanner.nextInt();
        scanner.nextLine();
        List<Book> result = search.getBooksByLanguage(lenguajes, maxResults);
        printResult(result);
    }

    private void showSearchedResults() {
        System.out.println("Hay " + search.Count() + " cuántos desea mostrar: ");
        long quantity = scanner.nextLong();
        scanner.nextLine();
        List<Book> result = search.getBooks(quantity);
        printResult(result);
    }

    private void showTop10Books() {
        List<Book> result = search.getTop10Books();
        printResult(result);
    }

    private void searchByQuery() {
        System.out.println("Nombre del libro: ");
        String title = scanner.nextLine();
        System.out.println("Escrito por (separa por \",\" ): ");
        String[] authors = scanner.nextLine().split(",");
        System.out.println("Idioma (separa por \",\" ): ");
        String[] languages = scanner.nextLine().split(",");
        System.out.println("Fecha de nacimiento del autor: ");
        int authorBirthday = scanner.nextInt();
        System.out.println("Fecha de fallecimiento del autor (en caso de seguir vivo dejar en blanco): ");
        int authorDead = scanner.nextInt();
        System.out.println("Desea ordenar los datos por título? (0 para no y 1 para sí): ");
        boolean orderByTitle = scanner.nextInt() == 1;
        System.out.println("Escoja la cantidad máxima de resultados: ");
        int maxResults = scanner.nextInt();

        var query = new SearchRequest(title, Arrays.asList(authors), Arrays.asList(languages),
                authorBirthday, authorDead, orderByTitle, maxResults);

        List<Book> result = search.queryBooks(query);
        printResult(result);
    }

    private void printResult(List<Book> result) {
        if (result.isEmpty()) {
            System.out.println("Sin resultados");
        } else {
            try {
                var json = objectMapper.writeValueAsString(result);
                System.out.println(json);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
