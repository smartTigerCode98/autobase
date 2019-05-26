package model;

public class Car {
    private int id;
    private String marka;
    private String type;
    private String serial_number;
    private int number_of_seats;
    private boolean is_broke;

    public Car(int id, String marka, String type, String serial_number, int number_of_seats, boolean is_broke) {
        this.id = id;
        this.marka = marka;
        this.type = type;
        this.serial_number = serial_number;
        this.number_of_seats = number_of_seats;
        this.is_broke = is_broke;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serial_number;
    }

    public void setSerialNumber(String serial_number) {
        this.serial_number = serial_number;
    }

    public int getNumberOfSeats() {
        return number_of_seats;
    }

    public void setNumberOfSeats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public boolean getIsBroke() {
        return is_broke;
    }

    public void setIsBroke(boolean is_broke) {
        this.is_broke = is_broke;
    }
}
