import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// https://www.javacodeexamples.com/jsoup-tutorial-with-examples/1628
		
	
		List<String> values = new ArrayList<String>() ;
		System.out.println("Start") ;
	    
		String year = "2022" ;
		String url = "https://www.global-rates.com/fr/taux-de-interets/libor/dollar-americain/2022.aspx" ;
		
		
        Document doc =Jsoup.connect(url).get();
		Elements rows = (Elements) doc.select(".tabledata1,.tabledata2");
		
		for(org.jsoup.nodes.Element row : rows){
            Elements tds = row.getElementsByTag("td");
            if (!(tds.get(0)).text().startsWith("Taux LIBOR USD"))
            {
            System.out.println("Mois : "+tds.get(0).text());
            System.out.println("Value: "+ tds.get(1).text().replace("%","").replace("-","NA"));
            
            //String monthString = tds.get(0).text() ; 
          
           }
		}
		
		
		
     // The response object is useful in retrieving useful information about the response received from the Jsoup connection like
     // response body, cookies, etc. The execute method of the Connection executes the request and returns a response as given below.
		
		
	Response response = Jsoup.connect("http://www.google.com") .timeout(60000) .execute();
	// To get the response cookies, use the cookies method
	Map<String, String> responseCookies = response.cookies();
	System.out.println("Response cookies received: " + responseCookies.size());
	System.out.println("Keys: " + responseCookies.keySet());
	System.out.println("Values: " + responseCookies.values());
	
            
	
          
         
            
            
       

	}
		
	}


