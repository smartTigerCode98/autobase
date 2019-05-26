package dao;

import model.Car;

import java.util.ArrayList;

public interface CarDAO {
    public ArrayList<Car> findCarsByCriteria(String marka, String body_type, String number_of_seats);
    public boolean updateConditionCar(int id, boolean is_broke);
}
