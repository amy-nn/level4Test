package entity;

/**
 * 用户注册实体类
 */
public class UserBean {

    /**
     * phoneNum : 0
     * sign : string
     * time : string
     * userPassWord : string
     */

    private int phoneNum;
    private String sign;
    private String time;
    private String userPassWord;

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }
}
