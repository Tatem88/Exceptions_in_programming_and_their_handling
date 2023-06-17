package DZ_3;
/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
Фамилия Имя Отчество дата рождения номер телефона пол
Форматы данных:
фамилия, имя, отчество - строки
дата рождения - строка формата dd.mm.yyyy
номер телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.
Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, бросить исключение,
обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
<Фамилия><Имя><Отчество><дата рождения> <номер телефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен
увидеть стектрейс ошибки.
Данная промежуточная аттестация оценивается по системе "зачет" / "не зачет"
"Зачет" ставится, если слушатель успешно выполнил
"Незачет"" ставится, если слушатель успешно выполнил
Критерии оценивания:
Слушатель напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
разделенные пробелов
 */
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Task_1 {
    private static final int REQUIRED_ARGS_COUNT = 6;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    public static void main(String[] args) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите данные (ФИО датa_рождения номер_телефона пол):");
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                if (parts.length != REQUIRED_ARGS_COUNT) {
                    throw new IllegalArgumentException("Неверное количество аргументов");
                }
                String surname = parts[0];
                String name = parts[1];
                String patronymic = parts[2];
                Date birthDate = parseBirthDate(parts[3]);
                Long phoneNumber = Long.valueOf(parts[4]);
                Gender gender = parseGender(parts[5]);
                String fileName = surname + ".txt";
                String fileContent = surname + name + patronymic + formatDate(birthDate) + " " + phoneNumber + gender.getCode() + "\n";
                FileWriter writer = new FileWriter(fileName, true);
                writer.write(fileContent);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static Date parseBirthDate(String input) throws ParseException {
            try {
                return DATE_FORMAT.parse(input);
            } catch (ParseException e) {
                throw new ParseException("Неверный формат даты рождения", e.getErrorOffset());
            }
        }

        private static Gender parseGender(String input) {
            switch (input) {
                case "m":
                    return Gender.Male;
                case "f":
                    return Gender.Female;
                default:
                    throw new IllegalArgumentException("Некорректно введен пол");
            }
        }
        private static String formatDate(Date date) {
            return DATE_FORMAT.format(date);
        }
    }
    enum Gender {
        Male("m"),
        Female("f");
        private final String code;
        Gender(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }