package designpatterns.exercises.visitor;

public class TagsCountVisitor implements XMLVisitor {
	private int countTags = 0;

	public void visit(XMLElement element) {
		setCountTags(getCountTags() + 1);
	}

	public int getCountTags() {
		return countTags;
	}

	public void setCountTags(int icountTags) {
		countTags = icountTags;
	}
}
