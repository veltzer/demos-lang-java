/*
 * Created on Feb 9, 2006
 */
package dp.visitor;

public class TagsCountVisitor implements XMLVisitor
{
	public int countTags = 0;

	public void visit(XMLElement element)
	{
		++countTags;
	}
}