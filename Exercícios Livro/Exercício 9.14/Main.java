public class Main {
    public static void main(String[] args){
        Employee employee1 = new Employee("Joao", "Algusto", "321");
        ComissionEmployee employee2 = new ComissionEmployee("Zé", "Silva", "123");
        System.out.println(employee1.toString());
        System.out.println(employee2.toString());
    }
}