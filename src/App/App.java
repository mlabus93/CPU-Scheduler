/**
 * 
 */
package App;

import java.io.File;
import java.util.ArrayList;

import Algorithms.*;
import Utilities.FileRead;
import Utilities.FileWrite;

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
				ShortestJobFirst sjf = new ShortestJobFirst(processes, scheduler.getRunFor());
				result = sjf.GetResults();
				break;
			case "rr":
				RoundRobin rr = new RoundRobin(processes, scheduler.getRunFor());
				result = rr.GetResults();
				break;
			default:
				System.out.println("Invalid algorithm type.");
				break;
		}
		FileWrite fw = new FileWrite();
		fw.WriteFile(result);
		System.out.println(result);
	}

}
