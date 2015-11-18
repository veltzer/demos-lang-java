package jsp.solutions.taglibs.database;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

public class ConnectionExtraInfo extends TagExtraInfo {
	public VariableInfo[] getVariableInfo(TagData data) {
		VariableInfo conInfo = new VariableInfo("connection",
				"java.sql.Connection", true, VariableInfo.AT_END);
		VariableInfo[] vars = {
				conInfo
		};
		return vars;
	}
}
