package org.cqut.hr.teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

	public List<Teacher> findAll()
	{
		List<Teacher>  teachers = new ArrayList<Teacher>();
		teachers.add(new Teacher("xcy", 18));
		teachers.add(new Teacher("zy", 16));
		return teachers;
	}
}
