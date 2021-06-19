/*
 * package com.nhasachphuongnam.bean;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import com.nhasachphuongnam.model.RoleDTO; import
 * com.nhasachphuongnam.service.RoleService;
 * 
 * @ControllerAdvice
 * 
 * @RequestMapping("admin") public class RoleModelAttribute {
 * 
 * @Autowired RoleService roleService;
 * 
 * @ModelAttribute("roles") public List<RoleDTO> getAll() { List<RoleDTO> res =
 * roleService.getAll(); return res; }
 * 
 * }
 */