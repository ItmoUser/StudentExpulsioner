package education.expulsion.strategy;

import beer.Beer;
import education.Student;
import education.expulsion.Conclusion;
import education.expulsion.ExpulsionConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Интерфейс-стратегия. Здесь также реализовано четыре метода по умолчанию, т.к они не зависят от реализации
 */
public abstract class ExpulsionStrategy {

    String programming = "Programming";
    String programmingPassed = "Programming hasn't been failed";
    String OPD = "Fundamentals of professional activity";
    String allExamsPassed = "All exams have been passed";
    String coinDecision = "The coin has decided so";
    String fullMoon = "Full moon";

    Conclusion conclusion;

    // Родительский метод теперь првоеряет только одну вещь: Завален ли хоть один предмет,
    // все остальное (Радном, луна и др. исключения лежат на классах-реализациях).
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


    // Метод вызывается только когда проверка факультеты выключена.
    protected Conclusion facultyIsDisabled() {
        return new Conclusion(false, Beer.instance.giveBeer());
    }

    protected Conclusion fullMoonEnabled() {
        return new Conclusion(true, fullMoon);
    }

    protected Conclusion randomEnabled() {
        return new Conclusion(new Random().nextBoolean(), coinDecision);
    }

    /* Метод генерирует список несданных предметов, вызывается только когда есть хотя бы одна задолженность,
    поэтому exams.size() не может равняться нулю
     */
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