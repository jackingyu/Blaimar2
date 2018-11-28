package com.third.dao.product.impl;

import java.util.List;

import com.third.dao.generic.GenericDAO;
import com.third.dao.product.SizeAttributeDao;
import com.third.model.SizeAttributeModel;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultSizeAttributeDao extends
		GenericDAO<SizeAttributeModel, String> implements SizeAttributeDao {
	private final static String FIND_BY_ITEMCATEGORY_SQL = "from com.third.model.SizeAttributeModel s where s.itemCategory=?";
	private final static String FIND_BY_ITEMCATEGORYANDGROUP_SQL = "from com.third.model.SizeAttributeModel s where s.itemCategory=? and s.sizeGroup=?";

	@Override
	public List<SizeAttributeModel> findSizeAttributeForItemCategory(
			Integer itemCategory)
	{
		return find(FIND_BY_ITEMCATEGORY_SQL, itemCategory);
	}
	@Override
	public List<SizeAttributeModel> findSizeAttributes(
			Integer itemCategory,Integer group)
	{
		Object[] parameters = {itemCategory,group};
		return find(FIND_BY_ITEMCATEGORYANDGROUP_SQL,parameters);
	}

}
