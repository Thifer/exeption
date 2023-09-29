import java.io.*;

//Задание 4 из презентации
class task1 {
    public static void main(String[] args) {

        try {
            String[] strings = {"asdf", "asdf" };
            String strings1 = strings[strings.length-1];
            test();
            //int a = 1 / 0;

            try  (InputStream inputStream = new FileInputStream("sdafgsaf");)   {
                System.out.println("YAAAY");
            }catch (FileNotFoundException e){
                System.out.println("Такого файла нет");
            }


        } catch (StackOverflowError error) {
            System.out.println("asdfasdfdsa");
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("Я все равно выполнился!");
        }
        System.out.println("Я жив!");
    }

    public static void test() throws IOException {
        File file = new File("1");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        reader.read();
    }

}