/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDA.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *

 */
public class Alert {
    private long alertNo; 
    private long localNo;
    private long disasterNo;
    private Date alertDate;

    public Alert() {
    }

    public Alert(long alertNo, long localNo, long disasterNo, Date alertDate) {
        this.alertNo = alertNo;
        this.localNo = localNo;
        this.disasterNo = disasterNo;
        this.alertDate = alertDate;
    }

    public long getAlertNo() {
        return alertNo;
    }

    public void setAlertNo(long alertNo) {
        this.alertNo = alertNo;
    }

    public long getLocalNo() {
        return localNo;
    }

    public void setLocalNo(long localNo) {
        this.localNo = localNo;
    }

    public long getDisasterNo() {
        return disasterNo;
    }

    public void setDisasterNo(long disasterNo) {
        this.disasterNo = disasterNo;
    }

    public Date getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Date alertDate) {
        this.alertDate = alertDate;
    }
    
    public ArrayList<Disaster> getDisaster(String am , String prov){
        
        Disaster dist = null;
        ArrayList<Disaster> listDist = null;
        String catName = null;
        
    
        try{
            Connection conn = connectionBuilder.getConnection();
            PreparedStatement pstm = conn.prepareStatement("select localId from emergencyeda.location where localName = ? and subprovinceName = ?");
            pstm.setString(1, prov);
            pstm.setString(2, am);
            ResultSet rs = pstm.executeQuery();
            int localId = 0;
            while(rs.next()){
                localId = rs.getInt("localId");
                 System.out.println(localId);
            }
            PreparedStatement pstm1 = conn.prepareStatement("select * from emergencyeda.list_alerts where localId = ?");
            pstm1.setInt(1, localId);
            ResultSet rs1 = pstm1.executeQuery();
            
            while(rs1.next()){
                
                rs1.getInt("disasterId");
                dist = new Disaster();
                listDist = new ArrayList<Disaster>();
                
                dist = this.getDisaster(localId);
                System.out.println(dist.getCatName());
            
                listDist.add(dist);
            
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return listDist;
    }
    
    
    public Disaster getDisaster(int distNo){
        Disaster dist = null;
        String catName = "";
      
        try{
            Connection conn = connectionBuilder.getConnection();
            PreparedStatement pstm = conn.prepareStatement("select *from emergencyeda.disaster_info where disasterId = ?");
            pstm.setInt(1, distNo);
            ResultSet rs = pstm.executeQuery();
       
            while (rs.next()){
                    dist = new Disaster();
                    dist.setDisasterName(rs.getString("disasterName"));
                dist.setDisasDesp(rs.getString("desp_disaster"));
               catName = this.getCategoryName(rs.getInt("disasterCatId"));
               dist.setLocation(rs.getString("location_disaster"));
               dist.setCatName(catName);
               dist.setDisasterNo(rs.getInt("disasterId"));
            }
        }
        catch(Exception ex ){
            ex.printStackTrace();
        }
        return dist;
    }
    
   
    
    
    
    public String getCategoryName(int catNo){
        
      
        String catName = "";
        try{
             Connection conn = connectionBuilder.getConnection();
             
             PreparedStatement pstm = conn.prepareStatement("select * from emergencyeda.category_list where catId = ?");
                pstm.setInt(1, catNo);
                ResultSet rs = pstm.executeQuery();
                if(rs.next()){
                    catName = rs.getString("catName");
                }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
         
        
        return catName;
    }
    
    
}
