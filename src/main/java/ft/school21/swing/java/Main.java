package ft.school21.swing.java;

import ft.school21.swing.java.database.ImplementDB;

public class Main {

    public static volatile boolean flagGui;

    public static void main(String[] args) {
        if (args.length != 1)
        {
            System.out.println("Invalid argument:\n" +
                    "java -jar swingy.jar console | gui");
            System.exit(1);
        }
        if (args[0].equals("console") || args[0].equals("gui")) {
            try {
                StartGame.Game(args[0]);
            }
            finally {
                ImplementDB.getImplementDB().getFactory().close();
            }
        }
        else
        {
            System.out.println("Implemented commands \"gui\" and \"console\"");
            System.exit(1);
        }
    }
}
