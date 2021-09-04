public class day01 {
    public static void main(String[] args) {
        String[] arr = {"ac", "bd", "ct", "de", "e", "f", "g", "hz", "t", "l"};
        for (int i = 2; i < arr.length; i = i + 3) {
            if (!arr[i].equals("t") && arr[i].contains("t")) {
                System.out.println("Value not allowed");
            } else {
                System.out.println(arr[i]);
            }
        }
    }
}