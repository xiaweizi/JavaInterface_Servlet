import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : ${PACKAGE_NAME}.${NAME}
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/05/21
 *     desc   :
 * </pre>
 */
@WebServlet(name = "DeveloperServlet", urlPatterns = {"/DeveloperServlet"})
public class DeveloperServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("gagagag");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Hello World!111</h1>");
    }
}
