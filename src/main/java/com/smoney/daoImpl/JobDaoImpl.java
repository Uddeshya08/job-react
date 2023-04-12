package com.smoney.daoImpl;

import com.smoney.dao.JobDao;
import com.smoney.entity.Job;
import com.smoney.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Transactional
@Repository
public class JobDaoImpl implements JobDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Job> getJobsBasedOnSkillAndLocationAndUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Job> jobList = session.createNativeQuery("select * from Jobs where skill IN (:skills)").setParameter("skills", Arrays.asList(user.getSkills().split(","))).getResultList();
        return jobList;
    }
}
