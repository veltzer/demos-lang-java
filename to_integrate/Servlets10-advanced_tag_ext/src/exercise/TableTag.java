package exercise;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class TableTag extends TagSupport {
	private static final String ERR_STRING1 = "connection not found";
	private String tableName;
	private ResultSet rs;

	public int doStartTag() {
		try {
			Connection con = (Connection) pageContext
					.getAttribute("connection");
			if (con == null) {
				throw new RuntimeException(ERR_STRING1);
			}
			String sql = "SELECT * from " + tableName;
			Statement stmt = con.createStatement();
			setRs(stmt.executeQuery(sql));
			if (getRs().next()) {
				return EVAL_BODY_INCLUDE;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return SKIP_BODY;
	}

	public int doAfterBody() {
		try {
			if (getRs().next()) {
				// FIXME
				return 0;
				//return EVAL_BODY_BUFFERED;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return SKIP_BODY;

	}

	public int doEndTag() {
		setRs(null);
		return EVAL_PAGE;
	}

	/**
	 * Getter for property tableName.
	 * @return Value of property tableName.
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * Setter for property tableName.
	 * @param tableName New value of property tableName.
	 */
	public void setTableName(String itableName) {
		tableName = itableName;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet irs) {
		rs = irs;
	}
}
