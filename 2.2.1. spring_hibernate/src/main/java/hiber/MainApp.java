package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        User user5 = new User("User5", "Lastname5", "user5@mail.ru");
        Car car = new Car("BMW", 5, user5);
        user5.setCar(car);
        userService.add(user5);

        User user6 = new User("User56", "Lastname56", "user5@mail.ru");
        Car car2 = new Car("AUDI", 10, user6);
        user6.setCar(car2);
        userService.add(user6);

        User user7 = new User("User7", "Lastname7", "user7@mail.ru");
        Car car3 = new Car("Mercedes", 20, user7);
        user7.setCar(car3);
        userService.add(user7);

        System.out.println("Владелец машины: " + car.getModel() + " " + car.getSeries() + " " +
                           userService.getUserByCarModelAndSeries(car).getFirstName());

        System.out.println("Владелец машины: " + car2.getModel() + " " + car2.getSeries() + " " +
                           userService.getUserByCarModelAndSeries(car2).getFirstName());

        System.out.println("Владелец машины: " + car3.getModel() + " " + car3.getSeries() + " " +
                           userService.getUserByCarModelAndSeries(car3).getFirstName());


//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

        context.close();
    }
}
