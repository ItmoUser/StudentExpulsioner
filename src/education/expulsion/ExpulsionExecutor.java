package education.expulsion;

import education.Student;
import education.expulsion.strategy.ExpulsionStrategy;

import java.util.List;

public class ExpulsionExecutor {

    private ExpulsionConfig config;

    public ExpulsionExecutor(ExpulsionConfig config) {
        this.config = config;
    }

    // Метод был перегружен. Намного удобнее обработать сразу поток студентов, чем заниматься по отдельности каждым.
    public void execute(List<Student> students) {
        for (Student s: students) {
            ExpulsionStrategy strategy = s.getStrategy();
            strategy.expulsionProcess(s, config);
        }
    }
    // Но бывают исключения, приходится разбираться с отдельными студентами.
    public void execute(Student student) {
        ExpulsionStrategy strategy = student.getStrategy();
        strategy.expulsionProcess(student, config);
    }
}
