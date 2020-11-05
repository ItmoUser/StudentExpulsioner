package education.expulsion.decorator;

import education.Student;
import education.expulsion.ExpulsionConfig;

public class Decorator implements Expulsioner {

    protected Expulsioner expulsioner;

    public Decorator(Expulsioner expulsioner) {
        this.expulsioner = expulsioner;
    }

    @Override
    public void expulsionProcess(Student student, ExpulsionConfig config) {
        expulsioner.expulsionProcess(student, config);
        // Добавочные действия
    }
}
