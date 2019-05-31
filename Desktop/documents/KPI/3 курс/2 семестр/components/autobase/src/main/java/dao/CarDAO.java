package dao;

import model.Car;

import java.util.List;

public interface CarDAO {
    List<Car> findCarsByOrder(String mark, String body_type, String number_of_seats);
    boolean updateConditionCar(int id, boolean is_broke);
}
