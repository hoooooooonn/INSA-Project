import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.min.edu.repository.EmpSelectDaoImpl;
import com.min.edu.repository.IEmpSelectDao;
import com.min.edu.vo.EmpVo;

public class Emp_JUnitTest {

	private IEmpSelectDao EmpSelectDao;
	
	@Before
	public void createDao() {
		EmpSelectDao = new EmpSelectDaoImpl();
	}
	
//	@Test
	public void select02_test() {
		EmpVo vo = EmpSelectDao.select02("김지훈");
		assertNotNull("조회결과 있음",vo);
	}
	
//	@Test
	public void selectEmpId() {
		int result = EmpSelectDao.selectEmpId("김지훈");
		assertNotEquals(0, result);
	}
//	@Test
	public void selectEmpName() {
		String result = EmpSelectDao.selectEmpName("2024001");
		assertNotEquals(0, result);
	}
//	@Test
	public void selectJob() {
		String result = EmpSelectDao.selectJob("김지훈");
		assertNotEquals(0, result);
	}
//	@Test
	public void selectTeam() {
		String result = EmpSelectDao.selectTeam("김지훈");
		assertNotEquals(0, result);
	}
//	@Test
	public void selectPosition() {
		String result = EmpSelectDao.selectPosition("김지훈");
		assertNotEquals(0, result);
	}
//	@Test
	public void selectEdu() {
		String result = EmpSelectDao.selectEdu("김지훈");
		assertNotEquals(0, result);
	}
//	@Test
	public void selectHireY() {
		int result = EmpSelectDao.selectHireY("김지훈");
		assertNotEquals(0, result);
	}
//	@Test
	public void selectBirth() {
		int result = EmpSelectDao.selectBirth("김지훈");
		assertNotEquals(0, result);
	}
	
//	@Test
	public void selId_Name_Test() {
		EmpVo vo = new EmpVo();
		vo.setEmp_id(2024001);
		vo.setEmp_name("김지훈");
		List<EmpVo> lists = EmpSelectDao.selId_Name(vo);
		assertNotEquals(0, lists.size());
		
	}

	@SuppressWarnings("serial")
	@Test
	public void selId_Bank_Test() {
		Map<String, Object> map = new HashMap<String, Object>(){{put("pid","234-567-8901");}};
		EmpVo vo = EmpSelectDao.selId_Bank(map);
		System.out.println(map);
		assertNotNull(vo);
	}
	

	
	
	
	
	
}








