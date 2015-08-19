package students.grades.tracker.model;

public class Student {
	private final String name;
	private final Teacher teacher;

	public Student(String name, Teacher teacher) {
		this.name = name;
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", teacher=" + teacher + "]";
	}
}
