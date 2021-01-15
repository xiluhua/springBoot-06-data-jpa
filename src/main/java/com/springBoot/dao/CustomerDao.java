package com.springBoot.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.alibaba.fastjson.JSON;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.query.internal.QueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.springBoot.dao.query.Customer2;
import com.springBoot.entity.Customer;

@Repository
public class CustomerDao {
	
	// 获取和当前事务相关联的 EntityManager
	@PersistenceContext
	private EntityManager entityManager;
		
	/**
	 * @return Customer
	 */
	@SuppressWarnings("unchecked")
	public List<Map> query11(Integer age)throws Exception {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT new map(c.id as id,c.lastName as lastName,c.createTime as createTime) ");
		jpql.append("FROM Customer c,");
		jpql.append("	  Addresses a ");
		jpql.append("WHERE c.age > :age and c.addr_id = a.id");
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("age",age);
		List<Map> list = this.search(-1, 0, jpql.toString(), map);
		return list;
	}
	
    public List<Map> query13(Integer age)throws Exception {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT c.id as id,c.lastName as lastName,c.createTime as createTime ");
        jpql.append("FROM Customer c,");
        jpql.append("	  Addresses a ");
        jpql.append("WHERE c.age > :age and c.addr_id = a.id");
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("age",age);
        List<Map> list = this.search13(-1, 0, jpql.toString(), map);
        return list;
    }
    
    /**
     *
     * @param paramInt1: FirstResult
     * @param paramInt2: MaxResults
     * @param paramString: hql or jpql
     * @param paramHashMap
     */
	public List search(int paramInt1, int paramInt2, String paramString, HashMap paramHashMap) throws Exception {
		System.out.println("paramHashMap : "+ JSON.toJSONString(paramHashMap));
		Long start = System.currentTimeMillis();
		Query query = entityManager.createQuery(paramString);
		if (paramHashMap != null && paramHashMap.size() > 0)
			this.append(query, paramHashMap);
		if (paramInt1 >= 0 && paramInt2 > 0)
			query.setFirstResult(paramInt1);
		if (paramInt2 > 0)
			query.setMaxResults(paramInt2);
		// 两种写法
		// query11 & query13
		// query13 需要这一行代码配合
        //  query.unwrap(org.hibernate.query.Query.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String, Object>> list = query.getResultList();
        System.out.println("HQL查询记录{Hql=" + paramString + ";参数为:args=" + paramHashMap + ";firstRow=" + paramInt1 + ";maxRows=" + paramInt2 + "}" + " 的执行时间为:" + (System.currentTimeMillis() - start) + "毫秒!");
		return list;
	}

    /**
     *
     * @param paramInt1: FirstResult
     * @param paramInt2: MaxResults
     * @param paramString: hql or jpql
     * @param paramHashMap
     */
    public List search13(int paramInt1, int paramInt2, String paramString, HashMap paramHashMap) throws Exception {
        System.out.println("paramHashMap : "+ JSON.toJSONString(paramHashMap));
        Long start = System.currentTimeMillis();
        Query query = entityManager.createQuery(paramString);
        if (paramHashMap != null && paramHashMap.size() > 0)
            this.append(query, paramHashMap);
        if (paramInt1 >= 0 && paramInt2 > 0)
            query.setFirstResult(paramInt1);
        if (paramInt2 > 0)
            query.setMaxResults(paramInt2);
        // 两种写法
        // query11 & query13
        // query13 需要这一行代码配合
        query.unwrap(org.hibernate.query.Query.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String, Object>> list = query.getResultList();
        System.out.println("HQL查询记录{Hql=" + paramString + ";参数为:args=" + paramHashMap + ";firstRow=" + paramInt1 + ";maxRows=" + paramInt2 + "}" + " 的执行时间为:" + (System.currentTimeMillis() - start) + "毫秒!");
        return list;
    }

	private void append(Query query, HashMap<String, Object> paramHashMap) throws HibernateException {
		for (String str : paramHashMap.keySet()) {
			Object object = paramHashMap.get(str);
			if (object instanceof Collection) {
				query.setParameter(str, (Collection) object);
				continue;
			}
			query.setParameter(str, object);
		}
	}

    /**
     * @return Customer
     */
    @SuppressWarnings("unchecked")
    public List<Customer2> query12() {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT c.id,c.last_name as lastName,c.create_time as createTime ");
        jpql.append("FROM JPA_CUSTOMERS c,");
        jpql.append("	  JPA_ADDRESSES a ");
        jpql.append("WHERE c.age > ? and c.addr_id = a.id");
        Query query = entityManager.createNativeQuery(jpql.toString(),Customer2.class);
        query.setParameter(1, 1);
        List<Customer2> list = query.getResultList();
        return list;
    }

    public Customer merge(Customer entity) {
        return entityManager.merge(entity);
    }
}