import java.io.IOException;
import java.io.InputStreamReader;

public class SystemProcessDemo {

    /* A program to demo running a system process from a Java program.
     * It runs the unix/linux 'ls' command with the '-l' flag.
     * It gets the output from the system process and prints it to standard-out.
     */

    public static void main(String[] args) {

        // Create ProcessBuilder instance for UNIX command ls -l
        java.lang.ProcessBuilder processBuilder = new java.lang.ProcessBuilder("ls", "-l");

        // Create an environment (a shell to run the process in)
        java.util.Map<String, String> env = processBuilder.environment();

        // Configure the environment as required.
        env.clear();
        env.put("COLUMNS", "3"); // See manpage ls(1)

        // Change the working directory.
        // NOTE that this needs editing to be the directory you want to list.
        // If it is not a valid directory then the program will crash.
        processBuilder.directory(new java.io.File("/home/gary"));

        // Start new process
        java.lang.Process p = null;
        try {
            p = processBuilder.start();
        } catch (IOException e) {
            // Something went wrong, so print a stack trace and quit
            e.printStackTrace();
            System.exit(1);
        }

        // Read the output from the system process as input to this program...
        java.io.InputStream is = p.getInputStream();
        java.io.BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));

        // ... And print each line
        String s = null;
        try {
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            is.close();
        } catch (IOException e) {
            // Something went wrong, so print a stack trace and quit
            e.printStackTrace();
            System.exit(1);
        }
    }
}
