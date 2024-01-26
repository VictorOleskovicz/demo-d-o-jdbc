package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import module.entities.Department;
import module.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===== 1st test, find by Id ====== ");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller + "\n");
		
		System.out.println("==== 2nd test, find by Department ==== ");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDep(dep);
		for (Seller sellers : list) {
			System.out.println(sellers + "\n");
		}
		
		System.out.println("==== 3rd test, find all ==== ");
		list = sellerDao.findAll();
		for (Seller sellers : list) {
			System.out.println(sellers);
		}
		
	}

}
