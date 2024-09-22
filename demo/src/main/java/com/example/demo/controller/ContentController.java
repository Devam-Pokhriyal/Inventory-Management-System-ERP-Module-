package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContentController {

    @RequestMapping("/")
    public String first() {
        return "login"; // This should map to the login.html or login.jsp in your templates directory
    }
    @RequestMapping("/login")
    public String login() {
        return "login"; // This should map to the login.html or login.jsp in your templates directory
    }
    
    
    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // This should map to the login.html or login.jsp in your templates directory
    }
    @RequestMapping("/dashboard/CategoryMaster")
    public String CategoryMaster() {
        return "CategoryMaster"; // This should map to the login.html or login.jsp in your templates directory
    }
    @RequestMapping("/dashboard/SubCategoryMaster")
    public String SubCategoryMaster() {
        return "SubCategoryMaster"; // This should map to the login.html or login.jsp in your templates directory
    }
    @RequestMapping("/dashboard/VendorMaster")
    public String VendorMaster() {
        return "VendorMaster"; // This should map to the login.html or login.jsp in your templates directory
    }
    @RequestMapping("/dashboard/Vendor-item-Mapping-Master")
    public String VendorItemMappingMaster() {
        return "VendorItemMapping"; // This should map to the login.html or login.jsp in your templates directory
    }
    @RequestMapping("/dashboard/Location-Master")
    public String LocationMaster() {
        return "LocationMaster"; // This should map to the login.html or login.jsp in your templates directory
    }
    @RequestMapping("/dashboard/Item-Master")
    public String ItemMaster() {
        return "ItemMaster"; // This should map to the login.html or login.jsp in your templates directory
    }
    @RequestMapping("/dashboard/Item-UOM-Conversion")
    public String ItemUOMConversion() {
        return "ItemUOMconversion"; // This should map to the login.html or login.jsp in your templates directory
    }
    @RequestMapping("/dashboard/Change-Password")
    public String ChangePassword() {
        return "ChangePassword"; // This should map to the login.html or login.jsp in your templates directory
    }
    @RequestMapping("/dashboard/Transaction")
    public String TransactionDetails() {
        return "Transaction"; // This should map to the login.html or login.jsp in your templates directory
    }
    @RequestMapping("/dashboard/TransactionHD")
    public String TransactionHeaderDetails(@RequestParam(required = false) String type, 
                                           @RequestParam(required = false) String code, 
                                           Model model) {
        model.addAttribute("transactionType", type);
        model.addAttribute("transactionCode", code);
        return "TransactionHD";
   
} 
@RequestMapping("/dashboard/Edit")
public String TransactioneditDetails(@RequestParam(required = false) String type, 
                                       @RequestParam(required = false) String code, 
                                       Model model) {
    model.addAttribute("transactionType", type);
    model.addAttribute("transactionCode", code);
    return "edit";
}


}
