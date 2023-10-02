package Home3;

//Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
//Фамилия Имя Отчество датарождения номертелефона пол
//
//Форматы данных:
//фамилия, имя, отчество - строки
//датарождения - строка формата dd.mm.yyyy
//номертелефона - целое беззнаковое число без форматирования
//пол - символ латиницей f или m.
//
//Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
//
//Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
//
//Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
//
//<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//
//Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//
//Не забудьте закрыть соединение с файлом.
//
//При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String name,lastname,midname,birthday;
        Long phone;
        char gender;

        System.out.println("Введите в одну строку через пробелы без знаков Фамилия_Имя_Отсчетсво_ДеньРождения_номертелефона_символПола");
        String ans = scanner.nextLine();
        String[] parsed = ans.split(" ");
        if (parsed.length == 6){
            lastname = parsed[0];
            name = parsed[1];
            midname = parsed[2];
            birthday = parsed[3];
            try {
                phone = Long.parseLong(parsed[4]);
                gender = parsed[5].toLowerCase().charAt(0);
                if (gender == 'f' || gender == 'm'){
                    File file = new File(lastname);
                    if (file.createNewFile()){
                        try(FileWriter writer = new FileWriter(file)){
                            writer.append(String.format("<%s><%s><%s><%s><%d><%s>",lastname,name,midname,birthday,phone,gender));
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }else{
                        try(FileWriter writer = new FileWriter(file,true)){
                            writer.append(String.format("%n<%s><%s><%s><%s><%d><%s>",lastname,name,midname,birthday,phone,gender));
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                }else {
                    System.out.println("неверно задан пол");
                }
        }catch (NumberFormatException e){
                System.out.println("Неверно задан номер");
            }

        }
        else {
            System.out.println("Введено неверное количество данных");
        }
    }
}
