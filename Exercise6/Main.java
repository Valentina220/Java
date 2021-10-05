package ru.Makval;

import java.time.Year;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Study st = new Study("Изучение Java - это просто!");
        String str = st.printCourse();
        System.out.println(str);

        House house1 = new House();
        House house2 = new House();

        house1.setData(12, 1968, "Звезда");
        house2.setData(25, 2015, "Человейник");

        house1.GetData();
        house2.GetData();

        Tree tree1 = new Tree(115, "Баобаб");
        tree1.ShowTree();

        Tree tree2 = new Tree(15, true, "сосна");
        tree2.ShowTree();

        Tree tree3 = new Tree();

        Aircraft.Wing wing1 = new  Aircraft().new Wing();
        Aircraft.Wing wing2 = new Aircraft().new Wing();

        wing1.SetWeight(350.5);
        System.out.println(wing1.GetWeight());

        wing2.SetWeight(240.8);
        System.out.println(wing2.GetWeight());
    }

    static class Study {

        private String course;

        public Study(String course_name){
            this.course = course_name;
        }

        public String printCourse() {
            return this.course;
        }
    }

    static class House{
        int floors;
        int build_year;
        String house_name;

        public void setData(int floors, int build_year, String house_name){
            this.floors = floors;
            this.build_year = build_year;
            this.house_name = house_name;
        }

        public int getHouseAge(){
            int year = Year.now().getValue();
            return  year - build_year;
        }

        public void GetData(){
            int house_age = getHouseAge();
            System.out.println("Кол-во этажей в доме: " + floors + "\n" + "Год постройки: " + build_year +
                    "\n" + "Название объекта: " + house_name + "\n" + "Дому " + house_age + " лет");
        }
    }

    static class Tree{
        int age;
        boolean alive;
        String tree_name;

        public Tree(int age, String tree_name){
            this.age = age;
            this.tree_name = tree_name;
        }

        public Tree(int age, boolean alive, String tree_name){
            this.age = age;
            this.alive = alive;
            this.tree_name = tree_name;
        }

        public Tree(){
            System.out.println("Пустой конструктор без параметров сработал");
        }

        public void ShowTree(){
            System.out.println("Возраст дерева: " + age + "\n" + "Дерево живое: " + alive + "\n" + "Название дерева: " + tree_name);
        }
    }

    static class Aircraft{
        class Wing{
            double wing_weight;

            public void SetWeight(double wing_weight){
                this.wing_weight = wing_weight;
            }

            public double GetWeight(){
                return wing_weight;
            }
        }

    }
}
