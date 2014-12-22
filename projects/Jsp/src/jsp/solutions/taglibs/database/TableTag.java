package jsp.solutions.taglibs.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class TableTag extends TagSupport {
	private String tableName;
	private ResultSet rs;
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet irs) {
		rs = irs;
	}
	public int doStartTag() {
		try {
			Connection con = (Connection) pageContext.getAttribute("connection");
			if (con == null) {
				throw new RuntimeException("Connection not found.");
			}
			String sql = "SELECT * from " + tableName;
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				return EVAL_BODY_INCLUDE;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return SKIP_BODY;
	}
	public int doAfterBody() {
		try {
			if (rs.next()) {
				return EVAL_BODY_AGAIN;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return SKIP_BODY;

	}
	public int doEndTag() {
		rs = null;
		return EVAL_PAGE;
	}
	/** Getter for property tableName.
	 * @return Value of property tableName.
	 */
	public String getTableName() {
		return tableName;
	}
	/** Setter for property tableName.
	 * @param tableName New value of property tableName.
	 */
	public void setTableName(String itableName) {
		tableName = itableName;
	}
}
