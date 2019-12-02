package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICourseDao;
import com.app.pojos.Course;

@Service
public class ICourseServiceImpl implements ICourseService {

	public ICourseServiceImpl() {
		System.out.println("ICourseServiceImpl()");
	}

	@Autowired
	private ICourseDao cdao;

	@Override
	public List<Course> getCourseList() {
		return cdao.getCourseList();
	}

	@Override
	public Course deleteCourse(int cid) {
		return cdao.deleteCourse(cid);
	}

}
