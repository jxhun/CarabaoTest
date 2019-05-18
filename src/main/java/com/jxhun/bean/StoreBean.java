package com.jxhun.bean;

/**
 * Created with IntelliJ IDEA.
 * User: Jxhun
 * Date: 2019/05/18
 * Description:
 * Version: V1.0
 */
public class StoreBean {

    private String shopNumber; // 门店编号
    private String nameOfStore; // 门店名称
    private String office; // 办事处
    private String address; // 地址
    private String coordinate; // 坐标

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }

    public String getNameOfStore() {
        return nameOfStore;
    }

    public void setNameOfStore(String nameOfStore) {
        this.nameOfStore = nameOfStore;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }
}
