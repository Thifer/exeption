import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        System.out.println("Введите не пустую строку");
        Scanner in = new Scanner(System.in);
        String res = in.nextLine();
        if (res == null || res.isEmpty()){
            try {
                throw new RuntimeException("Нельзя вводить пустую строку");
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }

    }
}
