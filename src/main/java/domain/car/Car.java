package domain.car;

import domain.result.CarSnapShot;
import exception.InvalidInputException;

public class Car {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_MOVE_BASIS_NUMBER = 4;
    private static final String NOT_ALLOWED_EMPTY_CAR_NAME_EXCEPTION = "자동차 이름은 비어있을 수 없습니다.";
    private static final String NOT_OVER_CAR_NAME_LIMIT_EXCEPTION = "자동차 이름은 " + CAR_NAME_MAX_LENGTH + "를 초과할 수 없습니다.";

    private String name;
    private int position;

    public static Car from(String name) {
        name = name.trim();
        if (name.isEmpty()) {
            throw InvalidInputException.from(NOT_ALLOWED_EMPTY_CAR_NAME_EXCEPTION);
        }
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw InvalidInputException.from(NOT_OVER_CAR_NAME_LIMIT_EXCEPTION);
        }
        return new Car(name);
    }

    private Car(String name) {
        this.name = name;
    }

    public void moveForward(int number) {
        if (number >= CAR_MOVE_BASIS_NUMBER) {
            position++;
        }
    }

    public boolean inSamePositionWith(int position) {
        return this.position == position;
    }

    public CarSnapShot getCarSnapShot() {
        return CarSnapShot.from(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car))
            return false;
        return ((Car) o).getName().equals(name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}