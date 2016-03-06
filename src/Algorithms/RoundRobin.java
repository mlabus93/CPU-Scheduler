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
public class RoundRobin extends AlgorithmBase {

	LinkedList<ProcessClass> arrivalQueue;
	
	public RoundRobin(ArrayList<ProcessClass> processes, int runFor) {
		arrivalQueue = new LinkedList<ProcessClass>();
		results = RunAlgorithm(runFor, processes);
	}
	
	@Override
	protected String RunAlgorithm(int runFor, ArrayList<ProcessClass> processes) {
		StringBuilder sb = new StringBuilder();
		boolean firstRun = true;
		int quantum = processes.get(0).getQuantum();
		int quantumCounter = quantum;
		ProcessClass currentProcess = null;
		sb.append(processes.size() + " processes\n");
		sb.append("Using Round Robin\n\n");
		
		for (int time=0; time<runFor; time++) {
			
			// Check for new arriving processes
			CheckForArrivalProcess(sb, time, processes);
			// idle while no processes in queue
			if (arrivalQueue.size() == 0 && currentProcess == null) {
				sb.append("Time " + time + ": Idle\n");
				continue;
			}
			// first process arrival
			if (arrivalQueue.size() == 1 && firstRun) {
				firstRun = false;
				currentProcess = arrivalQueue.pop();
				sb.append("Time " + time + ": " + currentProcess.getName() + " selected (burst " +
						currentProcess.getBurst() + ")\n");
			}
			if (currentProcess.getBurst() == 0) {
				sb.append("Time " + time + ": Idle\n");
			}
			// check for quantum count
			if (quantumCounter == 0) {
				// check for currentProcess and if still needs to run
				if (currentProcess != null && currentProcess.getBurst() != 0) {
					arrivalQueue.add(currentProcess);
				}
				// currentProcess finished
				else if (currentProcess != null){
					sb.append("Time " + time + ": " + currentProcess.getName() + " finished\n");
				}
				// set next running process
				currentProcess = arrivalQueue.pop();
				sb.append("Time " + time + ": " + currentProcess.getName() + " selected (burst " +
						currentProcess.getBurst() + ")\n");
				quantumCounter = quantum; 
			}
			// reduce quantum each time
			if (currentProcess != null) {
				quantumCounter--;
				currentProcess.setBurst(currentProcess.getBurst() - 1);
			}
			// Update wait times
			for (ProcessClass process: arrivalQueue) {
				if (process.hasArrived()) {
					process.setWait(process.getWait() + 1);
				}
				else {
					process.setWait(process.getWait());
				}
			}
		}
		sb.append("Finished at time " + runFor + "\n\n");
		for (ProcessClass process : processes) {
			sb.append(process.getName() + " wait " + process.getWait() + " turnaround " +
					process.getTurnaround() + "\n");
		}
		return sb.toString();
	}
	
	private void CheckForArrivalProcess(StringBuilder sb, int time, ArrayList<ProcessClass> processes) {
		for (ProcessClass process : processes) {
			if (process.getArrival() == time) {
				process.setArrived(true);
				arrivalQueue.add(process);
				sb.append("Time " + time + ": " + process.getName() + " arrived\n");
			}
		}
	}
}
