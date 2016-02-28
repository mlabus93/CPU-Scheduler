/**
 * 
 */
package App;

import java.io.File;
import java.util.ArrayList;

import Algorithms.*;
import Utilities.FileRead;

/**
 * @author michaellabus
 *
 */
public class App {
	
	static ArrayList<ProcessClass> processes = new ArrayList<ProcessClass>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String result = "";
		Scheduler scheduler = new Scheduler();
		File input = new File("src/processes.in");
		FileRead fr = new FileRead();
		scheduler = fr.ReadFile(input, processes, scheduler);
		switch (scheduler.getAlgorithm()) {
			case "fcfs":
				FirstComeFirstServe fcfs = new FirstComeFirstServe(processes, scheduler.getRunFor());
				result = fcfs.GetResults();
				break;
			case "sjf":
				break;
			case "rr":
				System.out.println("Not implemented.");
				break;
			default:
				System.out.println("Invalid algorithm type.");
				break;
		}
		System.out.println(result);
	}

}
