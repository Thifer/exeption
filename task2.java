public class task2 {
    public static void main(String[] args) {
        try {
            int d = 0;
            double catchedRes1;
            int[] intArray = new int[10];
            if ( d!=0 && intArray.length>8)  {

                catchedRes1 = intArray[8] / d;
            }
            else {
                catchedRes1 = 0;
            }
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }
}
