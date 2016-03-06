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
public class FirstComeFirstServe extends AlgorithmBase {
	
	public FirstComeFirstServe(ArrayList<ProcessClass> processes, int runFor) {
		readyQueue = new LinkedList<ProcessClass>();
		CreateReadyQueue(processes);
		results = RunAlgorithm(runFor, processes);
	}
	
	@Override
	protected String RunAlgorithm(int runFor, ArrayList<ProcessClass> processes) {
		StringBuilder sb = new StringBuilder();
		boolean running = false;
		int processStartTime = 0;
		ProcessClass runningProcess = null;
		
		sb.append(processes.size() + " processes\n");
		sb.append("Using First Come First Serve\n\n");
		for (int time=0; time<runFor; time++) {
			// Check to see if there is a running process and if it's burst is finished
			if ( runningProcess != null && (time == processStartTime + runningProcess.getBurst()) ) {
				running = false;
				sb.append("Time " + time + ": " + runningProcess.getName() + " finished\n");
			}
			if (!readyQueue.isEmpty()) {
				// Check top of queue to see if arrival time matches
				for (ProcessClass process : readyQueue) {
					if (time == process.getArrival()) {
						sb.append("Time " + time + ": " + process.getName() + " arrived\n");
					}
				}
			}
			// pop process and set to running if no other process running
			if (!running) {
				// no processes left
				if (readyQueue.isEmpty()) {
					sb.append("Time " + time + ": Idle\n");
				}
				else {
					runningProcess = readyQueue.pop();
					runningProcess.setWait(time - runningProcess.getArrival());
					running = true;
					processStartTime = time;
					sb.append("Time " + time + ": " + runningProcess.getName() +
							" selected (burst " + runningProcess.getBurst() + ")\n");
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
}
