package kr.co.tjoeun.pizzastore_20200527.datas;

public class Store {

    private String name;
    private String logoImgUrl;
    private String telNum;

    public Store(String name, String logoImgUrl, String telNum) {
        this.name = name;
        this.logoImgUrl = logoImgUrl;
        this.telNum = telNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoImgUrl() {
        return logoImgUrl;
    }

    public void setLogoImgUrl(String logoImgUrl) {
        this.logoImgUrl = logoImgUrl;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }
}
