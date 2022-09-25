package com.example.demo.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.Student;






@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

	@Query(value = "select max(sid) as maxid from student", nativeQuery = true)
	int getMaxId();
	
	@Query(value="SELECT COALESCE(MAX(sid),0)+1 FROM student",nativeQuery=true)
	int getMaxIdButIncreaseOne();
	


	List<Student> findByidLike(Integer id);

	List<Student> findBynameLike(String name);
	
	List<Student> findByIdAndName(int id, String name);
	

	
	@Query(value = "select s.* from student s join coursedetail cd on s.sid = cd.studentid join \r\n"
			+ "course c on c.cid = cd.courseid where c.name LIKE ?1  group by s.sid", nativeQuery = true)
	List<Student> findByCourse(String course);
	
	
//	@Query(value = "select s.* from student s join coursedetail cd on s.sid = cd.studentid join \r\n"
//	+ "course c on c.cid = cd.courseid where s.sid LIKE ?1 OR s.name LIKE ?2 OR c.name LIKE 3?  group by s.sid", nativeQuery = true)	
//List<Student> findByIdOrNameOrCourse(int id,String name,String course);

//List<Student> findByIdOrNameOrCourse(int id,String name,String course);

//	
	
	
//	@Query(value = "select s.* from student s join coursedetail cd on s.sid = cd.studentid join \r\n"
//	+ "course c on c.cid = cd.courseid  group by s.sid", nativeQuery = true)
//List<Student> findall();
//
//@Query(value = "select group_concat(c.name) as course from student s join coursedetail cd on s.sid = cd.studentid join \r\n"
//	+ "course c on c.cid = cd.courseid where s.sid = :i  group by s.sid", nativeQuery = true)
//List<String> findcourse(int i);

//Optional<Student> findStuById(int i);
	Student findByid(int a);
}
