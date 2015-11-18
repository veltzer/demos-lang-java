package johnbryce.lab4.solution;

import java.io.File;
import java.util.ArrayList;
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
		fileExt = ifileExt;
		fileList = ifileList;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String idirectory) {
		directory = idirectory;
	}

	@Override
	protected void compute() {
		File dir = new File(directory);
		System.out.println("searching directory : " + dir);
		if (!dir.exists()) {
			return;
		}
		Collection<DirectorySearch> searches = new ArrayList<>();
		for (String file : dir.list()) {
			File tmp = new File(directory + "/" + file);
			if (tmp.isDirectory()) {
				searches.add(
						new DirectorySearch(tmp.toString(), fileExt, fileList));
			} else {
				if (file.endsWith(fileExt)) {
					fileList.add(tmp.toString());
				}
			}
		}
		invokeAll(searches);
	}
}
