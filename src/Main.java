//Задание 1: Работа с потоками ввода-вывода
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class FileConverter {
//    public static void main(String[] args) {
//        String inputFilePath = "input.txt";
//        String outputFilePath = "output.txt";
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                writer.write(line.toUpperCase());
//                writer.newLine();
//            }
//            System.out.println("Файл успешно преобразован и записан в " + outputFilePath);
//        } catch (IOException e) {
//            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
//        }
//    }
//}
//
//Задание 2: Реализация паттерна Декоратор
//interface TextProcessor {
//    String process(String text);
//}
//
//class SimpleTextProcessor implements TextProcessor {
//    @Override
//    public String process(String text) {
//        return text;
//    }
//}
//
//class UpperCaseDecorator implements TextProcessor {
//    private final TextProcessor processor;
//
//    public UpperCaseDecorator(TextProcessor processor) {
//        this.processor = processor;
//    }
//
//    @Override
//    public String process(String text) {
//        return processor.process(text).toUpperCase();
//    }
//}
//
//class TrimDecorator implements TextProcessor {
//    private final TextProcessor processor;
//
//    public TrimDecorator(TextProcessor processor) {
//        this.processor = processor;
//    }
//
//    @Override
//    public String process(String text) {
//        return processor.process(text).trim();
//    }
//}
//
//class ReplaceDecorator implements TextProcessor {
//    private final TextProcessor processor;
//
//    public ReplaceDecorator(TextProcessor processor) {
//        this.processor = processor;
//    }
//
//    @Override
//    public String process(String text) {
//        return processor.process(text).replace(" ", "_");
//    }
//}
//
//public class DecoratorDemo {
//    public static void main(String[] args) {
//        TextProcessor processor = new SimpleTextProcessor();
//
//        // Комбинируем декораторы
//        TextProcessor decoratedProcessor = new UpperCaseDecorator(
//                new TrimDecorator(
//                        new ReplaceDecorator(processor)
//                )
//        );
//
//        String inputText = "   Пример текста с пробелами   ";
//        String result = decoratedProcessor.process(inputText);
//        System.out.println("Результат: " + result);
//    }
//}
//
//Задание 3: Сравнение производительности IO и NIO
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardOpenOption;
//
//public class PerformanceComparison {
//    public static void main(String[] args) {
//        String inputFilePath = "largeInput.txt";
//        String outputIOFilePath = "outputIO.txt";
//        String outputNIOFilePath = "outputNIO.txt";
//
//        long startTimeIO = System.nanoTime();
//        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(outputIOFilePath))) {
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                writer.write(line);
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        long endTimeIO = System.nanoTime();
//        System.out.println("Время выполнения IO: " + (endTimeIO - startTimeIO) + " наносекунд");
//
//        long startTimeNIO = System.nanoTime();
//        try {
//            Files.copy(Path.of(inputFilePath), Path.of(outputNIOFilePath), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        long endTimeNIO = System.nanoTime();
//        System.out.println("Время выполнения NIO: " + (endTimeNIO - startTimeNIO) + " наносекунд");
//    }
//}
//
//
//
//Задание 4: Программа с использованием Java NIO
//import java.io.IOException;
//import java.nio.channels.FileChannel;
//import java.nio.file.Path;
//import java.nio.file.StandardOpenOption;
//
//public class FileCopyUsingNIO {
//    public static void main(String[] args) {
//        Path sourcePath = Path.of("sourceFile.txt");
//        Path destinationPath = Path.of("destinationFile.txt");
//
//        try (FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
//             FileChannel destinationChannel = FileChannel.open(destinationPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
//
//            long position = 0;
//            long size = sourceChannel.size();
//            while (position < size) {
//                position += sourceChannel.transferTo(position, size - position, destinationChannel);
//            }
//            System.out.println("Файл успешно скопирован.");
//        } catch (IOException e) {
//            System.err.println("Ошибка при копировании файла: " + e.getMessage());
//        }
//    }
//}
//Задание 5: Асинхронное чтение файла с использованием NIO.2
//import java.io.IOException;
//import java.nio.file.*;
//import java.nio.channels.AsynchronousFileChannel;
//import java.nio.ByteBuffer;
//import java.util.concurrent.Future;
//
//public class AsyncFileReadExample {
//    public static void main(String[] args) {
//        Path path = Paths.get("asyncInput.txt");
//
//        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)) {
//            ByteBuffer buffer = ByteBuffer.allocate(1024);
//            Future<Integer> result = fileChannel.read(buffer, 0);
//
//            while (!result.isDone()) {
//            }
//
//            buffer.flip();
//            byte[] data = new byte[buffer.remaining()];
//            buffer.get(data);
//            System.out.println("Содержимое файла: " + new String(data));
//        } catch (IOException e) {
//            System.err.println("Ошибка при чтении файла: " + e.getMessage());
//        }
//    }
//}