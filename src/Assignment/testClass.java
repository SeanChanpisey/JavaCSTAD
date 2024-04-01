package Assignment;


     class Person{
        String name="Pisey";
        String gen="M";
        int age=21;
        void show(){
            System.out.println("Name: "+name);
            System.out.println("Gender: "+gen);
            System.out.println("Age: "+age);
        }

         public static void main(String[] args) {
             Person p =new Person();
             p.show();
         }
    }



