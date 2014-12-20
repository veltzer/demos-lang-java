package design_patterns_exercises.observer.factory.decorator.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements LoggerObserver
{
	private File logFile;

	public FileLogger(String fileName)
	{
		super();
		logFile = new File(fileName);
	}

	public void onLogRequest(int priority, String messageLine)
	{
		try
		{
			// Open in append mode.
			FileWriter writer = new FileWriter(logFile, true);
			writer.write(messageLine);
			writer.write("\n");
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
