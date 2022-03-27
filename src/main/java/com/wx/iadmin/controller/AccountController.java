package com.wx.iadmin.controller;

import com.wx.iadmin.dao.AccountRepository;
import com.wx.iadmin.entity.Account;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.List;

@RestController
public class AccountController {

    @Resource
    private AccountRepository accountRepository;

    @GetMapping("findAll")
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @GetMapping("findByCode")
    public Account findByCode(String code) {
        Specification<Account> spec = (root, query, cb) -> {
            Predicate p = cb.equal(root.get("code").as(String.class), code);
            return query.where(p).getRestriction();
        };
        return accountRepository.findOne(spec).orElse(null);
    }

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("name", "hello 向胖子");
        return mv;
    }
}
