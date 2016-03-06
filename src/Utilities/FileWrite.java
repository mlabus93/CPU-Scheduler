/**
 * 
 */
package Utilities;

import java.io.BufferedWriter;
import java.io.*;

/**
 * @author michaellabus
 *
 */
public class FileWrite {
	
	public void WriteFile(String content) {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("src/processes.out"), "utf-8"));
			writer.write(content);
		}
		catch (IOException ex) {
			
		}
		finally {
			try { writer.close(); } catch (IOException ex) {}
		}
	}
}
