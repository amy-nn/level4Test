package entity;

/**
 * 清山老师接口，注册返回数据
 */
public class UserResultBean {


    /**
     * code : 200
     * message : 请求成功
     * result : 注册成功
     */

    private String code;
    private String message;
    private String result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
