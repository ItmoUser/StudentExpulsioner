package education;

import education.expulsion.Conclusion;
import education.expulsion.strategy.ExpulsionStrategy;

import java.util.Formatter;

public class Student {
    private String fullName;
    private Faculty faculty;
    private Subject subject;
    private Conclusion conclusion;

    public Student(String fullName, Faculty faculty, Subject subject) {
        this.fullName = fullName;
        this.faculty = faculty;
        this.subject = subject;
        conclusion = new Conclusion();
    }

    public void setConclusion(Conclusion conclusion) {
        this.conclusion = conclusion;
    }
    public Subject getSubject() {
        return subject;
    }
    public ExpulsionStrategy getStrategy() {
        return faculty.getStrategy();
    }

    @Override
    public String toString() {
        return new Formatter()
                .format("Full name: %s\n" +
                        "Faculty: %s\n" +
                        "Expulsion decision: %s\n" +
                        "Clarification: %s\n",
                        fullName, faculty, conclusion.isExpelled(), conclusion.getClarification())
                .toString();
    }
}
