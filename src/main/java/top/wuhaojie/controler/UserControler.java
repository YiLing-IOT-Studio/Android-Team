package top.wuhaojie.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wuhaojie.constant.Constants;
import top.wuhaojie.domain.ResponseEntity;
import top.wuhaojie.domain.User;
import top.wuhaojie.repos.UserRepository;

import java.util.List;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/10/12 21:32
 * Version: 1.0
 */
@Controller
public class UserControler {

    @Autowired
    UserRepository mUserRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity register(String name, String password) {
        User user = new User(name, password);
        User save = mUserRepository.save(user);
        ResponseEntity entity = new ResponseEntity(Constants.SUCCESS, "");
        if (user.equals(save)) {
            entity.setCode(Constants.ERROR);
            entity.setMsg("insert to database error");
        }
        return entity;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity login(String name, String password) {
        List<User> users = mUserRepository.findByName(name);
        ResponseEntity<User> entity = new ResponseEntity<>(Constants.SUCCESS, "");
        for (User u : users) {
            if (u.getPassword().equals(password)) {
                entity.setData(u);
                return entity;
            }
        }
        entity.setCode(Constants.ERROR);
        entity.setMsg("login failed");
        return entity;
    }


}
