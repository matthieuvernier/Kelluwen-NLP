package cl.uach.kelluwen.io.geonames;

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
		
		out.write("geonameid,name,asciiname,spanishname,latitude,longitude,"
				+ "feature_class,feature_code,country_code,country_name,cc2,admin1_code,admin2_code,"
				+ "admin3_code, admin4_code, population,elevation,dem,timezone\n");
		
		Scanner sc2 = new Scanner(new File(args[2]));
		while (sc2.hasNextLine())
		{
			String s = sc2.nextLine();
			String[] elements = s.split("\t");

			String geonameid = elements[0];
			String name = elements[1];
			String asciiname = elements[2];
			String spanishname = elements[3];
			String latitude = elements[4];
			String longitude = elements[5];
			String feature_class=elements[6];
			String feature_code=elements[7];
			String country_code=elements[8];
			String cc2=elements[9];
			String admin1_code=elements[10];
			String admin2_code=elements[11];
			String admin3_code=elements[12];
			String admin4_code=elements[13];
			String population=elements[14];
			String elevation=elements[15];
			String dem=elements[16];
			String timezone=elements[17];
			
			if (alternativesES.containsKey(geonameid)){
				spanishname=alternativesES.get(geonameid);
				//System.out.println("alternative: "+ascii_name+"----"+alternativesES.get(geonameID));
			}
			else {
				spanishname = asciiname;
			}
			
			String country_name = codeCountryMap.get(country_code);
			
		
			out.write(geonameid+","+name+","+asciiname+","+spanishname+","+latitude+","+longitude+","
			+feature_class+","+feature_code+","+country_code+","+country_name+","
			+cc2+","+admin1_code+","+admin2_code+","+admin3_code+","+admin4_code
			+","+population+","+elevation+","+dem+","+timezone+"\n");
		
		}
		sc2.close();

		out.close();
		System.out.println("FINISHED");
	}
}
