import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    static String MyTextTitle = "Webserver for a bike tracking device";

    public static void main(String[] args) {
        while (true) {
            try {
                //System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("tst.html"))));
                ServerSocket serverSocket = new ServerSocket(1336);
                Socket remote = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(remote.getInputStream()));
                System.setOut(new PrintStream(remote.getOutputStream()));

                String str = ".";
                while (!str.equals("")) {
                    str = in.readLine();
                    System.err.println(str);
                }

                System.out.println("HTTP/1.0 200 OK\nContent-Type: text/html\n\n");
                System.out.println("<!DOCTYPE html>");
                System.out.println("<html>");
                System.out.println("<head>");
                System.out.println("My n is Max");
                System.out.println("<title>");
                System.out.println(MyTextTitle);
                System.out.println("</title>");
                System.out.println("</head>");
                System.out.println("<body>");
                System.out.println("<h1>" + MyTextTitle + "</h1>");
                System.out.println("</body>");
                System.out.println("</html>");

                System.out.flush();
                remote.close();
                serverSocket.close();


            } catch (Exception e) {
                System.err.println("An error occurred");
                System.err.println(e.getMessage());
            }
        }
    }
    }

