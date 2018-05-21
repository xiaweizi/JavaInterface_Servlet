/**
 * <pre>
 *     author : xiaweizi
 *     class  : PACKAGE_NAME.CommonModel
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/05/21
 *     desc   :
 * </pre>
 */

class CommonModel {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setSuccess() {
        setCode(1);
        setMsg("success");
    }

    public void setFailed() {
        setCode(2);
        setMsg("failed");
    }
}
