package cl.uach.kelluwen.nlp.io.csv;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.apache.uima.util.FileUtils;

public class _GenerateLDAResults {

	public static HashMap<String,String> mapLDA = new HashMap<String,String>();
	public static HashMap<String,String> mapSVM = new HashMap<String,String>();
	public static HashMap<String,String> mapREF = new HashMap<String,String>();

	public static void main(String[] args) throws IOException {
		//Lire les fichiers
		File fileLDA = new File(args[0]);
		String textLDA = FileUtils.file2String(fileLDA, "UTF-8");
		StringTokenizer stLinesLDA= new StringTokenizer(textLDA,"\n");
		int nb_duplicates=0;
		int nb_duplicates_SVM=0;
		while (stLinesLDA.hasMoreTokens()){
			String lineLDA = stLinesLDA.nextToken();
			String[] elementsLDA = lineLDA.split(",");
			if (mapLDA.containsKey(elementsLDA[0])){
				nb_duplicates=nb_duplicates+1;
				//System.out.println("key duplicated in LDA: "+elementsLDA[0]);
			}
			if (elementsLDA[1].equals("1")){mapLDA.put(elementsLDA[0], "0");}
			if (elementsLDA[1].equals("2")){mapLDA.put(elementsLDA[0], "2");}
			if (elementsLDA[1].equals("3")){mapLDA.put(elementsLDA[0], "1");}
		}

		File fileSVM = new File(args[1]);
		String textSVM = FileUtils.file2String(fileSVM, "UTF-8");
		StringTokenizer stLinesSVM= new StringTokenizer(textSVM,"\n");
		while (stLinesSVM.hasMoreTokens()){
			String lineSVM = stLinesSVM.nextToken();
			String[] elementsSVM = lineSVM.split(";");	
			if (mapSVM.containsKey(elementsSVM[0])){
				nb_duplicates_SVM=nb_duplicates_SVM+1;
				//System.out.println("key duplicated in LDA: "+elementsSVM[0]);
			}
			mapSVM.put(elementsSVM[0], elementsSVM[1]);
		}

		File fileREF = new File(args[2]);
		String textREF = FileUtils.file2String(fileREF, "UTF-8");
		StringTokenizer stLinesREF= new StringTokenizer(textREF,"\n");
		while (stLinesREF.hasMoreTokens()){
			String lineREF = stLinesREF.nextToken();
			String[] elementsREF = lineREF.split(";");
			if (elementsREF[1].equals("1")){mapREF.put(elementsREF[0], "2");}
			if (elementsREF[1].equals("2")){mapREF.put(elementsREF[0], "1");}
			if (elementsREF[1].equals("3")){mapREF.put(elementsREF[0], "0");}
		}

		//ACCORD ENTRE LDA et SVM
		int nb_instances=0;
		int nb_instances_clase0=0;
		int nb_instances_clase1=0;
		int nb_instances_clase2=0;
		int global_agreement=0;
		int clase0_agreement=0;
		int clase1_agreement=0;
		int clase2_agreement=0;

		Iterator<Entry<String,String>> itLDA = mapLDA.entrySet().iterator();
		while(itLDA.hasNext()){
			Entry<String,String> entryLDA = itLDA.next();
			String keyLDA=entryLDA.getKey();
			String valueLDA=entryLDA.getValue();
			String valueSVM= mapSVM.get(keyLDA);
			if (valueLDA.equals("0")){nb_instances_clase0=nb_instances_clase0+1;}
			if (valueLDA.equals("1")){nb_instances_clase1=nb_instances_clase1+1;}
			if (valueLDA.equals("2")){nb_instances_clase2=nb_instances_clase2+1;}
			if (valueLDA.equals(valueSVM)){
				global_agreement=global_agreement+1;
				if (valueLDA.equals("0")){clase0_agreement=clase0_agreement+1;}
				if (valueLDA.equals("1")){clase1_agreement=clase1_agreement+1;}
				if (valueLDA.equals("2")){clase2_agreement=clase2_agreement+1;}
			}
			nb_instances=nb_instances+1;
		}

		System.out.println("duplicates in LDA "+nb_duplicates);
		System.out.println("duplicates in SVM "+nb_duplicates_SVM);
		System.out.println(nb_instances);
		System.out.println(global_agreement);
		System.out.println(new Float(new Float(global_agreement)/new Float(nb_instances)));
		System.out.println("CLASSE0-----------------");
		System.out.println(nb_instances_clase0);
		System.out.println(clase0_agreement);
		System.out.println(new Float(new Float(clase0_agreement)/new Float(nb_instances_clase0)));
		System.out.println("CLASSE1-----------------");
		System.out.println(nb_instances_clase1);
		System.out.println(clase1_agreement);
		System.out.println(new Float(new Float(clase1_agreement)/new Float(nb_instances_clase1)));
		System.out.println("CLASSE2-----------------");		
		System.out.println(nb_instances_clase2);
		System.out.println(clase2_agreement);
		System.out.println(new Float(new Float(clase2_agreement)/new Float(nb_instances_clase2)));

		//PRECISION ET RAPPEL ENTRE REF ET LDA
		int nb_instances_REF500=0;
		int nb_instances_clase0_REF500=0;
		int nb_instances_clase1_REF500=0;
		int nb_instances_clase2_REF500=0;
		int nb_instances_clase0_LDA=0;
		int nb_instances_clase1_LDA=0;
		int nb_instances_clase2_LDA=0;
		int nb_correct_TOTAL=0;
		int nb_correct_clase0=0;
		int nb_correct_clase1=0;
		int nb_correct_clase2=0;
		int nb_null=0;
		Iterator<Entry<String,String>> itREF = mapREF.entrySet().iterator();
		while(itREF.hasNext()){
			Entry<String,String> entryRef=itREF.next();
			String keyRef = entryRef.getKey();
			String valueRef = entryRef.getValue();
			String valueLDA=mapLDA.get(keyRef);
			if (valueLDA==null){nb_null=nb_null+1;}
			else {
				nb_instances_REF500=nb_instances_REF500+1;
				if (valueRef.equals("0")){nb_instances_clase0_REF500=nb_instances_clase0_REF500+1;}
				if (valueRef.equals("1")){nb_instances_clase1_REF500=nb_instances_clase1_REF500+1;}
				if (valueRef.equals("2")){nb_instances_clase2_REF500=nb_instances_clase2_REF500+1;}
				if (valueLDA.equals("0")){nb_instances_clase0_LDA=nb_instances_clase0_LDA+1;}
				if (valueLDA.equals("1")){nb_instances_clase1_LDA=nb_instances_clase1_LDA+1;}
				if (valueLDA.equals("2")){nb_instances_clase2_LDA=nb_instances_clase2_LDA+1;}
				if (valueRef.equals(valueLDA)){
					nb_correct_TOTAL=nb_correct_TOTAL+1;
					if (valueRef.equals("0")){nb_correct_clase0=nb_correct_clase0+1;}
					if (valueRef.equals("1")){nb_correct_clase1=nb_correct_clase1+1;}
					if (valueRef.equals("2")){nb_correct_clase2=nb_correct_clase2+1;}
				}
			}
		}
		System.out.println("nb_null="+nb_null);
		System.out.println("====PRECISION LDA=====");
		System.out.println("--Clase 0---");
		System.out.println(nb_instances_clase0_LDA);
		System.out.println(nb_correct_clase0);
		System.out.println(new Float(nb_correct_clase0)/new Float(nb_instances_clase0_LDA));
		System.out.println("--Clase 1---");
		System.out.println(nb_instances_clase1_LDA);
		System.out.println(nb_correct_clase1);
		System.out.println(new Float(nb_correct_clase1)/new Float(nb_instances_clase1_LDA));
		System.out.println("--Clase 2---");
		System.out.println(nb_instances_clase2_LDA);
		System.out.println(nb_correct_clase2);
		System.out.println(new Float(nb_correct_clase2)/new Float(nb_instances_clase2_LDA));
		System.out.println("====RAPPEL LDA=====");
		System.out.println("--Clase 0---");
		System.out.println(nb_instances_clase0_REF500);
		System.out.println(nb_correct_clase0);
		System.out.println(new Float(nb_correct_clase0)/new Float(nb_instances_clase0_REF500));
		System.out.println("--Clase 1---");
		System.out.println(nb_instances_clase1_REF500);
		System.out.println(nb_correct_clase1);
		System.out.println(new Float(nb_correct_clase1)/new Float(nb_instances_clase1_REF500));
		System.out.println("--Clase 2---");
		System.out.println(nb_instances_clase2_REF500);
		System.out.println(nb_correct_clase2);
		System.out.println(new Float(nb_correct_clase2)/new Float(nb_instances_clase2_REF500));
	}
}
