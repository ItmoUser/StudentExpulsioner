package education.expulsion.decorator;

import education.Student;
import education.expulsion.ExpulsionConfig;

public interface Expulsioner {
    String programming = "Programming";
    String programmingPassed = "Programming hasn't been failed";
    String OPD = "Fundamentals of professional activity";
    String allExamsPassed = "All exams have been passed";
    String coinDecision = "The coin has decided so";
    String fullMoon = "Full moon";

    void expulsionProcess(Student student, ExpulsionConfig config);
}
