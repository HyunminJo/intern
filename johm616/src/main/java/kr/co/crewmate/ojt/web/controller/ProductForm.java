package kr.co.crewmate.ojt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductForm {

    /**
     * 
     * 조회
     *
     * @since 2020. 11. 27.
     * @author johm616
     *
     * @param model
     * @param product
     * @return
     */
    @RequestMapping( "/sample/productForm" )
    public String main(Model model) {
        return "/sample/productForm";
    }
    
    
    
}
