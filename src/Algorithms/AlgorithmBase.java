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
	protected abstract void CreateReadyQueue(ArrayList<ProcessClass> processes);
	protected abstract String RunAlgorithm(int runFor, ArrayList<ProcessClass> processes);
	
	// Shared common functionality methods
	protected ArrayList<ProcessClass> CreateTempProcessList(ArrayList<ProcessClass> processes) {
		ArrayList<ProcessClass> processList = new ArrayList<ProcessClass>();
		for (ProcessClass process : processes) {
			processList.add(process);
		}
		return processList;
	}
	public String GetResults() {
		return results;
	}
	
}
