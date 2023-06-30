import java.util.*;

public class Catalog {    

    private String name; //название
    private Integer ram; //объем оперативной памяти
    private Integer hd; //объем жесткого диска
    private String os; // операционная система
    private String color; //цвет

    //сеттеры-геттеры
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setRam(Integer ram) {
        this.ram = ram;
    }
    public Integer getRam() {
        return ram;
    }
    public void setHd(Integer hd) {
        this.hd = hd;
    }
    public Integer getHd() {
        return hd;
    }
    public void setOs(String os) {
        this.os = os;
    }
    public String getOs() {
        return os;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    // конструктор
    public Catalog (String name, Integer ram, Integer hd, String os, String color){
        this.name = name;
        this.ram = ram;
        this.hd = hd;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return name + "; " +
                "ОЗУ:" + ram +  "; " +
                "Диск: " + hd + "; " +
                "ОС: " + os + "; " +
                "цвет:" + color + "; ";
    }
    
    
}