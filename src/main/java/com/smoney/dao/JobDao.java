package com.smoney.dao;

import com.smoney.entity.Job;
import com.smoney.entity.User;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface JobDao {
    public List<Job> getJobsBasedOnSkillAndLocationAndUser(User user);
}
