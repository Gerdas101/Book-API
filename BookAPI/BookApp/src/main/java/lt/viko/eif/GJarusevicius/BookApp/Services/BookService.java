package lt.viko.eif.GJarusevicius.BookApp.Services;

import lt.viko.eif.GJarusevicius.BookApp.Models.Book;
import lt.viko.eif.GJarusevicius.BookApp.Repos.BookRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private static final String API_KEY = "AIzaSyDS02M7sB-rHBRgyFi1sO9JHAbBITe1eew";
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    public List<Book> getBooksByTitle(String name) throws IOException, InterruptedException, ParseException {

        List<Book> books = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=intitle:"+name.replace(" ", "-")+"&orderBy=relevance&maxResults=40&key="+API_KEY))
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONParser parser = new JSONParser();
        JSONObject responseBody = (JSONObject) parser.parse((String) response.body());

        JSONArray booksArray = (JSONArray) responseBody.get("items");
        for (Object o : booksArray) {
            Book book1 = new Book();

            JSONObject book = (JSONObject) o;
            book1.setId((String) book.get("id"));

            JSONObject bookVolume = (JSONObject) book.get("volumeInfo");

            book1.setDescription((String) bookVolume.get("description"));
            book1.setTitle((String) bookVolume.get("title"));
            book1.setPublishedDate((String) bookVolume.get("publishedDate"));
            JSONArray authorsArray = (JSONArray) bookVolume.get("authors");
            if(authorsArray == null){
                book1.getAuthorList().add("UNKNOWN");
            }else {
                for(Object a: authorsArray){
                    book1.getAuthorList().add((String) a);
                }
            }
            book1.setPages((Long) bookVolume.get("pageCount"));
            books.add(book1);

        }
        return books;
    }

}
