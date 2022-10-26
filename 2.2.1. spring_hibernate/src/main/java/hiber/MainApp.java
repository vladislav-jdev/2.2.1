package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;


public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);

      //создать авто
      Car car1 = new Car("Mercedes", 55555);
      Car car2 = new Car("BMW", 2425);
      Car car3 = new Car("Ford", 111111);
      Car car4 = new Car("Nissan", 1234567);

      //добавить юзеров в бд
      userService.add(new User("Владимир", "Петров", "petrov@mail.ru", car1));
      userService.add(new User("Александр", "Иванов", "semenov@mail.ru", car2));
      userService.add(new User("Алексей", "Кузнецов", "kuznetsov2@mail.ru", car3));
      userService.add(new User("Николай", "Смирнов", "smirnov@mail.ru", car4));

      //Получить юзера по авто
      System.out.println("\n" + userService.getUserByCar(car3));

      //Получить всех юзеров
      //List<User> users = userService.listUsers();
      //for (User user : users) {
      //   System.out.println("Id = "+user.getId());
      //   System.out.println("First Name = "+user.getFirstName());
      //   System.out.println("Last Name = "+user.getLastName());
      //   System.out.println("Email = "+user.getEmail());
      //   System.out.println("Car model = "+user.getCar().getModel());
      //   System.out.println("Car series = "+user.getCar().getSeries());
      //   System.out.println();
      //}
      context.close();
   }
}
