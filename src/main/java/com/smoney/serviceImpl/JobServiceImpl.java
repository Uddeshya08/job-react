package com.smoney.serviceImpl;

import com.smoney.dao.JobDao;
import com.smoney.entity.Job;
import com.smoney.entity.User;
import com.smoney.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;

    @Override
    public List<Job> getJobsBasedOnSkillAndLocationAndUser(User user) {
        return jobDao.getJobsBasedOnSkillAndLocationAndUser(user);
    }
}
