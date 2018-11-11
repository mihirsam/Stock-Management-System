package MainBranch;

public class ProductMainDB
{
    private int proId;
    private String proName;
    private int proQuantity;
    private int proPrice;

    public ProductMainDB()
    {
        this.proId = 0;
        this.proName = "";
        this.proQuantity = 0;
        this.proPrice = 0;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getProQuantity(int quantity) {
        return proQuantity;
    }

    public void setProQuantity(int proQuantity) {
        this.proQuantity = proQuantity;
    }

    public int getProPrice(int price) {
        return proPrice;
    }

    public void setProPrice(int proPrice) {
        this.proPrice = proPrice;
    }
}
