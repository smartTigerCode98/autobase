package model;

public class Flight {
    private int id;
    private int id_order;
    private int id_driver;
    private boolean status;

    public Flight(int id, int id_order, int id_driver, boolean status) {
        this.id = id;
        this.id_order = id_order;
        this.id_driver = id_driver;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrder() {
        return id_order;
    }

    public void setIdOrder(int id_order) {
        this.id_order = id_order;
    }

    public int getIdDriver() {
        return id_driver;
    }

    public void setIdDriver(int id_driver) {
        this.id_driver = id_driver;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
