/*package com.niit.shoppingcart.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shopingcart.dao.ProductDAO;
import com.niit.shopingcart.domain.Product;

public class ProductController2 {
	@Autowired
	ProductDAO pdao;
	@RequestMapping(name="/AddProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("prdt")Product prdt, HttpServletRequest request,RedirectAttributes attributes)
	{
	
		pdao.save(prdt);

		//copy absolute path of image folder from the drive and use in the below given format.

		String path="E:\\niitprojects\\shoppingcartfrontend\\src\\main\\webapp\\resources\\images";
		path=path+String.valueOf(prdt.getId())+".jpg";
		File f=new File(path);
	
		MultipartFile filedet=prdt.getPimage();
		
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}
		
		
		return "Product";
	}

}
*/