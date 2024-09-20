/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_lopvadoituong_j0424;

/**
 *
 * @author dangquang16
 */
public class DataProvider {
    
    /**
     * Khai báo 1 thuộc tính tạo đối tượng thuộc lớp SinhVienBusiness để có thể truy cập từ nhiều nơi
     */
    private static SinhVienBusiness sinhVienBus = null;
    
    public static SinhVienBusiness getSinhVienBus()
    {
        if(sinhVienBus == null)
        {
            sinhVienBus = new SinhVienBusiness();
        }
        
        return sinhVienBus;
    }
}
