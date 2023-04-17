package com.smoney.contoller;

import com.smoney.dto.UserRequest;
import com.smoney.entity.Job;
import com.smoney.entity.User;
import com.smoney.service.JobService;
import com.smoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRequest user) {
        if(null != userService.findByUsername(user.getUsername()).orElse(null))
            return new ResponseEntity<>("User with this username already exists", HttpStatus.FORBIDDEN);
        else
            return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

//    @PostMapping("/getJobs")
//    public ResponseEntity<List<Job>> getJobsBasedOnSkillAndLocationAndUser(@RequestBody User user) {
//        return ResponseEntity.ok(jobService.getJobsBasedOnSkillAndLocationAndUser(userId));
//    }

    @GetMapping("/getJobs/{userId}")
    public ResponseEntity<List<Job>> getJobsBasedOnSkillAndLocationAndUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(jobService.getJobsBasedOnSkillAndLocationAndUser(userId));
    }


    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

}
