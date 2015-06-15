import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RecursiveAction;

public class DirectorySearch extends RecursiveAction {

	private String directory;
	private String fileExt;
	private Collection<String> fileList;
	
	
	
	public DirectorySearch(String directory, String fileExt,Collection<String> fileList) {
		super();
		this.directory = directory;
		this.fileExt=fileExt;
		this.fileList=fileList;
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
		

}
