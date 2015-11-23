package cl.uach.kelluwen.nlp.scripts.loadresources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class GenerateFinalGeonameResource {

	private static HashMap<String,String> alternativesES;
	private static HashMap<String,String> codeCountryMap;
	
	//args[0]=alternatename args1=countryinfo args2=geoname args3=output
	public static void main(String[] args) throws IOException {
		
		alternativesES = new HashMap<String,String>();
		codeCountryMap = new HashMap<String,String>();
		
		Scanner sc0 = new Scanner(new File(args[0]));
		while (sc0.hasNextLine())
		{
			String s = sc0.nextLine();
			String[] elements = s.split("\t");

			String geonameID = elements[1];
			//String alternateID = elements[0];
			//String code_iso = elements[2];
			String alternateName = elements[3];

			alternativesES.put(geonameID, alternateName);
			
		}
		sc0.close();
		
		Scanner sc1 = new Scanner(new File(args[1]));
		while (sc1.hasNextLine())
		{
			String s = sc1.nextLine();
			String[] elements = s.split("\t");

			String code = elements[0];
			String countryName = elements[4];

			codeCountryMap.put(code, countryName);
			
		}
		sc1.close();
		
		BufferedWriter out
		= new BufferedWriter(new FileWriter(args[3]));
		
		out.write("geonameID,name,ascii_name,spanish_name,latitude,longitude,featureclass,featurecode,codeCountry,countryName\n");
		
		Scanner sc2 = new Scanner(new File(args[2]));
		while (sc2.hasNextLine())
		{
			String s = sc2.nextLine();
			String[] elements = s.split("\t");

			String geonameID = elements[0];
			String offname = elements[1];
			String ascii_name = elements[2];
			String alternateNames = elements[3];
			String latitude = elements[4];
			String longitude = elements[5];
			String featureclass=elements[6];
			String featurecode=elements[7];
			String codeCountry=elements[8];

			if (alternativesES.containsKey(geonameID)){
				alternateNames=alternativesES.get(geonameID);
				System.out.println("alternative: "+ascii_name+"----"+alternativesES.get(geonameID));
			}
			else {
				alternateNames = ascii_name;
			}
			
			String countryName = codeCountryMap.get(codeCountry);
			
		
			out.write(geonameID+","+offname+","+ascii_name+","+alternateNames+","+latitude+","+longitude+","+featureclass+","+featurecode+","+codeCountry+","+countryName+"\n");
		
		}
		sc2.close();

		out.close();
		System.out.println("FINISHED");
	}
}
