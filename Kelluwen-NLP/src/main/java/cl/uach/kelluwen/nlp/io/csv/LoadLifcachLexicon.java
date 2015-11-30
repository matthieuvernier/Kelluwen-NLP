package cl.uach.kelluwen.nlp.io.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LoadLifcachLexicon {

	private static int NUMBER_OF_TOKENS=451339902;
	private static HashMap<String,LifcachLexiconEntry> lexiconMap;

	public static void main(String[] args) throws Exception {

		lexiconMap = new HashMap<String,LifcachLexiconEntry>();
		int duplicata = 0;
		int NG=0;
		int NP=0;
		int SG=0;
		StringBuffer fHeader = new StringBuffer("");

		try {
			System.out.println(args[0]);
			Scanner sc = new Scanner(new File(args[0]));

			//We don't use the 2 first lines of the lifcach lexicon
			sc.nextLine();
			sc.nextLine();
			//Variables to store metadatos
			int rank=0;
			while (sc.hasNextLine())
			{
				rank=rank+1;
				String s = sc.nextLine();
				StringTokenizer stTok = new StringTokenizer(s,",");

				String lemma = stTok.nextToken();
				String pos = stTok.nextToken();
				String nb_instances = stTok.nextToken();

				Float freq = new Float(nb_instances)/new Float(NUMBER_OF_TOKENS);

				LifcachLexiconEntry entry = new LifcachLexiconEntry();
				entry.rank=rank;
				entry.lemma=lemma;
				entry.pos=pos;
				entry.freq=freq;

				if (lexiconMap.containsKey(lemma)){
					System.out.println("duplicata: "+lemma);
					duplicata=duplicata+1;
				}
				else {
					lexiconMap.put(lemma, entry);
				}
				if (pos.equals("NP")){
					NP=NP+1;
				}
				if (pos.equals("NG")){
					NG=NG+1;
				}
				if (pos.equals("SG")){
					SG=SG+1;
				}
				
				DecimalFormat df = new DecimalFormat("#.####################");
				fHeader.append(rank+";"+lemma+";"+pos+";"+df.format(freq).replace(".", ",")+"\n");

			}
			sc.close();
			System.out.println("number of duplicata:"+duplicata);
			System.out.println("NP:"+NP);
			System.out.println("NG:"+NG);
			System.out.println("SG:"+SG);
			// Finally, write down the file
			try {
				BufferedWriter out
				= new BufferedWriter(new FileWriter(args[1]));
				out.write(fHeader.toString());
				out.close();
			} catch (IOException e) {
				throw new Exception();
			}
		} catch (FileNotFoundException e) {
			throw new Exception(e);
		}
	}

}

class LifcachLexiconEntry {

	public int rank;
	public String lemma;
	public String pos;
	public Float freq;

	public LifcachLexiconEntry(){}

}
