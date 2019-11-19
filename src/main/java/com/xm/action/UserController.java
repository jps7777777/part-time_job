package com.xm.action;

import com.xm.bean.User;
import com.xm.response.CommonResponse;
import com.xm.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/10/9.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping("/list")
    public CommonResponse getList(){
        List<User> users = userRepository.findAll();
        return CommonResponse.create(users);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> usersList(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @RequestMapping(value = "/" ,method = RequestMethod.PUT)
    public String updateUser(User user){
        if(userRepository.save(user) != null){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    @RequestMapping(value = "/up" ,method = RequestMethod.PUT)
    public String update(User user){
        if(userRepository.save(user) != null){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CommonResponse selectUserById(@PathVariable long id){
        return CommonResponse.create("i am here.");
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable long id){
        userRepository.deleteById(id);
        return "删除成功";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String saveUser(User user){
        System.out.println(userRepository);
        if(userRepository.save(user) != null){
            return "新增成功";
        }else{
            return "新增失败";
        }
    }
}

