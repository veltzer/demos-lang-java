package johnbryce.lab4.exercise;

import java.util.Collection;
import java.util.concurrent.RecursiveAction;

@SuppressWarnings("serial")
public class DirectorySearch extends RecursiveAction {

	private String directory;
	private String fileExt;
	private Collection<String> fileList;

	public DirectorySearch(String directory, String fileExt,Collection<String> fileList) {
		super();
		this.directory = directory;
		this.setFileExt(fileExt);
		this.setFileList(fileList);
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	@Override
	protected void compute() {
		//enter text here
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public Collection<String> getFileList() {
		return fileList;
	}

	public void setFileList(Collection<String> fileList) {
		this.fileList = fileList;
	}
}
