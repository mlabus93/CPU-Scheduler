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
public class ShortestJobFirst extends AlgorithmBase {

	public ShortestJobFirst(ArrayList<ProcessClass> processes, int runFor) {
		readyQueue = new LinkedList<ProcessClass>();
		CreateReadyQueue(processes);
	}
	
	@Override
	protected String RunAlgorithm(int runFor, ArrayList<ProcessClass> processes) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void CreateReadyQueue(ArrayList<ProcessClass> processes) {
		
	}
	
	private ProcessClass GetShortestJob(ArrayList<ProcessClass> processes) {
		ProcessClass shortestProcess = processes.get(0);
		for (ProcessClass process : processes) {
			if (process.getBurst() < shortestProcess.getBurst()) {
				shortestProcess = process;
			}
		}
		return shortestProcess;
	}
}
