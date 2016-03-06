/**
 * 
 */
package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;

import App.ProcessClass;

/**
 * @author michaellabus
 *
 */
public abstract class AlgorithmBase {
	String results;
	LinkedList<ProcessClass> readyQueue;
	
	// abstract methods for algorithms
	protected abstract String RunAlgorithm(int runFor, ArrayList<ProcessClass> processes);
	
	// Shared common functionality methods
	protected ArrayList<ProcessClass> CreateTempProcessList(ArrayList<ProcessClass> processes) {
		ArrayList<ProcessClass> processList = new ArrayList<ProcessClass>();
		for (ProcessClass process : processes) {
			processList.add(process);
		}
		return processList;
	}
	
	protected void CreateReadyQueue(ArrayList<ProcessClass> processes) {
		ArrayList<ProcessClass> processList = CreateTempProcessList(processes);
		ProcessClass firstProcess;
		for (int i=0; i<processes.size(); i++) {
			firstProcess = GetFirstArrival(processList);
			readyQueue.add(firstProcess);
			processList.remove(firstProcess);
		}
	}
	
	private ProcessClass GetFirstArrival(ArrayList<ProcessClass> processes) {
		ProcessClass firstProcess = processes.get(0);
		int firstArrival = firstProcess.getArrival();
		for (ProcessClass process : processes) {
			if (process.getArrival() < firstArrival) {
				firstArrival = process.getArrival();
				firstProcess = process;
			}
		}
		return firstProcess;
	}
	
	public String GetResults() {
		return results;
	}
	
}
