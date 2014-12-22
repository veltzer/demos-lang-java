package exercise;

import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class RowTag extends TagSupport {
	private String colName;
	public int doStartTag() {
		try {
			TableTag table = (TableTag) getParent();
			if (table == null) {
				throw new JspException("No parent table tag.");
			}
			ResultSet rs = table.getRs();
			pageContext.getOut().print(rs.getString(colName));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return SKIP_BODY;
	}
	/**
	 * Getter for property colName.
	 * @return Value of property colName.
	 */
	public String getColName() {
		return colName;
	}
	/**
	 * Setter for property colName.
	 * @param colName New value of property colName.
	 */
	public void setColName(String icolName) {
		colName = icolName;
	}
}
