package ninja.pif.simpleshop.service;

import ninja.pif.simpleshop.model.Bill;

import org.springframework.stereotype.Service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Service("billService")
public class BillService {
	
	Log log = LogFactoryUtil.getLog(getClass());

	public void add(Bill bill) {

		log.info(bill);
		
	}

}
