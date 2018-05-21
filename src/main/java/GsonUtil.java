import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : PACKAGE_NAME.GsonUtil
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/05/21
 *     desc   :
 * </pre>
 */

class GsonUtil {
    private static Gson gson = new GsonBuilder().create();
    public static String bean2Json(Object object) {
        return gson.toJson(object);
    }

    public static <T> T json2Bean(String jsonSrc, Class<T> objectClass) {
        return gson.fromJson(jsonSrc, objectClass);
    }

    public static String jsonFormatter(String uglyJsonStr) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser js = new JsonParser();
        JsonElement je = js.parse(uglyJsonStr);
        return gson.toJson(je);
    }
 }
