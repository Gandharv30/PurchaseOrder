package com.iris.daos;
import com.iris.models.*;

import java.util.List;

public interface PuchaseOrderDao {
	public boolean addPO(PurchaseOrder POobj);
	public List<PurchaseOrder> viewAllPo();

}
