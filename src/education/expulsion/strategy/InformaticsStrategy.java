package education.expulsion.strategy;

import education.Student;
import education.expulsion.ExpulsionConfig;

public class InformaticsStrategy extends ExpulsionStrategy {
    @Override
    public void expulsionProcess(Student student, ExpulsionConfig config) {

        if(!config.isICE()) {
            student.setConclusion(facultyIsDisabled());
            return;
        }

        super.expulsionProcess(student, config);

        if(config.isRandom() && !conclusion.isExpelled()) {
            student.setConclusion(randomEnabled());
            return;
        }

        student.setConclusion(conclusion);
    }
}
