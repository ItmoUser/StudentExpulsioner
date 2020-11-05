package education.expulsion.decorator;

import beer.Beer;
import education.Student;
import education.expulsion.Conclusion;
import education.expulsion.ExpulsionConfig;

public class FacultyDisabledDecorator extends Decorator {

    public FacultyDisabledDecorator(Expulsioner expulsioner) {
        super(expulsioner);
    }

    @Override
    public void expulsionProcess(Student student, ExpulsionConfig config) {
        // super.expulsionProcess(student, config);
        student.setConclusion(facultyIsDisabled());
    }

    protected Conclusion facultyIsDisabled() {
        return new Conclusion(false, Beer.instance.giveBeer());
    }
}
