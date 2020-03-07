public class Main {

   public static void main(String[] args) {

      Employee[] employees = new Employee[5];

      employees[0] = new Employee("Иван","Иванов","Иванович",41,"+71234567890",
              "ivanov@mailbox.com","Team leader", 135720.00);
      employees[1] = new Employee("Иван","Петров","Николаевич",25,
              "+72345678901","petrov@mailbox.com","Back-end разработчик", 76908.00);
      employees[2] = new Employee("Sidor","Sidorov","Ivanovich",43,
              "+73456789012","sidorov@mailbox.com","Project manager",169650.00);
      employees[3] = new Employee("John","Lawson","junior",37,"+534567890123",
              "lawson@mailbox.com","Front-end developer",75777.00);
      employees[4] = new Employee("Jack","Denials","",33,"+445678901234",
              "j.denials@mailbox.com","designer",73515.00);

      for (Employee employee : employees) {
         if (employee.getAge() > 40) {
            employee.printEmployeeInfo();
            System.out.println();
         }
      }

   }

}
