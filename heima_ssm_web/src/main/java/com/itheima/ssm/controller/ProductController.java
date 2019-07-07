package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/1 0001 14:44
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll.do")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ModelAndView findAll(@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                @RequestParam(name = "pageSize",defaultValue = "4")Integer pageSize){
        ModelAndView mav = new ModelAndView();
        List<Product> productList = productService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(productList);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("product-list");
        return mav;
    }

    @RequestMapping("/save.do")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll.do";
    }

}
