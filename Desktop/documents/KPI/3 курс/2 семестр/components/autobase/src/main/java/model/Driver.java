package model;

public class Driver {
    private int id;
    private  String name;
    private String surname;
    private int id_car;
    private boolean is_free;


    public Driver(int id, String name, String surname, int id_car, boolean is_free){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.id_car = id_car;
        this.is_free = is_free;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIdCar() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public boolean isFree() {
        return is_free;
    }

    public void setIsFree(boolean is_free) {
        this.is_free = is_free;
    }
}
