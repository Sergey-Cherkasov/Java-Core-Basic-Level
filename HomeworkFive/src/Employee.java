public class Employee {
   private String firstName;  // Имя
   private String lastName;   // Фамилия
   private String patronymic; // Отчество
   private int age;           // Возраст
   private String phone;      // Телефон
   private String eMail;      // Email
   private String position;   // Должность
   private double salary;     // Зарплата

   public Employee(String firstName, String lastName, String patronymic, int age, String phone, String eMail,
                   String position, double salary){
      this.firstName = firstName;
      this.lastName = lastName;
      this.patronymic = patronymic;
      this.age = age;
      this.phone = phone;
      this.eMail = eMail;
      this.position = position;
      this.salary = salary;
   }

   public void printEmployeeInfo(){
      System.out.println(lastName + "\t" + firstName + "\t" + patronymic + "\n"
      + "Age: " + age + "\n" + "Phone number: " + phone + "\tEmail: " + eMail + "\n"
      + "Position: " + position + "\tSalary: " + salary);
   }

   @Override
   public String toString(){
     return "Name: " + lastName + "\t" + firstName + "\t" + patronymic + "\n"
              + "Age: " + age + "\n" + "Phone number: " + phone + "\tEmail: " + eMail + "\n"
              + "Position: " + position + "\tSalary: " + salary;
   }

   public int getAge() {
      return age;
   }

}
