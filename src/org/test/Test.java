package org.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.model.Kcb;
import org.util.HibernateSessionFactory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Session session=(Session) HibernateSessionFactory.getSession();
		Transaction ts=session.beginTransaction();
		Kcb kc=new Kcb();                           		// 创建POJO类对象
		kc.setKch("110");                           	 	// 设置课程号
		kc.setKcm("Java");                          	// 设置课程名
		kc.setKxxq(new Short(new Integer(5).shortValue()));         	// 设置开学学期
		kc.setXf(new Integer(4));           	// 设置学分
		kc.setXs(new Integer(59));          
		session.save(kc);
		Query query=session.createQuery("from Kcb");
		List list=query.list();
		for(int i=0;i<list.size();i++){
		Kcb kcb = (Kcb) list.get(i);
		System.out.println("课程名："+ kcb.getKcm());
		}
		ts.commit();
		HibernateSessionFactory.closeSession();

		
	}

}
