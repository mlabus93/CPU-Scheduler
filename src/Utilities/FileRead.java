/**
 * 
 */
package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import App.ProcessClass;
import App.Scheduler;

/**
 * @author michaellabus
 *
 */
public class FileRead {
	
	public Scheduler ReadFile(File input, ArrayList<ProcessClass> processes, Scheduler scheduler) {
		try {
			Scanner scanner = new Scanner(input);
			scanner.next();
			int processCount = scanner.nextInt();
			scanner.nextLine();
			scanner.next();
			scheduler.setRunFor(scanner.nextInt());
			scanner.nextLine();
			scanner.next();
			scheduler.setAlgorithm(scanner.next());
			scanner.nextLine();
			scanner.next();
			int quantum = scanner.nextInt();
			scanner.nextLine();
			for (int i=0; i<processCount; i++) {
				ProcessClass newProcess = new ProcessClass();
				newProcess.setAlgorithm(scheduler.getAlgorithm());
				newProcess.setQuantum(quantum);
				scanner.next();
				scanner.next();
				newProcess.setName(scanner.next());
				scanner.next();
				newProcess.setArrival(scanner.nextInt());
				scanner.next();
				int burst = scanner.nextInt();
				newProcess.setOriginalBurst(burst);
				newProcess.setBurst(burst);
				processes.add(newProcess);
				newProcess = new ProcessClass();
			}

			scanner.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		return scheduler;
	}
}
