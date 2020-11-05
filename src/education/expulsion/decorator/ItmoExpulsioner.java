package education.expulsion.decorator;

import education.Student;
import education.expulsion.Conclusion;
import education.expulsion.ExpulsionConfig;

import java.util.ArrayList;
import java.util.List;

public class ItmoExpulsioner implements Expulsioner {

    public Conclusion conclusion;

    @Override
    public void expulsionProcess(Student student, ExpulsionConfig config) {
        boolean isProgrammingPassed = student.getSubject().isProgrammingPassed();
        boolean isOPDPassed = student.getSubject().isOPDPassed();

        conclusion = new Conclusion();
        if(!isProgrammingPassed || !isOPDPassed) {
            conclusion.setExpelled(true);
            conclusion.setClarification("Failed exams: " + failedExams(isProgrammingPassed,isOPDPassed));
        } else {
            conclusion.setExpelled(false);
            conclusion.setClarification(allExamsPassed);
        }
    }

    protected String failedExams(boolean programming, boolean OPD) {
        List<String> exams = new ArrayList<>();
        if (!programming) {
            exams.add(this.programming);
        }
        if (!OPD) {
            exams.add(this.OPD);
        }
        if (exams.size() == 0) throw new RuntimeException();
        String s = exams.toString();
        return s.substring(1, s.length() - 1);
    }
}
