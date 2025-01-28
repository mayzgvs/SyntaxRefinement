//Задача 1.
//Создание класса базы данных:
//        Реализуйте класс, который будет представлять подключение к базе данных. Класс должен быть реализован как Singleton, чтобы при каждом обращении возвращался один и тот же объект.
//
//        Требования:
//Класс должен быть Singleton.
//Метод подключения должен выводить сообщение о создании подключения.
//Проверьте, что при создании нескольких экземпляров — они ссылаются на один и тот же объект.
//
//public class DatabaseConnection {
//    private static DatabaseConnection instance;
//
//    private DatabaseConnection() {
//        System.out.println("Создано подключение к базе данных.");
//    }
//
//    public static synchronized DatabaseConnection getInstance() {
//        if (instance == null) {
//            instance = new DatabaseConnection();
//        }
//        return instance;
//    }
//}
//
//Задача 2.
//Логирование в системе:
//Создайте класс для системы логирования, который реализует паттерн Singleton. Класс должен сохранять все сообщения логов в список и предоставлять метод для их вывода.
//
//Требования:
//Класс должен быть Singleton.
//Реализуйте метод для добавления сообщений в логи.
//Реализуйте метод для вывода всех логов.
//
//        import java.util.ArrayList;
//import java.util.List;
//
//public class Logger {
//    private static Logger instance;
//    private List<String> logMessages;
//
//    private Logger() {
//        logMessages = new ArrayList<>();
//    }
//
//    public static synchronized Logger getInstance() {
//        if (instance == null) {
//            instance = new Logger();
//        }
//        return instance;
//    }
//
//    public void log(String message) {
//        logMessages.add(message);
//    }
//
//    public void displayLogs() {
//        for (String message : logMessages) {
//            System.out.println(message);
//        }
//    }
//}
//
//Задача 3.
//Реализация статусов заказа:
//Создайте Enum для статусов заказа в интернет-магазине: NEW, IN_PROGRESS, DELIVERED, CANCELLED. Реализуйте класс Order, который будет хранить информацию о заказе и текущем статусе, а также методы для смены статуса.
//
//Требования:
//Определите Enum для статусов заказа.
//Реализуйте методы в классе Order для изменения и отображения статуса заказа.
//Реализуйте логику проверки переходов статусов, чтобы нельзя было отменить доставленный заказ.
//
//public enum OrderStatus {
//    NEW,
//    IN_PROGRESS,
//    DELIVERED,
//    CANCELLED;
//}
//
//public class Order {
//    private OrderStatus status;
//
//    public Order() {
//        this.status = OrderStatus.NEW;
//    }
//
//    public OrderStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(OrderStatus newStatus) {
//        if (status == OrderStatus.DELIVERED && newStatus == OrderStatus.CANCELLED) {
//            throw new IllegalStateException("Нельзя отменить доставленный заказ.");
//        }
//        this.status = newStatus;
//    }
//}
//
//Задача 4.
//Сезоны года:
//        Создайте Enum, представляющий времена года: WINTER, SPRING, SUMMER, AUTUMN. Затем реализуйте функцию, которая принимает значение этого Enum и возвращает соответствующее название сезона на русском языке.
//
//        Требования:
//Определите Enum для сезонов.
//Реализуйте метод, который принимает сезон и возвращает строку с его названием.
//
//public enum Season {
//    WINTER,
//    SPRING,
//    SUMMER,
//    AUTUMN;
//}
//
//public class SeasonUtil {
//    public static String getSeasonName(Season season) {
//        switch (season) {
//            case WINTER:
//                return "Зима";
//            case SPRING:
//                return "Весна";
//            case SUMMER:
//                return "Лето";
//            case AUTUMN:
//                return "Осень";
//            default:
//                throw new IllegalArgumentException("Неизвестный сезон: " + season);
//        }
//    }
//}

