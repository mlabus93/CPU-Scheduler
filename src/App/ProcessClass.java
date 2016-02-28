/**
 * 
 */
package App;

/**
 * @author michaellabus
 *
 */
public class ProcessClass {
	String name;
	String algorithm;
	int arrival;
	int burst;
	int quantum;
	int wait;
	int turnaround;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAlgorithm() {
		return algorithm;
	}
	
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	
	public int getArrival() {
		return arrival;
	}
	
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	
	public int getBurst() {
		return burst;
	}
	
	public void setBurst(int burst) {
		this.burst = burst;
	}
	
	public int getQuantum() {
		return quantum;
	}
	
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
	
	public int getWait() {
		return wait;
	}
	
	public void setWait(int wait) {
		this.wait = wait;
		setTurnaround();
	}
	
	public int getTurnaround() {
		return turnaround;
	}
	
	private void setTurnaround() {
		this.turnaround = wait + burst;
	}
}
