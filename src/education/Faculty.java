package education;

import education.expulsion.strategy.EngineeringStrategy;
import education.expulsion.strategy.ExpulsionStrategy;
import education.expulsion.strategy.InformaticsStrategy;
import education.expulsion.strategy.RoboticsStrategy;

/**
 * ICE = INFORMATICS AND COMPUTER ENGINEERING
 * SE = SOFTWARE ENGINEERING
 * Класс хранит название факультета, а также стратегию, по которой будет приниматься
 * решение об отчислении студента.
 */
public enum Faculty {
    ROBOTICS("Robotics", new RoboticsStrategy()),
    ICE("Informatics and computer engineering", new InformaticsStrategy()),
    SE("Software Engineering", new EngineeringStrategy());

    private ExpulsionStrategy strategy;
    private final String title;

    Faculty(String title, ExpulsionStrategy strategy) {
        this.title = title;
        this.strategy = strategy;
    }

    public ExpulsionStrategy getStrategy() {
        return strategy;
    }


    @Override
    public String toString() {
        return title;
    }
}
