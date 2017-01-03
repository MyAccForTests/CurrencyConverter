package model.services;

import dao.CurrencyDAO;
import model.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Ilua on 15.12.2016.
 */
@Service("dbService")
@Transactional
public class CurrencyDBServiceImpl implements CurrencyDAOService {

    @Autowired
    private CurrencyDAO service;

    public CurrencyDBServiceImpl() {
    }

    public CurrencyDBServiceImpl(CurrencyDAO service) {
        this.service = service;
    }

    @Override
    public void update(List<Course> list) {
        service.add(list);
    }

    @Override
    public void updateAll(List<Course> list) {
        service.update(list);
    }

    @Override
    public List<Course> getCourses() {
        return service.getCourses();
    }

    @Override
    public List<Course> getCourses(Calendar fromDate) {
        return service.getCourses(fromDate);
    }

    @Override
    public List<Course> getCourses(Calendar fromDate, Calendar toDate) {
        return service.getCourses(fromDate, toDate);
    }
}
