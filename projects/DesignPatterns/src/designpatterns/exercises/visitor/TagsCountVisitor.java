package designpatterns.exercises.visitor;

public class TagsCountVisitor implements XMLVisitor
{
	public int countTags = 0;

	public void visit(XMLElement element)
	{
		++countTags;
	}
}
