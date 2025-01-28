//1. Основы LocalDate и LocalTime
//        Задача: Напишите программу, которая:
//        Создает объект LocalDate, представляющий текущую дату.
//        Создает объект LocalTime, представляющий текущее время.
//        Выводит их значения в формате dd-MM-yyyy HH:mm:ss
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//
//public class DateTimeExample {
//    public static void main(String[] args) {
//        LocalDate currentDate = LocalDate.now();
//        LocalTime currentTime = LocalTime.now();
//
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//
//        String formattedDate = currentDate.format(dateFormatter);
//        String formattedTime = currentTime.format(timeFormatter);
//
//        System.out.println("Текущая дата: " + formattedDate);
//        System.out.println("Текущее время: " + formattedTime);
//    }
//}
//
//
//
//2. Сравнение дат
//Задача: Напишите метод, который принимает две даты (LocalDate) и определяет, какая из них больше, меньше или равна другой. Верните соответствующее сообщение.
//
//import java.time.LocalDate;
//
//public class DateComparison {
//    public static String compareDates(LocalDate date1, LocalDate date2) {
//        if (date1.isEqual(date2)) {
//            return "Даты равны.";
//        } else if (date1.isBefore(date2)) {
//            return "Первая дата меньше второй.";
//        } else {
//            return "Первая дата больше второй.";
//        }
//    }
//
//    public static void main(String[] args) {
//        LocalDate date1 = LocalDate.of(2023, 5, 15);
//        LocalDate date2 = LocalDate.of(2023, 8, 20);
//
//        String result = compareDates(date1, date2);
//        System.out.println(result);
//    }
//}
//
//
//
//3. Сколько дней до Нового года?
//Задача: Создайте метод, который определяет количество дней до Нового года от текущей даты.
//
//import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;
//
//public class DaysUntilNewYear {
//    public static long daysUntilNewYear() {
//        LocalDate today = LocalDate.now();
//        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);
//
//        return ChronoUnit.DAYS.between(today, newYear);
//    }
//
//    public static void main(String[] args) {
//        long days = daysUntilNewYear();
//        System.out.println("Дней до Нового года: " + days);
//    }
//}
//
//4. Проверка високосного года
//Задача: Реализуйте метод, который принимает год и возвращает true, если он является високосным, и false в противном случае.
//
//public class LeapYearChecker {
//    public static boolean isLeapYear(int year) {
//        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
//    }
//
//    public static void main(String[] args) {
//        int year = 2024; // Пример года для проверки
//        boolean leapYear = isLeapYear(year);
//
//        if (leapYear) {
//            System.out.println(year + " является високосным годом.");
//        } else {
//            System.out.println(year + " не является високосным годом.");
//        }
//    }
//}
//
//5. Подсчет выходных за месяц
//Задача: Напишите метод, который принимает месяц и год и возвращает количество выходных (суббот и воскресений) в этом месяце.
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.time.Month;
//
//public class WeekendCounter {
//    public static int countWeekends(int year, Month month) {
//        int weekends = 0;
//        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
//        LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());
//
//        for (LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
//            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
//                weekends++;
//            }
//        }
//        return weekends;
//    }
//
//    public static void main(String[] args) {
//        int year = 2023;
//        Month month = Month.APRIL;
//        int weekendCount = countWeekends(year, month);
//        System.out.println("Количество выходных в " + month + " " + year + ": " + weekendCount);
//    }
//}
//
//
//
//6. Расчет времени выполнения метода
//Задача: Реализуйте метод, который измеряет время выполнения другого метода (например, цикла из 1 миллиона итераций).
//
//public class ExecutionTimeCalculator {
//    public static void main(String[] args) {
//        long executionTime = measureExecutionTime(ExecutionTimeCalculator::sampleMethod);
//        System.out.println("Время выполнения метода: " + executionTime + " миллисекунд");
//    }
//
//    public static long measureExecutionTime(Runnable method) {
//        long startTime = System.currentTimeMillis();
//        method.run();
//        long endTime = System.currentTimeMillis();
//        return endTime - startTime;
//    }
//
//    public static void sampleMethod() {
//        // Пример метода с миллионом итераций
//        for (int i = 0; i < 1_000_000; i++) {
//            // Просто пустая итерация
//        }
//    }
//}
//
//
//
//7. Форматирование и парсинг даты
//Задача: Напишите программу, которая принимает строку даты в формате dd-MM-yyyy, конвертирует ее в объект LocalDate, добавляет к ней 10 дней и выводит результат в формате yyyy/MM/dd.
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//public class DateFormatter {
//    public static void main(String[] args) {
//        String dateString = "15-11-2023"; // Пример входной строки
//        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//        LocalDate newDate = date.plusDays(10);
//
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        String formattedDate = newDate.format(outputFormatter);
//
//        System.out.println("Дата через 10 дней: " + formattedDate);
//    }
//}
//
//
//
//8. Конвертация между часовыми поясами
//Задача: Напишите метод, который принимает дату и время в часовом поясе UTC и конвертирует его в другой часовой пояс, например, Europe/Moscow.
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//
//public class TimeZoneConverter {
//    public static ZonedDateTime convertToTimeZone(Instant instant, String targetZoneId) {
//        return ZonedDateTime.ofInstant(instant, ZoneId.of(targetZoneId));
//    }
//
//    public static void main(String[] args) {
//        Instant utcInstant = Instant.now(); // Текущая дата и время в UTC
//        ZonedDateTime moscowTime = convertToTimeZone(utcInstant, "Europe/Moscow");
//
//        System.out.println("Время в UTC: " + utcInstant);
//        System.out.println("Время в Москве: " + moscowTime);
//    }
//}
//
//
//
//9. Вычисление возраста по дате рождения
//Задача: Напишите метод, который принимает дату рождения в формате LocalDate и возвращает текущий возраст в годах.
//
//        import java.time.LocalDate;
//import java.time.Period;
//
//public class AgeCalculator {
//    public static int calculateAge(LocalDate birthDate) {
//        LocalDate currentDate = LocalDate.now();
//        return Period.between(birthDate, currentDate).getYears();
//    }
//
//    public static void main(String[] args) {
//        LocalDate birthDate = LocalDate.of(1990, 5, 15); // Пример даты рождения
//        int age = calculateAge(birthDate);
//        System.out.println("Возраст: " + age + " лет");
//    }
//}
//
//
//
//10. Создание календаря на месяц
//Задача: Напишите метод, который принимает месяц и год и выводит все даты месяца с указанием, является ли каждая из них рабочим днем или выходным.
//
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.time.Month;
//
//public class MonthlyCalendar {
//    public static void printCalendar(int year, Month month) {
//        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
//        int lengthOfMonth = firstDayOfMonth.lengthOfMonth();
//
//        for (int day = 1; day <= lengthOfMonth; day++) {
//            LocalDate date = LocalDate.of(year, month, day);
//            DayOfWeek dayOfWeek = date.getDayOfWeek();
//            String typeOfDay = (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) ? "Выходной" : "Рабочий день";
//            System.out.println(date + " - " + typeOfDay);
//        }
//    }
//
//    public static void main(String[] args) {
//        int year = 2023;
//        Month month = Month.APRIL; // Пример: апрель 2023 года
//        printCalendar(year, month);
//    }
//}
//
//
//
//11. Генерация случайной даты в диапазоне
//Задача: Реализуйте метод, который принимает две даты и генерирует случайную дату в этом диапазоне.
//
//        import java.time.LocalDate;
//import java.util.concurrent.ThreadLocalRandom;
//
//public class RandomDateGenerator {
//    public static LocalDate generateRandomDate(LocalDate startDate, LocalDate endDate) {
//        long startEpochDay = startDate.toEpochDay();
//        long endEpochDay = endDate.toEpochDay();
//        long randomEpochDay = ThreadLocalRandom.current().longs(startEpochDay, endEpochDay + 1).findFirst().getAsLong();
//        return LocalDate.ofEpochDay(randomEpochDay);
//    }
//
//    public static void main(String[] args) {
//        LocalDate startDate = LocalDate.of(2020, 1, 1);
//        LocalDate endDate = LocalDate.of(2023, 12, 31);
//        LocalDate randomDate = generateRandomDate(startDate, endDate);
//        System.out.println("Случайная дата: " + randomDate);
//    }
//}
//
//
//
//12. Расчет времени до заданной даты
//Задача: Создайте метод, который принимает дату и время события и рассчитывает, сколько часов, минут и секунд осталось до него от текущего момента.
//
//        import java.time.Duration;
//import java.time.LocalDateTime;
//
//public class TimeUntilEvent {
//    public static String timeUntilEvent(LocalDateTime eventTime) {
//        Duration duration = Duration.between(LocalDateTime.now(), eventTime);
//        long hours = duration.toHours();
//        long minutes = duration.toMinutes() % 60;
//        long seconds = duration.getSeconds() % 60;
//
//        return String.format("%d часов, %d минут и %d секунд", hours, minutes, seconds);
//    }
//
//    public static void main(String[] args) {
//        LocalDateTime eventTime = LocalDateTime.of(2023, 12, 31, 23, 59); // Пример времени события
//        String timeRemaining = timeUntilEvent(eventTime);
//        System.out.println("Время до события: " + timeRemaining);
//    }
//}
//
//
//
//13. Вычисление количества рабочих часов
//Задача: Напишите метод, который принимает два объекта LocalDateTime, представляющие начало и конец рабочего дня, и возвращает количество рабочих часов (без учета выходных).
//
//        import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;
//
//public class WorkingHoursCalculator {
//    public static long calculateWorkingHours(LocalDateTime start, LocalDateTime end) {
//        if (start.isAfter(end)) {
//            return 0; // Если начало позже конца, возвращаем 0
//        }
//
//        long totalHours = 0;
//        LocalDateTime current = start;
//
//        while (current.isBefore(end)) {
//            // Проверяем, является ли текущий день рабочим
//            if (current.getDayOfWeek().getValue() < 6) { // Пн-Пт = 1-5
//                // Учитываем только рабочие часы (например, с 9 до 18)
//                LocalDateTime workStart = current.withHour(9).withMinute(0).withSecond(0);
//                LocalDateTime workEnd = current.withHour(18).withMinute(0).withSecond(0);
//
//                // Корректируем начало и конец рабочего дня
//                if (current.isBefore(workStart)) {
//                    current = workStart;
//                }
//
//                if (end.isBefore(workEnd)) {
//                    workEnd = end;
//                }
//
//                if (current.isBefore(workEnd)) {
//                    totalHours += ChronoUnit.HOURS.between(current, workEnd);
//                }
//            }
//            current = current.plusDays(1).withHour(0).withMinute(0).withSecond(0);
//        }
//
//        return totalHours;
//    }
//
//    public static void main(String[] args) {
//        LocalDateTime start = LocalDateTime.of(2023, 10, 23, 10, 0); // Начало рабочего дня
//        LocalDateTime end = LocalDateTime.of(2023, 10, 25, 15, 0); // Конец рабочего дня
//        long workingHours = calculateWorkingHours(start, end);
//        System.out.println("Количество рабочих часов: " + workingHours);
//    }
//}
//
//
//
//14. Конвертация даты в строку с учетом локали
//Задача: Создайте метод, который принимает объект LocalDate и выводит его в строковом формате с учетом локали, например, ru или en.
//
//        import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Locale;
//
//public class DateFormatter {
//    public static String formatDate(LocalDate date, String localeCode) {
//        Locale locale = new Locale(localeCode);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", locale);
//        return date.format(formatter);
//    }
//
//    public static void main(String[] args) {
//        LocalDate date = LocalDate.of(2023, 10, 23); // Пример даты
//        String formattedDateRu = formatDate(date, "ru");
//        String formattedDateEn = formatDate(date, "en");
//
//        System.out.println("Форматированная дата (RU): " + formattedDateRu);
//        System.out.println("Форматированная дата (EN): " + formattedDateEn);
//    }
//}
//
//
//
//15. Определение дня недели по дате
//Задача: Напишите метод, который принимает дату и возвращает название дня недели на русском языке.
//
//        import java.time.LocalDate;
//import java.time.format.TextStyle;
//import java.util.Locale;
//
//public class DayOfWeekFinder {
//    public static String getDayOfWeekInRussian(LocalDate date) {
//        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("ru"));
//    }
//
//    public static void main(String[] args) {
//        LocalDate date = LocalDate.of(2023, 10, 23); // Пример даты
//        String dayOfWeek = getDayOfWeekInRussian(date);
//        System.out.println("День недели: " + dayOfWeek);
//    }
//}
//
