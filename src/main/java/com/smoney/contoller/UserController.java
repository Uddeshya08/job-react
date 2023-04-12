package com.smoney.contoller;

import com.smoney.entity.Job;
import com.smoney.entity.User;
import com.smoney.service.JobService;
import com.smoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if(null != userService.findByUsername(user))
            return new ResponseEntity<>("User with this username already exists", HttpStatus.FORBIDDEN);
        else
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/getJobs")
    public ResponseEntity<List<Job>> getJobsBasedOnSkillAndLocationAndUser(@RequestBody User user) {
        return ResponseEntity.ok(jobService.getJobsBasedOnSkillAndLocationAndUser(user));
    }

}
