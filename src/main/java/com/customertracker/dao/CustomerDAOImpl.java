package com.customertracker.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.customertracker.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> query=session.createQuery("from Customer order by firstName",Customer.class);
		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		session.save(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Customer.class, customerId);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		session.update(customer);		
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", customerId);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String searchText) {
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> query=null;
		if(searchText!=null && searchText.trim().length()>0) {
			query=session.createQuery("from Customer where lower(firstName) like :searchText or lower(lastName) like :searchText or lower(email) like :searchText",Customer.class);
			query.setParameter("searchText","%"+searchText.toLowerCase()+"%");
		}
		else {
			query=session.createQuery("from Customer",Customer.class);
		}
		return query.getResultList();
	}
}
