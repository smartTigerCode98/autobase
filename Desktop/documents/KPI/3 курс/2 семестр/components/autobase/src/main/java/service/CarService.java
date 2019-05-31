package service;

import dao.CarImplDAO;
import model.Car;

import java.util.List;

public class CarService {

    private static CarService carService = null;

    private CarImplDAO carImplDAO;

    public static CarService getCarService(){
        if(carService == null){
            carService = new CarService();
        }

        return carService;
    }

    private CarService(){
        carImplDAO = new CarImplDAO();
    }


    public List<Car> findCarsByOrder(String mark, String bodyType, String countOfSits){
        return  carImplDAO.findCarsByOrder(mark, bodyType, countOfSits);
    }

    public boolean updateStatusCar(int idCar, boolean status){
        return this.carImplDAO.updateConditionCar(idCar, status);
    }

}
