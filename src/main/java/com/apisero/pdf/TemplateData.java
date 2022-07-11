package com.apisero.pdf;

public class TemplateData {

    private String date;
    private String customerName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipcode;

    /**
     * No args constructor for use in serialization
     *
     */
    public TemplateData() {
    }

    /**
     *
     * @param date
     * @param city
     * @param customerName
     * @param zipcode
     * @param streetAddress
     * @param state
     */
    public TemplateData(String date, String customerName, String streetAddress, String city, String state, String zipcode) {
        super();
        this.date = date;
        this.customerName = customerName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


}