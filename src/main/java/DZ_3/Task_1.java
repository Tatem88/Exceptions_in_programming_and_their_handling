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
import java.io.*;


public class Task_1 {
    private static String[] date_phone = new String[11];
    public static void main(String[] args) throws IOException {
        String act;
        load_date_phone();
        Printbook();

        System.out.println("выбор действия:  добавить данные (add),  удалить данные (del)," +
                "  показать данные (show),  выход (exit)");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        act = bf.readLine();
        while(!act.equals("exit")){
            if(act.equals("add")){
                System.out.println("Введите фамилию:");
                String first_name = bf.readLine();
                System.out.println("Введите имя:");
                String second_name = bf.readLine();
                System.out.println("Введите отчество:");
                String Third_name = bf.readLine();
                System.out.println("Введите дату рождения (dd.mm.yyyy):");
                String birthdate = bf.readLine();
                System.out.println("Введите телефон:");
                String phone = bf.readLine();
                System.out.println("Введите пол (f/m):");
                String pol = bf.readLine();
                add_date_phone(first_name, second_name, Third_name, birthdate, phone, pol);
            }else{
                if(act.equals("del")){
                    for (int i = 0; i < date_phone.length; i++) {
                        date_phone[i]="";
                    }
                }else{
                    if(act.equals("show")){
                        Printbook();
                    }
                }
            }
            System.out.println("выбор действия: (add)добавить данные, (del)удалить данные, (show)показать данные, (exit)выход");
            act = bf.readLine();
        }
    }

    public static void load_date_phone() throws IOException {
        File file = new File("book.txt");
        if (file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(new File("book.txt")));
            String act;
            while ((act = reader.readLine())!=null) {
                String dat = " ";
                date_phone[0]=dat;
                date_phone[1]=dat;
                date_phone[2]=dat;
                date_phone[3]=dat;
                date_phone[4]=dat;
                date_phone[5]=dat;
            }
            reader.close();
        }
    }


    public static void Printbook(){
        System.out.println("Cправочник: ");
        for (int i = 0; i < date_phone.length; i++) {
            System.out.println(date_phone[i]);;
        }
    }


    private static void add_date_phone(String first_name, String second_name, String Third_name, String birthdate,
                                     String phone, String pol) {
        date_phone[0]=first_name;
        date_phone[1]=second_name;
        date_phone[2]=Third_name;
        date_phone[3]=birthdate;
        date_phone[4]=phone;
        date_phone[5]=pol;
    }
}