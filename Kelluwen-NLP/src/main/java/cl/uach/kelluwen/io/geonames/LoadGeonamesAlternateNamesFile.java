package cl.uach.kelluwen.io.geonames;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Objective : Generate a simpler file of city/country alternative names (for spanish)
 * @author mvernier
 *
 */
public class LoadGeonamesAlternateNamesFile {

	private static String CODE_SPANISH="es";

	public static void main(String[] args) throws IOException {

		StringBuffer fHeader = new StringBuffer("");
		Scanner sc = new Scanner(new File(args[0]));
		while (sc.hasNextLine())
		{
			String s = sc.nextLine();
			String[] elements = s.split("\t");

			String geonameID = elements[0];
			String alternateID = elements[1];
			String code_iso = elements[2];
			String alternateName = elements[3];

			if (code_iso.equals(CODE_SPANISH)){
				fHeader.append(geonameID+"\t"+alternateID+"\t"+code_iso+"\t"+alternateName+"\n");
			}
		}
		sc.close();

		BufferedWriter out
		= new BufferedWriter(new FileWriter(args[1]));
		out.write(fHeader.toString());
		out.close();
		System.out.println("FINISHED");
	}

}