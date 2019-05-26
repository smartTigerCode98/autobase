package model;

import java.util.Date;

public class Order {
    private int id;
    private Date when;
    private String from_where;
    private String where_;
    private String mark_auto;
    private String body_type;
    private int count_of_sits;
    private boolean processed;

    public Order(int id, Date when, String from_where, String where_, String mark_auto, String body_type, int count_of_sits, boolean processed) {
        this.id = id;
        this.when = when;
        this.from_where = from_where;
        this.where_ = where_;
        this.mark_auto = mark_auto;
        this.body_type = body_type;
        this.count_of_sits = count_of_sits;
        this.processed = processed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public String getFromWhere() {
        return from_where;
    }

    public void setFromWhere(String from_where) {
        this.from_where = from_where;
    }

    public String getWhere_() {
        return where_;
    }

    public void setWhere_(String where_) {
        this.where_ = where_;
    }

    public String getMarkAuto() {
        return mark_auto;
    }

    public void setMarkAuto(String mark_auto) {
        this.mark_auto = mark_auto;
    }

    public String getBodyType() {
        return body_type;
    }

    public void setBodyType(String body_type) {
        this.body_type = body_type;
    }

    public int getCountOfSits() {
        return count_of_sits;
    }

    public void setCountOfSits(int count_of_sits) {
        this.count_of_sits = count_of_sits;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}
