package com.spring.hibernatespring.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.hibernatespring.Student;

public class StudentDaoImp implements StudentDao {
	
	
	private HibernateTemplate temp;
	
	public HibernateTemplate getTemp() {
		return temp;
	}

	public void setTemp(HibernateTemplate temp) {
		this.temp = temp;
	}

	@Transactional
	@Override
	public int saveStudent(Student Student) {
		int i = (int) temp.save(Student);
		return i;
	}

	@Override
	public Student getStudent(int id) {
		Student stu = temp.get(Student.class, id);
		return stu;
	}

	
	@Transactional
	@Override
	public void updateStudent(Student student) {
		temp.update(student);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Student i = temp.get(Student.class, id);
		temp.delete(i);
		
	}

}
