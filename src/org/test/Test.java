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
		Kcb kc=new Kcb();                           		// ����POJO�����
		kc.setKch("110");                           	 	// ���ÿγ̺�
		kc.setKcm("Java");                          	// ���ÿγ���
		kc.setKxxq(new Short(new Integer(5).shortValue()));         	// ���ÿ�ѧѧ��
		kc.setXf(new Integer(4));           	// ����ѧ��
		kc.setXs(new Integer(59));          
		session.save(kc);
		Query query=session.createQuery("from Kcb");
		List list=query.list();
		for(int i=0;i<list.size();i++){
		Kcb kcb = (Kcb) list.get(i);
		System.out.println("�γ�����"+ kcb.getKcm());
		}
		ts.commit();
		HibernateSessionFactory.closeSession();

		
	}

}
