package education.expulsion.strategy;

import education.Student;
import education.expulsion.ExpulsionConfig;

public class RoboticsStrategy extends ExpulsionStrategy {
    @Override
    public void expulsionProcess(Student student, ExpulsionConfig config) {

        if(!config.isRobotics()) {
            student.setConclusion(facultyIsDisabled());
            return;
        }

        conclusion.setExpelled(!student.getSubject().isProgrammingPassed());
        conclusion.setClarification(conclusion.isExpelled() ? "Failed exam: " + programming : programmingPassed);

        student.setConclusion(conclusion);
    }
}
