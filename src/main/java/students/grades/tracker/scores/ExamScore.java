package students.grades.tracker.scores;

public class ExamScore implements Scorable {
	private final int value;
	private final int base;

	public ExamScore(int value, int base) {
		this.value = value;
		this.base = base;
	}

	public int getValue() {
		return value;
	}

	public int getBase() {
		return base;
	}

	@Override
	public String toString() {
		return "ExamScore [value=" + value + ", base=" + base + "]";
	}
}
