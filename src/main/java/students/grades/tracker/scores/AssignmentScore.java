package students.grades.tracker.scores;

public class AssignmentScore implements Scorable {

	private final int value;
	private final int base;

	public AssignmentScore(int value, int base) {
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
		return "AssignmentScore [value=" + value + ", base=" + base + "]";
	}

}
