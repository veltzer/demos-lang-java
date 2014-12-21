package jsp.exercises.taglibs.solutions.database;

import javax.servlet.jsp.tagext.*;

public class ConnectionExtraInfo extends TagExtraInfo {
	public VariableInfo[] getVariableInfo(TagData data) {
		VariableInfo conInfo = new VariableInfo("connection","java.sql.Connection",true,VariableInfo.AT_END);
		VariableInfo[] vars = {conInfo};
		return vars;
	}
}
