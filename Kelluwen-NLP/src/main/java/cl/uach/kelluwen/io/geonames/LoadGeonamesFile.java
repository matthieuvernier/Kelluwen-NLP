package cl.uach.kelluwen.io.geonames;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoadGeonamesFile {

	public static void main(String[] args) throws IOException {

		//StringBuffer fHeader = new StringBuffer("");
		BufferedWriter out
		= new BufferedWriter(new FileWriter(args[1]));
		
		Scanner sc = new Scanner(new File(args[0]));
		while (sc.hasNextLine())
		{
			String s = sc.nextLine();
			String[] elements = s.split("\t");

	/*		String geonameID = elements[0];
			String offname = elements[1];
			String ascii_name = elements[2];
			String alternateNames = elements[3];
			String latitude = elements[4];
			String longitude = elements[5];*/
			String featureclass=elements[6];
			//String featurecode=elements[7];
		//	String codeCountry=elements[8];

			// Region = ADM1, Departement = ADM2 , Country = PCLI, city=PPL
			if (featureclass.equals("R")){
				out.write(s+"\n");
			}
		}
		sc.close();

		out.close();
		System.out.println("FINISHED");
	}

}