package education.expulsion.strategy;

import education.Student;
import education.expulsion.ExpulsionConfig;


public class EngineeringStrategy extends ExpulsionStrategy {
    @Override
    public void expulsionProcess(Student student, ExpulsionConfig config) {

        if(!config.isSE()) {
            student.setConclusion(facultyIsDisabled());
            return;
        }

        super.expulsionProcess(student, config);

        if(!config.isRandom() && config.isFullMoon() && !conclusion.isExpelled()) {
            student.setConclusion(fullMoonEnabled());
            return;
        }

        student.setConclusion(conclusion);
    }
}
