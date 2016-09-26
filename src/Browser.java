import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Browser {
    private static String readit() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    private static String currentpath = "/";

    public static void makeitrock() throws IOException {
        while (true) {
            String[] allfiles = readalldirectory(currentpath);
            for (int i = 0; i < allfiles.length; i++) {
                System.out.println(allfiles[i]);
            }
            String input;
            while (true) {
                input = readit();
                boolean targetfilefound = false;
                for (String s : allfiles) {
                    if (input.equalsIgnoreCase(s)) {
                        targetfilefound = true;
                        break;
                    }
                }
                if (targetfilefound) {
                    break;
                } else {
                    System.out.println("Try again, there is no such path or file.");
                }
            }
            currentpath = currentpath + "/" + input;
            if (new File(currentpath).isFile()) {
                while (true) {
                    System.out.println("You want to read this file?");
                    String sinput = readit();
                    if (sinput.equalsIgnoreCase("yes")) {
                        //TODO:FINISH THAT!
                    } else if (sinput.equalsIgnoreCase("no")) {
                        System.out.println("then have a good day!");
                        System.exit(0);
                    } else {
                        System.out.println("Error. Just try again.");
                    }
                }
            }
        }
    }

    private static String[] readalldirectory(String path) {
        File f = new File(path);
        return f.list();
    }
}
