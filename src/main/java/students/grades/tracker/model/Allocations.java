package students.grades.tracker.model;

public class Allocations {
	private final double assignments;
	private final double exams;
	private final double extraCredit;

	public Allocations(double assignments, double exams, double extraCredit) {
		this.assignments = assignments;
		this.exams = exams;
		this.extraCredit = extraCredit;
	}

	public double getAssignments() {
		return assignments;
	}

	public double getExams() {
		return exams;
	}

	public double getExtraCredit() {
		return extraCredit;
	}

	@Override
	public String toString() {
		return "Allocations [assignments=" + assignments + ", exams=" + exams
				+ ", extraCredit=" + extraCredit + "]";
	}
}
