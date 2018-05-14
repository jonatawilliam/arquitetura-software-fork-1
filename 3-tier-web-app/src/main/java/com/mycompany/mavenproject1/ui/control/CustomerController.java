
package com.mycompany.mavenproject1.ui.control;

import com.mycompany.mavenproject1.business.CustomerBusiness;
import com.mycompany.mavenproject1.data.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet ("/customerController")
public class CustomerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Customer newCustomer = null;
        try {
            newCustomer = new Customer(
                    0,
                    req.getParameter("inputName"),
                    new Integer(req.getParameter("inputAge")),
                    req.getParameter("inputPhone"),
                    req.getParameter("inputCountry"),
                    new Double(req.getParameter("inputCreditLimit")));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        CustomerBusiness business = new CustomerBusiness();
        
        try {
            business.create(newCustomer);
            req.getSession().setAttribute("customerList", business.readAll());
            
        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
