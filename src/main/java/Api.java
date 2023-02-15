import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Api {

    public static void main (String[] args) throws IOException, InterruptedException {
       String sum;
        Scanner symbol = new Scanner(System.in);
        System.out.println("Enter symbol: ");
        sum = symbol.nextLine();

        var url ="https://newsapi.org/v2/everything?q="+sum+"&from=2023-01-15&sortBy=publishedAt&apiKey=cfc3fe2a84bc415b8e2520e1425c5607";

        //HttpRequest
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        var client = HttpClient.newBuilder().build();

        var response= client.send(request, HttpResponse.BodyHandlers.ofString());


            System.out.println(response.statusCode());
          System.out.println(response.body());

    }
}
