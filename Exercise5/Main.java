package ru.Makval;

import java.util.Arrays;
import java.util.Scanner;

import static ru.Makval.Main.Vector.Random_vectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        Vector v1 = new Vector(3,4,5);
        Vector v2 = new Vector (4,5,6);
        //System.out.println("x: " + v1.x + ", y: " + v1.y + ", z: " + v1.z);

        double l1 = v1.Lenght_ofVector();
        double l2 = v2.Lenght_ofVector();
        System.out.println("Длина первого вектора: " + l1 + "\n" + "Длина второго вектора: " + l2);

        double s = v1.Scalar_multiplic(v2);
        System.out.println("Скалярное произведение векторов: " + s);

        Vector v3 = v1.Vector_multiplic(v2);
        //System.out.println("x: " + v3.x + ", y: " + v3.y + ", z: " + v3.z);
        v3.PrintVector();

        double cos = v1.Cosine(v2);
        System.out.println("Косинус между векторами: " + cos);

        Vector v4 = v1.Add_vectors(v2);
        Vector v5 = v1.Sutr_vectors(v2);

        System.out.println("Сумма двух векторов: " + "x: " + v4.x + ", y: " + v4.y + ", z: " + v4.z);
        System.out.println("Разность двух векторов: " + "x: " + v5.x + ", y: " + v5.y + ", z: " + v5.z);

        System.out.println("Введите размер массива n: ");
        int n = scanner.nextInt();

        Random_vectors(n);
    }

    static class Vector {
        double x, y, z;

        public Vector(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double Lenght_ofVector() {
            return Math.sqrt(x * x + y * y + z * z);
            //return l;
        }

        public double Scalar_multiplic(Vector v) {
            return this.x * v.x + this.y * v.y + this.z * v.z;
            //return s;
        }

        public Vector Vector_multiplic(Vector v) {
            double new_x = this.y * v.z - this.z * v.y;
            double new_y = this.z * v.x - this.x * v.z;
            double new_z = this.x * v.y - this.y * v.x;
            Vector vec = new Vector(new_x, new_y, new_z);
            return vec;
        }

       public double Cosine(Vector v){
            double l1 = Lenght_ofVector();
            double l2 = v.Lenght_ofVector();
            double s = Scalar_multiplic(v);
            return  s / (l1 * l2 );
            //return cos;
        }

        public Vector Add_vectors(Vector v){
            double new_x = this.x + v.x ;
            double new_y = this.y + v.y ;
            double new_z = this.z + v.z ;
            Vector vec = new Vector(new_x, new_y, new_z);
            return vec;
        }

        public Vector Sutr_vectors(Vector v){
            double new_x = this.x - v.x ;
            double new_y = this.y - v.y ;
            double new_z = this.z - v.z ;
            Vector vec = new Vector(new_x, new_y, new_z);
            return vec;
        }

        public static void Random_vectors(int n){
            Vector[] vector = new Vector[n];
            for(int i = 0; i < n; i++){
                vector[i] = new Vector(i+2, (i+1)*2-1, (i+1)*2);
            }
            for(int i = 0; i < n; i++){
                System.out.println("Вектор" + (i+1) + ": ");
                vector[i].PrintVector();
            }
        }

        public void PrintVector(){
            System.out.println("(" + x + "; " + y + "; " + z + ")");
        }
    }
}
