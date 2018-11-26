package MainBranch;

public class ProductMainDB
{
    private int proId;
    private String proName;
    private String proQuantity;
    private String proPrice;

    public ProductMainDB()
    {
        this.proId = 0;
        this.proName = "";
        this.proQuantity = "";
        this.proPrice = "";
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

    public String getProQuantity() {
        return proQuantity;
    }

    public void setProQuantity(String proQuantity) {
        this.proQuantity = proQuantity;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }
}
