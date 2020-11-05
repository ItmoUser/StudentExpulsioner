package education.expulsion.decorator;

import education.Student;
import education.expulsion.Conclusion;
import education.expulsion.ExpulsionConfig;

public class FullMoonDecorator extends Decorator {
    public FullMoonDecorator(Expulsioner expulsioner) {
        super(expulsioner);
    }

    @Override
    public void expulsionProcess(Student student, ExpulsionConfig config) {
        super.expulsionProcess(student, config);
    }

    protected Conclusion fullMoonEnabled() {
        return new Conclusion(true, fullMoon);
    }
}
