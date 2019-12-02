package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IStudentDao;
import com.app.pojos.Student;

@Service
public class IStudentServiceImpl implements IStudentService {

	public IStudentServiceImpl() {
		System.out.println("IStudentServiceImpl()");
	}
	
	@Autowired
	private IStudentDao sdao;

	@Override
	public String admitNewStudent(Student student, int cid) {
		System.out.println("inside admitNewStudent() value of cid="+cid);
		String msg="";
		int flag=0;
		if (!(student.getDob().getYear() > 1990)) {
			msg="DOB must be after 1990 ! ";
			flag=1;
		}
		if (!(student.getCgpa() > 7)) {
			msg+=" CGPA must be greater than 7 !";
			flag=1;
		}
		if(flag!=1) {
			msg="N";
			int i=sdao.addStudent(student,cid);
			if (i!=0)
				msg="Y";
		}
		return msg;
	}
}
