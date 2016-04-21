package learningtest.org.springframework.boot.autoconfigure.condition;

import com.izeye.throwaway.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 4. 21..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.NONE,
		classes = Application.class
)
public class ConditionEvaluationReportTests {
	
	@Autowired
	ConditionEvaluationReport autoConfigurationReport;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Test
	public void test() {
		assertThat(autoConfigurationReport).isNotNull();

		ConditionEvaluationReport report = applicationContext.getBean(
				"autoConfigurationReport", ConditionEvaluationReport.class);
		assertThat(report).isEqualTo(autoConfigurationReport);
	}
	
}
