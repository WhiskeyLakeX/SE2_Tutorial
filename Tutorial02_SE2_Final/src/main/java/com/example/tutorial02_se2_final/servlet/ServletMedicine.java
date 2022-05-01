package com.example.tutorial02_se2_final.servlet;
import com.example.tutorial02_se2_final.dao.MedicineDAO;
import com.example.tutorial02_se2_final.entity.Medicine;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletMedicine", value = "/")
public class ServletMedicine extends HttpServlet {
    private MedicineDAO medicineDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        medicineDAO = new MedicineDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        displayMedicine(request, response);
    }

    private void displayMedicine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get data from book table
        List<Medicine>  medicineList = medicineDAO.selectMedicine();
        // send (pass) this table to the front end (JSP)
        request.setAttribute("medicines", medicineList);
        //render the webpage (JSP)
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewmedicine.jsp");
        requestDispatcher.forward(request,response);
    }

    //addMedicine.jsp

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        deleteMedicine(request,response);
    }

    private void deleteMedicine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get data from user
        String delete_id = request.getParameter("deleted_medicine_id");
        MedicineDAO dao = new MedicineDAO();
        dao.deleteMedicine(Integer.parseInt(delete_id));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewmedicine.jsp");
        requestDispatcher.forward(request,response);
    }
}
