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
		results = RunAlgorithm(runFor, processes);
	}
	
	@Override
	protected String RunAlgorithm(int runFor, ArrayList<ProcessClass> processes) {
		StringBuilder sb = new StringBuilder();
		int processStartTime = 0;
		ProcessClass runningProcess = null;
		
		sb.append(processes.size() + " processes\n");
		sb.append("Using Shortest Job First (preemptive)\n\n");
		for (int time=0; time<runFor; time++) {
			// Check for processes in queue and running process
			if (runningProcess != null) {
				// check if process finished
				if (runningProcess.getBurst() == 0) {
					sb.append("Time " + time + ": " + runningProcess.getName() + " finished\n");
					runningProcess = null;
				}
			}
			// check for processes in queue
			if (!readyQueue.isEmpty()) {
				// loop through processes in queue
				for (ProcessClass process : processes) {
					//check for process arriving at current time
					if (time == process.getArrival()) {
						sb.append("Time " + time + ": " + process.getName() + " arrived\n");
						process.setArrived(true);
						// check for running process
						if (runningProcess != null) {
							// check if preemption will switch processes
							if (process.getBurst() < runningProcess.getBurst()) {
								ProcessClass newShortest = readyQueue.pop();
								// add preempted running process back to queue
								readyQueue.add(runningProcess);
								// set new process to running
								runningProcess = newShortest;
								sb.append("Time " + time + ": " + runningProcess.getName() + " selected (burst " +
										runningProcess.getBurst() + ")\n");
							}
						}
					}
				}
			}
			// check if no running process
			if (runningProcess == null) {
				// check if process is available in queue
				if (!readyQueue.isEmpty()) {
					// assign only process if it has arrived
					if (readyQueue.get(0).hasArrived()) {
						runningProcess = readyQueue.pop();
						processStartTime = time;
						sb.append("Time " + time + ": " + runningProcess.getName() + " selected (burst " +
								runningProcess.getBurst() + ")\n");
					}
				}
				// idle time because no processes ready
				else {
					sb.append("Time " + time + ": Idle\n");
				}
			}
			if (runningProcess != null) {
				// decrement burst each time unit
				runningProcess.setBurst(runningProcess.getBurst() - 1);
			}
			// Update wait times
			for (ProcessClass process: readyQueue) {
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
}
