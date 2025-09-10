import java.util.UUID;

public class Example {
    public static void main(String[] args) {
//        String email = "John" + UUID.randomUUID();
//        String newEmail = email.replace("-", "");
//        System.out.println(newEmail);

        String s = "//table/tbody//tr[%d]/td[%d]";
        String b = String.format(s, 1, 2);
        System.out.println(b);
    }
}
