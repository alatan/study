public class Test {
    public static void main(String[] args) {
        String a = "7";
        String b = "10";

        if(a.compareTo(b) > 0){
            System.out.println("String - error");
        }
        Double adtnLnSingleLmtVal = Double.valueOf(a);
        Double adtnLnTotLmtVal = Double.valueOf(b);
        if(adtnLnSingleLmtVal.compareTo(adtnLnTotLmtVal) < 0){
            System.out.println("Double - error");
        }
    }
}
