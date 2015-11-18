package johnbryce.lab4.exercise;

import java.util.Collection;
import java.util.concurrent.RecursiveAction;

@SuppressWarnings("serial")
public class DirectorySearch extends RecursiveAction {

	private String directory;
	private String fileExt;
	private Collection<String> fileList;

	public DirectorySearch(String idirectory, String ifileExt,
			Collection<String> ifileList) {
		super();
		directory = idirectory;
		setFileExt(ifileExt);
		setFileList(ifileList);
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String idirectory) {
		directory = idirectory;
	}

	@Override
	protected void compute() {
		// enter text here
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String ifileExt) {
		fileExt = ifileExt;
	}

	public Collection<String> getFileList() {
		return fileList;
	}

	public void setFileList(Collection<String> ifileList) {
		fileList = ifileList;
	}
}
