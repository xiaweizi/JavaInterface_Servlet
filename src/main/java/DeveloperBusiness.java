import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : PACKAGE_NAME.DeveloperBusiness
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/05/21
 *     desc   :
 * </pre>
 */

class DeveloperBusiness {
    public List<DeveloperModel> getAlavlDevelopers() {
        List<DeveloperModel> developerModelList = new ArrayList<>();
        String sql = "select * from developer";
        DBHelper helper = new DBHelper(sql);
        ResultSet resultSet = null;
        try {
            resultSet = helper.preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String site = resultSet.getString(3);
                String avatar = resultSet.getString(4);
                DeveloperModel model = new DeveloperModel();
                model.setId(id);
                model.setName(name);
                model.setSite(site);
                model.setAvatar(avatar);
                developerModelList.add(model);
            }
            resultSet.close();
            helper.close();
        } catch (Exception e) {

        } finally {

        }
        return developerModelList;
    }

    public DeveloperModel getDeveloper(String developerId) {
        String sql = "select * from developer where id=" + developerId;
        DBHelper dbHelper = new DBHelper(sql);
        DeveloperModel developerModel = null;
        try {
            ResultSet resultSet = dbHelper.preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String site = resultSet.getString(3);
                String avatar = resultSet.getString(4);
                System.out.println("avatar=" + avatar);
                developerModel = new DeveloperModel();
                developerModel.setId(id);
                developerModel.setName(name);
                developerModel.setSite(site);
                developerModel.setAvatar(avatar);
            }
            resultSet.close();
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return developerModel;
    }

    public boolean addDeveloper(DeveloperModel model) {
        String sql = "INSERT INTO developer(name,site,avatar) VALUES(" +
                "'" + model.getName() + "'," +
                "'" + model.getSite() + "'," +
                "'" + model.getAvatar() + "'" + ");";
        System.out.println("sql=" + sql);
        DBHelper helper = new DBHelper(sql);
        return execute(helper);
    }

    public boolean updateDeveloper(String id, String name) {
        String sql = "UPDATE developer SET name='" + name + "' WHERE id=" + id;
        System.out.println("sql=" + sql);
        DBHelper dbHelper = new DBHelper(sql);
        try {
            dbHelper.preparedStatement.executeUpdate();
            dbHelper.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean deleteDeveloper(String id) {
        String sql = "DELETE FROM developer WHERE id=" + id;
        System.out.println("sql=" + sql);
        DBHelper dbHelper = new DBHelper(sql);
        return execute(dbHelper);

    }

    private boolean execute(DBHelper helper) {
        try{
            helper.preparedStatement.execute();
            helper.close();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
