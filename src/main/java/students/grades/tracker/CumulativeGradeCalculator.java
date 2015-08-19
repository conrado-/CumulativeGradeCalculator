package students.grades.tracker;

import students.grades.tracker.model.Allocations;
import students.grades.tracker.model.Log;
import students.grades.tracker.scores.AssignmentScore;
import students.grades.tracker.scores.ExamScore;
import students.grades.tracker.scores.ExtraCreditScore;
import students.grades.tracker.scores.Scorable;

public class CumulativeGradeCalculator {

	public double calculateGrade(Log log) {

		double assignmentsValue = 0, examsValue = 0, extraCreditValue = 0;
		int assignmentsBase = 0, examsBase = 0;

		Allocations allocations = log.getStudent().getTeacher()
				.getAllocations();

		double extraCredit = allocations.getExtraCredit();
		double assignmentsWeight = allocations.getAssignments();
		double examsWeight = allocations.getExams();

		double grade = 0;
		for (Scorable score : log) {
			if (score instanceof AssignmentScore) {
				AssignmentScore assignmentScore = (AssignmentScore) score;
				assignmentsValue += assignmentScore.getValue();
				assignmentsBase += assignmentScore.getBase();
			}
			if (score instanceof ExtraCreditScore) {
				extraCreditValue += extraCredit;
			}
			if (score instanceof ExamScore) {
				ExamScore examScore = (ExamScore) score;
				examsValue += examScore.getValue();
				examsBase += examScore.getBase();
			}
		}
		if (assignmentsBase > 0) {
			grade += (100 * assignmentsValue) / assignmentsBase;
		}
		grade += extraCreditValue;
		if (examsBase > 0) {
			double examScore = (100 * examsValue) / examsBase;
			grade = (assignmentsWeight * grade + examsWeight * examScore) / 100;
		}
		double roundedGrade = Math.round(grade * 100.0) / 100.0;
		return roundedGrade;
	}
}
