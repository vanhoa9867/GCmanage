/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcmanage;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class HangHoa {

    public int MaHH;
    public String TenHH;
    public String NhomHH;
    public String GhiChu;
    public String HinhAnh;
    public int DonGia;
    
    public HangHoa() {

    }

    public HangHoa(int masp,String nhom, String ten, String ghichu,String hinhanh,int gia) {
        MaHH = masp;
        NhomHH = nhom;
        TenHH = ten;
        GhiChu = ghichu;
        HinhAnh = hinhanh;
        DonGia = gia;
    }

    public static ArrayList<HangHoa> GetListHangHoa() throws Exception {
        ArrayList<HangHoa> list = new ArrayList();
        String query = "select * from HANGHOA";
        ResultSet rs = new DataConnection().ExcuteQuery(query);
        while (rs.next()) {
            HangHoa temp = new HangHoa();

            temp.MaHH = rs.getInt("MaHH");
            temp.NhomHH = rs.getString("NhomHH");
            temp.TenHH = rs.getString("TenHH");
            temp.GhiChu = rs.getString("GhiChu");
            temp.HinhAnh = rs.getString("HinhAnh");
            temp.DonGia = Integer.parseInt(rs.getString("DonGia"));
            
            
            list.add(temp);
        }
        return list;
    }

    public void Insert() throws Exception {
        String sql = String.format("INSERT INTO HANGHOA VALUES('%s', '%s', %s, '%s', '%s')", this.NhomHH, this.TenHH,
                this.GhiChu, this.HinhAnh,this.DonGia);
        new DataConnection().ExcuteUpdate(sql);
    }

    public void Update() throws Exception {
        String sql = String.format("UPDATE HANGHOA SET NhomHH = '%s', TenHH = %s, GhiChu = '%s', HinhAnh = '%s', DonGia = '%s' WHERE MaHH ='%s'", this.NhomHH, this.TenHH, this.GhiChu,this.HinhAnh,this.DonGia,this.MaHH);

        new DataConnection().ExcuteUpdate(sql);
    }

    public static void Delete(String maHH) throws Exception {
        String sql = String.format("DELETE FROM HANGHOA WHERE MaHH = '%s'", maHH);
        new DataConnection().ExcuteUpdate(sql);
    }
}
