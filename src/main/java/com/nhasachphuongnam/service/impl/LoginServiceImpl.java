package com.nhasachphuongnam.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nhasachphuongnam.dao.RoleDAO;
import com.nhasachphuongnam.dao.TaiKhoanDAO;
import com.nhasachphuongnam.entity.Role;
import com.nhasachphuongnam.entity.TaiKhoan;
import com.nhasachphuongnam.model.Login;
import com.nhasachphuongnam.model.RoleDTO;
import com.nhasachphuongnam.service.LoginService;

@Repository
@Transactional
public class LoginServiceImpl implements LoginService {
	@Autowired
	TaiKhoanDAO taiKhoanDAO;
	
	@Autowired
	RoleDAO roleDAO;
	//======sha-1
	public String encrypt(String input) 
    {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");
  
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            String hashtext = no.toString(16);
  
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            // return the HashText
            return hashtext;
        }
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
   }
	
	
	//======role=====
	public RoleDTO convert(Role role) {
		RoleDTO roleDTO = new RoleDTO(role.getMaRole(), role.getTenRole());
		return roleDTO;
	}
	
	//=====end-role===
	
	public Login convert(TaiKhoan taiKhoan) {
		Login res = new Login(taiKhoan.getUsername(), taiKhoan.getPassword(), convert(taiKhoan.getRole()));
		return res;
	}
	
	public TaiKhoan convert(Login login) {
		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setUsername(login.getUsername());
		taiKhoan.setPassword(login.getPassword());
		taiKhoan.setRole(roleDAO.getByID(login.getRole().getMaRole()));
		return taiKhoan;
	}

	public boolean add(Login login) {
		TaiKhoan taiKhoan = convert(login);
		taiKhoan.setPassword(this.encrypt(taiKhoan.getPassword()));
		if(taiKhoanDAO.add(taiKhoan)) {
			return true;
		}
		return false;
	}
	
	public boolean update(Login login) {
		TaiKhoan taiKhoan = convert(login);
		taiKhoan.setPassword(this.encrypt(taiKhoan.getPassword()));
		if(taiKhoanDAO.update(taiKhoan)) {
			return true;
		}
		return false;
	}
	
	public boolean delete(String ma) {
		if(taiKhoanDAO.delete(ma)) {
			return true;
		}
		return false;
	}
	
	public Login getByID(String ma) {
		TaiKhoan temp = taiKhoanDAO.getByID(ma);
		if(temp == null) {
			return null;
		}
		return convert(temp);
	}
	
	public List<Login> getAll(){
		List<Login> logins = new ArrayList<Login>();
		List<TaiKhoan> taiKhoans = taiKhoanDAO.getAll();
		for(TaiKhoan i: taiKhoans) {
			logins.add(convert(i));
		}
		return logins;
	}
	
	public Boolean checkLogin(Login login) {
		TaiKhoan taiKhoan = taiKhoanDAO.getByID(login.getUsername());
		if(taiKhoan == null) {
			return false;
		} else if(this.encrypt(login.getPassword()).equals(taiKhoan.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean changePassword(Login login) {
		TaiKhoan taiKhoan = taiKhoanDAO.getByID(login.getUsername());
		if(taiKhoan == null) {
			return false;
		} else {
			taiKhoan.setPassword(this.encrypt(login.getPassword()));
			if(taiKhoanDAO.update(taiKhoan)) {
				return true;
			}
			return false;
		}
	}
	
	public boolean toAdmin(String username) {
		TaiKhoan taiKhoan = taiKhoanDAO.getByID(username);
		taiKhoan.setRole(roleDAO.getByID("0"));
		if(taiKhoanDAO.update(taiKhoan)) {
			return true;
		}
		return false;
	}
	
	public boolean toNormal(String username) {
		TaiKhoan taiKhoan = taiKhoanDAO.getByID(username);
		taiKhoan.setRole(roleDAO.getByID("1"));
		if(taiKhoanDAO.update(taiKhoan)) {
			return true;
		}
		return false;
	}
	
	public void changPasswordToSHA1() {
		List<TaiKhoan> taiKhoans = taiKhoanDAO.getAll();
		for (TaiKhoan i: taiKhoans) {
			i.setPassword(this.encrypt(i.getPassword()));
			taiKhoanDAO.update(i);
		}
	}
}
