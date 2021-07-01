package dev.foraged.flame;

import java.util.*;
import java.util.stream.Collectors;

public class Flame {

    static boolean debug = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine().toLowerCase(Locale.ROOT), secondName = scanner.nextLine().toLowerCase(Locale.ROOT);

        for (char c : firstName.toCharArray()) {
            if (debug) System.out.println(c);
            if (firstName.contains(c + "") && secondName.contains(c + "")) {
                firstName = firstName.replace(c + "", "");
                secondName = secondName.replace(c + "", "");
            }
        }

        if (debug) System.out.println(firstName + " " + secondName);

        List<String> chars = Arrays.stream(Reason.values()).map(Reason::name).collect(Collectors.toList());
        int charAmount = firstName.length() + secondName.length();
        for (int z = 0; z < 4; z++) {
            int f = 0;

            for (int i = 0; i < (charAmount - 1); i++) {
                f++;
                if (f == chars.size()) f = 0;
            }
            if (debug) System.out.println("Removing " + chars.get(f));
            chars.remove(chars.get(f));
        }

        // Result is equal to chars.get(0)
        System.out.println("The result is " + Reason.valueOf(chars.get(0)).description);
    }

    private enum Reason {

        F("Friend"),
        L("Love"),
        A("Affection"),
        M("Marry"),
        E("Enemy");

        private String description;

        Reason(String description) {
            this.description = description;
        }
    }
}
