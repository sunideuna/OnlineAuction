
package ItemModel;

import Database.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ItemModel {
    
    private String imgUrl;
    private String email;
    private String userName;
    private String productName;
    private String productDescription;
    private String itemPrice;
    public List<ItemModel> list = new ArrayList<>();
    
    public ItemModel(){
    }
    /**
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl the imgUrl to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * @param productDescription the productDescription to set
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * @return the itemPrice
     */
    public String getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
  
    public void connectToDB() {
        
       try{
            // Connecting and feching Data from data base;
           list = new ArrayList<>();
 //           Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root","ritesh");
            PreparedStatement pst = Database.getConnection().prepareStatement("select * from sellerinfo");
            ResultSet result = pst.executeQuery();
            while(result.next()){
                ItemModel model = new ItemModel();
                model.setEmail(result.getString(3));
                model.setImgUrl(result.getString(7));
                model.setProductDescription(result.getString(6));
                model.setProductName(result.getString(5));
                model.setUserName(result.getString(2));
                list.add(model);
            }
            Database.getConnection().close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public List<ItemModel> getFetchedData(){
        return list;
    }
    
    
}

