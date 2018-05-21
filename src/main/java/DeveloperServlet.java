import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet(name = "DeveloperServlet", urlPatterns = {ConstantUtil.ALL_DEVELOPERS_URL, ConstantUtil.QUERY_DEVELOPER_URL,
        ConstantUtil.ADD_DEVELOPER_URL, ConstantUtil.UPDATE_DEVELOPER_URL, ConstantUtil.DELETE_DEVELOPER_URL})

public class DeveloperServlet extends HttpServlet {

    DeveloperBusiness developerBusiness = new DeveloperBusiness();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("url=" + request.getRequestURI());
        request.setCharacterEncoding("UTF-8");
        //设置响应内容类型
        response.setContentType("text/json;charset=UTF-8");
        String url = request.getRequestURI();
        if (url.equals(ConstantUtil.ALL_DEVELOPERS_URL)) {
            getAllDevelopers(request, response);
        } else if (url.equals(ConstantUtil.QUERY_DEVELOPER_URL)) {
            getDeveloper(request, response);
        } else if (url.equals(ConstantUtil.ADD_DEVELOPER_URL)) {
            addDeveloper(request, response);
        } else if (url.equals(ConstantUtil.UPDATE_DEVELOPER_URL)) {
            updateDeveloper(request, response);
        } else if (url.equals(ConstantUtil.DELETE_DEVELOPER_URL)) {
            deleteDeveloper(request, response);
        }
    }

    private void getAllDevelopers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        List<DeveloperModel> allDevelopers = developerBusiness.getAllDevelopers();
        CommonModel commonModel = new CommonModel();
        if (allDevelopers.size() > 0) {
            commonModel.setSuccess();
            commonModel.setData(allDevelopers);
        } else {
            commonModel.setFailed();
        }
        writer.println(GsonUtil.bean2Json(commonModel));
        writer.flush();
        writer.close();
    }

    private void getDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置逻辑实现
        PrintWriter printWriter = response.getWriter();
        // 接受参数
        String id = request.getParameter("id");
        System.out.println("id=" + id);
        DeveloperModel developerModel = developerBusiness.getDeveloper(id);
        CommonModel commonModel = new CommonModel();
        if (developerModel == null) {
            commonModel.setFailed();
        } else {
            commonModel.setSuccess();
            commonModel.setData(developerModel);
        }
        printWriter.println(GsonUtil.bean2Json(commonModel));
        printWriter.flush();
        printWriter.close();
    }

    private void addDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置逻辑实现
        PrintWriter printWriter = response.getWriter();
        String name = request.getParameter("name");
        System.out.println("name=" + name);
        String site = request.getParameter("site");
        String avatar = request.getParameter("avatar");

        CommonModel commonModel = new CommonModel();
        DeveloperModel developerModel = new DeveloperModel();
        developerModel.setName(name);
        developerModel.setSite(site);
        developerModel.setAvatar(avatar);
        if (developerBusiness.addDeveloper(developerModel)) {
            commonModel.setSuccess();
        } else {
            commonModel.setFailed();
        }
        printWriter.println(GsonUtil.bean2Json(commonModel));
    }

    private void updateDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置逻辑实现
        PrintWriter printWriter = response.getWriter();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        System.out.println("name=" + name);

        CommonModel commonModel = new CommonModel();
        if (developerBusiness.updateDeveloper(id, name)) {
            commonModel.setSuccess();
        } else {
            commonModel.setFailed();
        }
        printWriter.println(GsonUtil.bean2Json(commonModel));
    }

    private void deleteDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置逻辑实现
        PrintWriter printWriter = response.getWriter();
        String id = request.getParameter("id");
        System.out.println("id=" + id);
        CommonModel commonModel = new CommonModel();
        if (developerBusiness.deleteDeveloper(id)) {
            commonModel.setSuccess();
        } else {
            commonModel.setFailed();
        }
        printWriter.println(GsonUtil.bean2Json(commonModel));
    }
}
