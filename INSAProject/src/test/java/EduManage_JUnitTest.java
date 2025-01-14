

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.EduDto;
import com.min.edu.repository.EduManageDaoImpl;
import com.min.edu.repository.IEduManageDao;

public class EduManage_JUnitTest {

	private IEduManageDao dao;
	
	@Before
	public void createDao() {
		dao = new EduManageDaoImpl();
	}

//	@Test
	public void getAllProcess() {
		List<EduDto> list = dao.getAllProcess();
		assertNotEquals(0, list.size());
	}
	
//	@Test
	public void getProcessInfo() {
		String stu_name = "김지원";
		List<EduDto> list = dao.getProcessInfo(stu_name);
		assertNotNull(list);
	}
	
	@SuppressWarnings("serial")
//	@Test
	public void updateConf() {
		Map<String, Object> map = new HashMap<String, Object>() {
			{
				put("teach_conf", "Y");
				put("stu_conf", "Y");
				put("confirm", "Y");
				put("seq", 9);
			}
		};
		boolean isc = dao.updateConf(map);
		assertNotEquals(false, isc);
	}
	
//	@Test
	public void getNotConfirm() {
		String name = "김지원";
		List<EduDto> list = dao.getNotConfirm(name);
		assertNotEquals(0, list.size());
	}
	
//	@Test
	public void getAllPay() {
		List<EduDto> list = dao.getAllPay();
		assertNotEquals(0, list.size());
	}
	
//	@Test
	public void getPayInfo() {
		String name = "김지원";
		List<EduDto> list = dao.getPayInfo(name);
		assertNotEquals(0, list.size());

	}
	
//	@Test
	public void getAllCheck() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", "김지원");
		map.put("role1", "Y");
		map.put("role2", "학생");
		
		List<EduDto> list = dao.getAllCheck(map);
		assertNotEquals(0, list.size());
	}
	
//	@Test
	public void getCheckInfo() {
		String seq = "seq";
		EduDto dto = dao.getCheckInfo(seq);
		assertNotEquals(0, dto);
	}
	
//	@Test
	public void delCheck() {
		String seq = "1";
		int n = dao.DelCheck(seq);
		assertNotEquals(0, n);
	}
	
	@Test
	public void insertLec() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lec_code", 20);
		map.put("stu_id", 104);
		map.put("day", "월");
		map.put("hour", 15);
		int n = dao.insertProcess(map);
		assertEquals(8, n);
	}
	

}










