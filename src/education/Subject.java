package education;

/**
 * Класс хранит информацию о предметах студента. Каждый предмет либо закрыт, либо нет.
 */
public class Subject {
    private boolean isProgrammingPassed;
    private boolean isOPDPassed;

    public Subject(boolean isProgrammingPassed, boolean isOPDPassed) {
        this.isProgrammingPassed = isProgrammingPassed;
        this.isOPDPassed = isOPDPassed;
    }

    public boolean isProgrammingPassed() {
        return isProgrammingPassed;
    }

    public boolean isOPDPassed() {
        return isOPDPassed;
    }
}
