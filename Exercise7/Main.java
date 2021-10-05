package ru.Makval;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Truck truck = new Truck(3000, "AD203", 'b', 90, 8, 3600);
        truck.outPut();

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

    public static class Car {
        public int weight;
        public String model;
        public char color;
        public float speed;


        public void outPut () {
            System.out.println("Вес " + model + " составляет " + weight + "кг.");
            System.out.println("Цвет машины - " + color + " и её скорость - " + speed);
        }

        public Car (int w, String m, char c, float s) {
            weight = w;
            model = m;
            color = c;
            speed = s;
        }

        public Car () {}
    }

    public static class Truck extends Car{
        int wheels_numb;
        int max_weight;

        public Truck(int w, String m, char c, float s, int wheels_numb, int max_weight){
            super(w,m,c,s);
            this.wheels_numb = wheels_numb;
            this.max_weight = max_weight;
        }

        public void NewWheels(int new_wheels){
            wheels_numb = new_wheels;
            System.out.println("Новое кол-во колес: " + wheels_numb);
        }

        @Override
        public void outPut () {
            System.out.println("Вес " + model + " составляет " + weight + "кг.");
            System.out.println("Цвет машины - " + color + " и её скорость - " + speed);
            System.out.println("Кол-во колес: " + wheels_numb + ", максимальный вес: " + max_weight);
        }
    }

    // Реализация иерархии классов

    public static class Shape{
        double volume;

        public Shape(double volume){
            this.volume = volume;
        };

        public double getVolume(){
            return volume;
        }
    }

    public static class Pyramid extends Shape{
        double s;
        double h;

        public Pyramid(double s, double h) {
            super(1.0/3.0*s*h);
            this.s = s;
            this.h = h;
        }

        public void ShowPyramid(){
            System.out.println("Это пирамида!");
        }
    }

    public static class SolidOfRevolution extends Shape{
        double radius;

        public SolidOfRevolution(double volume, double radius){
            super(volume);
            this.radius = radius;
        }

        public double getRadius(){
            return radius;
        }
    }

    public static class Cylinder extends SolidOfRevolution{
        double height;

        public Cylinder(double radius, double height){
            super(Math.PI*radius*radius*height, radius);
            this.height = height;
        }
    }

    public static class Ball extends SolidOfRevolution{

        public Ball(double radius) {
            super(4.0/3.0*Math.PI*radius*radius, radius);
        }
    }

    public static class Box extends Shape{
        double sum_volume = 0;

        public Box(double volume) {
            super(volume);
        }

        public boolean AddShape(Shape shape){
            //System.out.println(shape.volume);
            sum_volume += shape.volume;
            return sum_volume < this.volume;
        }
    }
}

