package application;

import java.time.LocalDate;
import java.util.Date;
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
			System.out.println(sellers + "\n");
		}
		
		System.out.println("==== 4ft test, insert ==== ");

		Seller seller1 = new Seller(null, "Mario", "mario@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(seller1);
		System.out.println("Inserted" + seller1.getId() +  "\n");
		
		System.out.println("==== 5ft test, update ==== ");
		Seller seller2 = sellerDao.findById(1);
		seller2.setName("Maria Bulha");
		sellerDao.update(seller2);
		System.out.println("Done!");
		
	}

}
