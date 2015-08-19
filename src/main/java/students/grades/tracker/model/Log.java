package students.grades.tracker.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import students.grades.tracker.scores.Scorable;

public class Log implements Iterable<Scorable> {

	private final Student student;
	private List<Scorable> scores;

	public Log(Student student) {
		this.student = student;
		this.scores = new LinkedList<Scorable>();
	}

	public Student getStudent() {
		return student;
	}

	public void add(Scorable scorable) {
		scores.add(scorable);
	}

	public Iterator<Scorable> iterator() {
		return scores.iterator();
	}

	@Override
	public String toString() {
		return "Log [student=" + student + ", scores=" + scores + "]";
	}
}
