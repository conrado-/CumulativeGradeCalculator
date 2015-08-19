package students.grades.tracker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import students.grades.tracker.model.Allocations;
import students.grades.tracker.model.Log;
import students.grades.tracker.model.Student;
import students.grades.tracker.model.Teacher;
import students.grades.tracker.scores.AssignmentScore;
import students.grades.tracker.scores.ExamScore;
import students.grades.tracker.scores.ExtraCreditScore;

public class ApiTest {

	private static final double ASSIGNMENTS_WEIGHT = 10.1;
	private static final double EXAMS_WEIGHT = 89.9;
	private static final double EXTRA_CREDITS_WEIGHT = 2;
	private static final double EPSILON = 0.0001;

	@Test
	public void testSum() {

		Allocations allocations = new Allocations(ASSIGNMENTS_WEIGHT,
				EXAMS_WEIGHT, EXTRA_CREDITS_WEIGHT);

		Teacher tom = new Teacher("Tom", allocations);
		Student sally = new Student("Sally", tom);
		CumulativeGradeCalculator calculator = new CumulativeGradeCalculator();

		Log log = new Log(sally);

		log.add(new AssignmentScore(85, 100));
		assertEquals(85.0, calculator.calculateGrade(log), EPSILON);

		log.add(new AssignmentScore(88, 100));
		assertEquals(86.5, calculator.calculateGrade(log), EPSILON);

		log.add(new ExtraCreditScore());
		assertEquals(88.5, calculator.calculateGrade(log), EPSILON);

		log.add(new AssignmentScore(92, 100));
		assertEquals(90.33, calculator.calculateGrade(log), EPSILON);

		log.add(new ExamScore(91, 100));
		assertEquals(90.93, calculator.calculateGrade(log), EPSILON);
	}
}
