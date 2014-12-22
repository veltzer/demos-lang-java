package designpatterns.exercises.strategy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements LoggerStrategy {
	private File logFile;
	public FileLogger(String fileName) {
		super();
		logFile = new File(fileName);
	}
	public void logMessageLine(String messageLine) {
		try {
			// Open in append mode.
			FileWriter writer = new FileWriter(logFile, true);
			writer.write(messageLine);
			writer.write("\n");
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
