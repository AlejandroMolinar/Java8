public class SiteHost {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.println("Sitio");
            } else if (i % 5 == 0) {
                System.out.println("Host");
            } else System.out.println(i);
        }

    }
}
