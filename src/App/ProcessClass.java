/**
 * 
 */
package App;

/**
 * @author michaellabus
 *
 */
public class ProcessClass {
	private String name;
	private String algorithm;
	private int arrival;
	private int burst;
	private int originalBurst;
	private int quantum;
	private int wait;
	private int turnaround;
	private boolean arrived = false;
	
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
	
	public int getOriginalBurst() {
		return originalBurst;
	}
	
	public void setOriginalBurst(int originalBurst) {
		this.originalBurst = originalBurst;
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
		this.turnaround = wait + originalBurst;
	}
	
	public boolean hasArrived() {
		return arrived;
	}
	
	public void setArrived(boolean arrived) {
		this.arrived = arrived;
	}
}
