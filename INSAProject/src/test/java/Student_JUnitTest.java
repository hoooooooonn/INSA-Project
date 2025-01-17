import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.StudentDto;
import com.min.edu.repository.IStudentDao;
import com.min.edu.repository.StudentDaoImpl;

public class Student_JUnitTest {

	IStudentDao dao;
	
	@Before
	public void createDao() {
		dao = new StudentDaoImpl();
	}
	
	
	@Test
	public void stuNameTest() {
		String stu_name = "김지원";
		List<StudentDto> name = dao.selectStudentByName(stu_name);
		assertNotEquals(0, name);
	}

}
