package calendar.service;

//import java.util.*;
//import javax.jws.*;

@WebService
public class HebCalendar {

	@WebMethod
	public String hebDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayNum = c.get(Calendar.DAY_OF_WEEK);
		return hebDayName(dayNum);
	}
	@WebMethod
	public String hebDayName(int dayNum) {
		switch (dayNum) {
			case 1: return "ראשון";
			case 2: return "שני";
			case 3: return "שלישי";
			case 4: return "רביעי";
			case 5: return "חמישי";
			case 6: return "שישי";
			case 7: return "שבת";
			default:
				return null;
		}
		return null;
	}
}
