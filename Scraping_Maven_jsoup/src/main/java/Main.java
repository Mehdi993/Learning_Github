import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws IOException {
		
	//	https://www.javacodeexamples.com/jsoup-tutorial-with-examples/1628
		
		
		// take a look at the maven file in talend to undrestand it better 
		System.out.println("Start");
		
	
		 List<String> values = new ArrayList<String>() ;	    
			String year = "2022" ;
			String url = "https://www.global-rates.com/fr/taux-de-interets/libor/dollar-americain/2022.aspx" ;
			

	        Document doc = Jsoup.connect(url).get();
			Elements rows = (Elements) doc.select(".tabledata1,.tabledata2");
			
			for(org.jsoup.nodes.Element row : rows){
	            Elements tds = row.getElementsByTag("td");
	            
	            if (!(tds.get(0)).text().startsWith("Taux LIBOR USD"))
	            {
	            System.out.println("Mois : "+tds.get(0).text());
	            System.out.println("Value: "+ tds.get(1).text().replace("%","").replace("-","NA"));
	          
	            String monthString = tds.get(0).text() ; 
	            
	          
	          
	           }
	            
	       
			}
		

		
	
		System.out.println("End");
	

	}

}
