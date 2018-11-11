package MainBranch;

public class ProductSalesDB
{
    private String proSl;
    private String proId;
    private String proName;
    private String custName;
    private String custPhone;
    private String proPrice;
    private String proQuantity;
    private String proTotal;
    private String proDate;


    public ProductSalesDB()
    {
        this.proSl = "";
        this.proId = "";
        this.proName = "";
        this.custName = "";
        this.custPhone = "";
        this.proPrice = "";
        this.proQuantity = "";
        this.proTotal = "";
        this.proDate = "";
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

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public String getProQuantity() {
        return proQuantity;
    }

    public void setProQuantity(String proQuantity) {
        this.proQuantity = proQuantity;
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
