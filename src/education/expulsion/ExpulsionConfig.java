package education.expulsion;

import beer.Beer;
import java.util.Formatter;


/**
 * Класс-конфигурация. Было принято решение реализовать паттерн Builder, потому что класс имеет
 * Слишком много полей, а также потому что ни одно поле не обязано быть инициализировано вручную.
 * Это легче, чем создавать множество конструкторов для разных наборов параметров.
 */
public class ExpulsionConfig {

    private boolean isFullMoon;
    private boolean isRandom;
    private boolean robotics;
    private boolean ICE;
    private boolean SE;


    public ExpulsionConfig(boolean robotics,
                           boolean ICE,
                           boolean SE,
                           boolean isFullMoon,
                           boolean isRandom) {
        this.isFullMoon = isFullMoon;
        this.isRandom = isRandom;
        this.robotics = robotics;
        this.ICE = ICE;
        this.SE = SE;
    }

    public boolean isFullMoon() {
        return isFullMoon;
    }
    public boolean isRandom() {
        return isRandom;
    }
    public boolean isRobotics() {
        return robotics;
    }
    public boolean isICE() {
        return ICE;
    }
    public boolean isSE() {
        return SE;
    }


    public static class Builder {
        private boolean isFullMoon;
        private boolean isRandom;
        private boolean robotics;
        private boolean ICE; // Informatics and Computer Engineering
        private boolean SE; // Software engineering

        /*
        В данном случае бессмысленно инициализировать переменные в конструкторе, т.к они все
        примитивные (Инициализируются автоматически компилятором), но если в конфигуратор добавить другие поля,
        в т.ч. объектные перменные, то явная инициализация будет необходима.
        */
        public Builder() {
            isFullMoon = false;
            isRandom = false;
            robotics = false;
            ICE = false;
            SE = false;
        }

        public Builder setFullMoon(boolean fullMoon) {
            isFullMoon = fullMoon;
            return this;
        }

        public Builder setRandom(boolean random) {
            isRandom = random;
            return this;
        }

        public Builder setRobotics(boolean robotics) {
            this.robotics = robotics;
            return this;
        }

        public Builder setICE(boolean ICE) {
            this.ICE = ICE;
            return this;
        }

        public Builder setSE(boolean SE) {
            this.SE = SE;
            return this;
        }

        public ExpulsionConfig build() {
            return new ExpulsionConfig(robotics, ICE, SE, isFullMoon, isRandom);
        }
    }

    @Override
    public String toString() {
        return new Formatter()
                .format("Robotics: %b\n" +
                        "Informatics and Computer Engineering: %b\n" +
                        "Software Engineering: %b\n" +
                        "Full moon: %b\n" +
                        "Random: %b\n" +
                        "Amount of beer: %d\n",
                        robotics, ICE, SE, isFullMoon, isRandom, Beer.instance.getAmount())
                .toString();
    }
}
