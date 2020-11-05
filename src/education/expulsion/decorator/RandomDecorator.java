package education.expulsion.decorator;

import education.Student;
import education.expulsion.Conclusion;
import education.expulsion.ExpulsionConfig;

import java.util.Random;

public class RandomDecorator extends Decorator {

    public RandomDecorator(Expulsioner expulsioner) {
        super(expulsioner);
    }

    @Override
    public void expulsionProcess(Student student, ExpulsionConfig config) {
        super.expulsionProcess(student, config);

        /*
        if(!conclusion.isExpelled()) {
            student.setConclusion(randomEnabled());
            return;
        }
        */
    }

    protected Conclusion randomEnabled() {
        return new Conclusion(new Random().nextBoolean(), coinDecision);
    }
}
