package students.grades.tracker.model;

public class Teacher {

	private final String name;
	private final Allocations allocations;

	public Teacher(String name, Allocations allocations) {
		this.name = name;
		this.allocations = allocations;
	}

	public String getName() {
		return name;
	}

	public Allocations getAllocations() {
		return allocations;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", allocations=" + allocations + "]";
	}
}
