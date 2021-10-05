package ru.Makval;

import java.util.SplittableRandom;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Client client1 = new Client("Иван", "Иванов", "СБЕР");
        Employee employee1 = new Employee("Сергей", "Сергеев", "ХоумКредит");

        client1.ShowData();
        employee1.ShowData();

        Pyramid pyramid = new Pyramid(12,5);
        System.out.println(pyramid.getVolume());

        Cylinder cylinder = new Cylinder(2,5);
        System.out.println(cylinder.getVolume());

        Ball ball = new Ball(5);
        System.out.println(ball.getVolume());

        Box box = new Box(150);

        System.out.println(box.AddShape(ball));
        System.out.println(box.AddShape(cylinder));
        System.out.println(box.AddShape(pyramid));
    }

    abstract static class Human{
        String name;
        String last_name;

        public Human(String name, String last_name){
            this.name = name;
            this.last_name = last_name;
        }

        public String getName(){
            return name;
        }

        public String getLast_name(){
            return last_name;
        }

        public abstract void ShowData();
    }

    public static class Client extends Human {
        String bank_name;
        public Client(String name, String last_name, String bank_name){
            super(name, last_name);
            this.bank_name = bank_name;
        }

        @Override
        public void ShowData() {
            System.out.println("Имя клиента: " + name + "; фамилия клиента: " + last_name + "; банк: " + bank_name);
        }
    }

    public static class Employee extends Human{
        String bank_name;
        public Employee(String name, String last_name, String bank_name){
            super(name, last_name);
            this.bank_name = bank_name;
        }
        @Override
        public void ShowData() {
            System.out.println("Имя сотрудника: " + name + "; фамилия сотрудника: " + last_name + "; банк: " + bank_name);
        }
    }

    // Реализация иерархии классов

    interface Shape{

        double getVolume();
    }

    public static class Pyramid implements Shape {
        double s;
        double h;

        public Pyramid(double s, double h) {
            this.s = s;
            this.h = h;
        }

        @Override
        public double getVolume(){
            return 1.0/3.0*s*h;
        }

        public void ShowPyramid(){
            System.out.println("Это пирамида!");
        }
    }

    abstract static class SolidOfRevolution implements Shape{
        double radius;

        public SolidOfRevolution(double radius){
            //super(volume);
            this.radius = radius;
        }

        public double getRadius(){
            return radius;
        }
    }

    public static class Cylinder extends SolidOfRevolution{
        double height;

        public Cylinder(double radius, double height){
            super(radius);
            this.height = height;
        }

        @Override
        public double getVolume(){
            return Math.PI*radius*radius*height;
        }
    }

    public static class Ball extends SolidOfRevolution{

        public Ball(double radius) {
            super(radius);
        }

        @Override
        public double getVolume() {
            return 4.0/3.0*Math.PI*radius*radius;
        }
    }

    public static class Box implements Shape{
        double sum_volume = 0;
        double volume;

        public Box(double volume) {
            this.volume = volume;
        }

        @Override
        public double getVolume(){
            return volume;
        }

        public boolean AddShape(Shape shape){
            //System.out.println(shape.volume);
            sum_volume += shape.getVolume();
            return sum_volume < this.volume;
        }
    }
}
