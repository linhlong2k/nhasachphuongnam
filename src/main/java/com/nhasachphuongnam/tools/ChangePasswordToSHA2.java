/*
 * package com.nhasachphuongnam.tools;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Repository; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.nhasachphuongnam.dao.TaiKhoanDAO; import
 * com.nhasachphuongnam.entity.TaiKhoan;
 * 
 * @Repository
 * 
 * @Transactional public class ChangePasswordToSHA2 {
 * 
 * @Autowired EncryptSHA1 encryptSHA1;
 * 
 * @Autowired TaiKhoanDAO taiKhoanDAO;
 * 
 * public void Change() { List<TaiKhoan> taiKhoans = taiKhoanDAO.getAll(); for
 * (TaiKhoan i: taiKhoans) {
 * i.setPassword(encryptSHA1.Encrypt(i.getPassword())); taiKhoanDAO.update(i); }
 * } }
 */