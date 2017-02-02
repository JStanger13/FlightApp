import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class flightsData {
	public void loadRercords(){
		HashMap<String, LinkedList> map = new HashMap<String, LinkedList>();
		String from;
		String destination;
		int price;
		
		File file = new File("/Users/justinstangerflights.docx");
		Scanner scan;
		
		try {
			scan = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	
		System.out.println("Does Scan have next line? " + scan.hasNextLine());
	
		while(scan.hasNextLine()){
			System.out.println("------ NEW LINE --------");
			String line = scan.nextLine();
			Scanner scanline = new Scanner(line);
			from = scanline.next();
			LinkedList trip = new LinkedList();
			while(scanline.hasNext()){
				destination = scanline.next();
				trip.add(destination);
				price = scanline.nextInt();
				trip.add(price);
			}
			scanline.close(); 
			System.out.println("from = " + from);
			System.out.println("trip = " + trip);
			map.put(from, trip);
		}
		scan.close();
	}
}