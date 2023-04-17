package com.smoney.serviceImpl;

import com.smoney.dao.JobDao;
import com.smoney.entity.Job;
import com.smoney.entity.User;
import com.smoney.repository.UserJpaRepository;
import com.smoney.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;

    @Autowired
    private UserJpaRepository userJpaRepository;


    @Override
    public List<Job> getJobsBasedOnSkillAndLocationAndUser(Long userId) {
        return jobDao.getJobsBasedOnSkillAndLocationAndUser(userJpaRepository.findById(userId).get());
    }



}
