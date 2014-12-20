package designpatterns.exercises.templatemethod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends AbstractLogger
{
	private File logFile;

	public FileLogger(String fileName)
	{
		super();
		logFile = new File(fileName);
	}

	protected void logMessageLine(String messageLine)
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
