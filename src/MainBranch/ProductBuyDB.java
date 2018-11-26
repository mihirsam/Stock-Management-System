package MainBranch;

public class ProductBuyDB
{
    private String proSl;
    private String proId;
    private String proName;
    private String proQuantity;
    private String proPrice;
    private String proTotal;
    private String proDate;


    public ProductBuyDB()
    {
        proSl = "";
        proId = "";
        proName = "";
        proQuantity = "";
        proPrice = "";
        proTotal = "";
        proDate = "";
    }

    public String getProSl() {
        return proSl;
    }

    public void setProSl(String proSl) {
        this.proSl = proSl;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
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

    public String getProTotal() {
        return proTotal;
    }

    public void setProTotal(String proTotal) {
        this.proTotal = proTotal;
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate;
    }
}
