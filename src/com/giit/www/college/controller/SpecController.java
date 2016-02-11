package com.giit.www.college.controller;

import com.giit.www.college.service.DeptBiz;
import com.giit.www.college.service.SpecBiz;
import com.giit.www.entity.Spec;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by c0de8ug on 16-2-11.
 */
@Controller
@RequestMapping("spec.do")
public class SpecController {

    @Resource(name = "specBizImpl")
    SpecBiz specBiz;


    @RequestMapping("findDept")
    public String findDept(Model m) {
        m.addAttribute("deptNameList", specBiz.findDpet());
        return "/college/spec_add";
    }

    //TODO 该名字deptAndSpec不好,但是不知道如何命名-, -
    @RequestMapping("findDeptAndSpec")
    public String findDeptAndSpec(Model m) {
        m.addAttribute("deptAndSpec", specBiz.findDeptAndSpec());
        return "/college/spec";
    }

    @RequestMapping("update")
    public String update(@Param("specName") String newSpecName, @Param("newSpecName")String specName) {
        specBiz.update( specName, newSpecName);
        return "redirect:/spec.do/findDeptAndSpec";
    }

    @RequestMapping("add")
    public String add(Spec spec) {
        specBiz.add(spec);
        return "redirect:/spec.do/findDeptAndSpec";
    }

    @RequestMapping("delete")
    public String delete(String specName) {
        specBiz.delete(specName);
        return "redirect:/spec.do/findDeptAndSpec";
    }

}
