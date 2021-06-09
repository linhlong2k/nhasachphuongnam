/*
 * package com.nhasachphuongnam.bean;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ModelAttribute;
 * 
 * import com.nhasachphuongnam.model.ExportOrder; import
 * com.nhasachphuongnam.model.ImportOrder; import
 * com.nhasachphuongnam.model.PersonalInfo; import
 * com.nhasachphuongnam.model.Product; import
 * com.nhasachphuongnam.model.ProductDetail; import
 * com.nhasachphuongnam.model.ProductType; import
 * com.nhasachphuongnam.model.RoleDTO; import
 * com.nhasachphuongnam.model.Supplier; import
 * com.nhasachphuongnam.service.ExportOrderService; import
 * com.nhasachphuongnam.service.ImportOrderService; import
 * com.nhasachphuongnam.service.PIService; import
 * com.nhasachphuongnam.service.ProductService; import
 * com.nhasachphuongnam.service.ProductTypeService; import
 * com.nhasachphuongnam.service.RoleService; import
 * com.nhasachphuongnam.service.SupplierService;
 * 
 * @ControllerAdvice public class AdminModelAttribute {
 * 
 * @Autowired PIService piService;
 * 
 * @Autowired ExportOrderService exService;
 * 
 * @Autowired ImportOrderService ioService;
 * 
 * @Autowired ProductTypeService productTypeService;
 * 
 * @Autowired ProductService productService;
 * 
 * @Autowired SupplierService supplierService;
 * 
 * @Autowired RoleService roleService; //
 * ===============================================Model-Attribute=============
 * 
 * @ModelAttribute("danhSachKhachHang") public List<PersonalInfo>
 * danhSachKhachHang() { List<PersonalInfo> pis = piService.getAllKhachHang();
 * return pis; }
 * 
 * @ModelAttribute("danhSachHoaDon") public List<ExportOrder> danhSachHoaDon() {
 * List<ExportOrder> res = exService.getAll(); return res; }
 * 
 * @ModelAttribute("danhSachPhieuNhap") public List<ImportOrder>
 * danhSachPhieuNhap() { List<ImportOrder> res = ioService.getAll(); return res;
 * }
 * 
 * @ModelAttribute("danhSachLoaiMatHang") public List<ProductType>
 * danhSachLoaiMatHang() { List<ProductType> loaiMatHangs =
 * productTypeService.getAll(); return loaiMatHangs; }
 * 
 * @ModelAttribute("danhSachNhanVien") public List<PersonalInfo>
 * danhSachNhanVien() { List<PersonalInfo> pis = piService.getAllNhanVien();
 * return pis; }
 * 
 * @ModelAttribute("danhSachNhaCungCap") public List<Supplier>
 * danhSachNhaCungCap() { List<Supplier> res = supplierService.getAll(); return
 * res; }
 * 
 * @ModelAttribute("roles") public List<RoleDTO> getAll() { List<RoleDTO> res =
 * roleService.getAll(); return res; }
 * 
 * }
 */