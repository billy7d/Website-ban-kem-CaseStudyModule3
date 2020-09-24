package model;

public class IceCream {
    private int iceCreamId;
    private int categoryId;
    private String name;
    private Double price;
    private String description;
    private int discount;
    private int soldQuantity;

    public IceCream(){
    }

    public IceCream(int categoryId, String name, double price, String description){
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getIdIceCream() {
        return iceCreamId;
    }

    public void setIdIceCream(int idIceCream) {
        this.iceCreamId = idIceCream;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
}
