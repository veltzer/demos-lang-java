package spring.scheduling;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJob extends QuartzJobBean {
	@Override
	protected void executeInternal(JobExecutionContext context) {
		System.out.println("quartz job doing something ");
	}

}
