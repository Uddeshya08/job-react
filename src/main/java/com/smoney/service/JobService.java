package com.smoney.service;

import com.smoney.entity.Job;
import com.smoney.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {

    public List<Job> getJobsBasedOnSkillAndLocationAndUser(Long userId);

}
