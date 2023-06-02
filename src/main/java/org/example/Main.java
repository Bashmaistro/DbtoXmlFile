package org.example;

import com.opencsv.CSVWriter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.xml.bind.JAXBException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Main {


    public static String Fullname(person person){

        String fullName;
        if (person.person_Mname != null) {
            fullName = person.person_Fname + " " + person.person_Mname + " " + person.person_Lname;
        } else {
            fullName = person.person_Fname  + person.person_Lname;
        }

        return fullName;

    }
    public static void main(String[] args) throws JAXBException, ParseException {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");


        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();


        //Person
        List<person> people = session.createQuery("FROM person").list();
        List<customer> customers = session.createQuery("from customer ").list();
        List<delivery> deliveries = session.createQuery("FROM delivery ").list();
        List<employee> employees = session.createQuery("FROM employee ").list();
        List<payment> payments = session.createQuery("FROM payment ").list();
        List<shoe> shoes = session.createQuery("FROM shoe ").list();
        List<stockin> stockins = session.createQuery("FROM stockin ").list();
        List<stockused> stockuseds = session.createQuery("FROM stockused ").list();
        List<supplier> suppliers = session.createQuery("FROM supplier ").list();
        List<telephonenumber> telephonenumbers = session.createQuery("FROM telephonenumber ").list();




        // CSV dosyasını oluşturmak için FileWriter kullanın
        try (CSVWriter writer = new CSVWriter(new FileWriter("people.csv"))) {
            // CSV başlıklarını yazın
            String[] header = {"Name", "Bdate", "Address","Gender","Telephone"};
            writer.writeNext(header);


            for (person person : people) {


                String[] rowData = {Fullname(person), String.valueOf(person.person_Bdate), person.person_Adress, person.person_Gender, String.valueOf(person.telephone)};
                writer.writeNext(rowData);
            }

            System.out.println("CSV dosyası oluşturuldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("customer.csv"))) {
            // CSV başlıklarını yazın
            String[] header = {"Name", "Bdate", "Address","Gender","Telephone", "SSN" , "Customer Id"};
            writer.writeNext(header);


            for (customer customer : customers) {


                String[] rowData = {Fullname(customer.person), String.valueOf(customer.person.person_Bdate), customer.person.person_Adress, customer.person.person_Gender, String.valueOf(customer.person.telephone),String.valueOf(customer.person.SSN), String.valueOf(customer.cust_id)};
                writer.writeNext(rowData);
            }

            System.out.println("CSV dosyası oluşturuldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("employee.csv"))) {
            // CSV başlıklarını yazın
            String[] header = {"Employee Id" , "Employee Status", "Employee Salary", "Employee DateIn","Name", "Bdate", "Address","Gender","Telephone", "SSN" , "Employee Id" , "Employee Status", "Employee Salary", "Employee DateIn"};
            writer.writeNext(header);


            for (employee employee : employees) {

                String[] rowData = {String.valueOf(employee.emp_id),employee.emp_status, String.valueOf(employee.emp_salary), String.valueOf(employee.emp_datein),Fullname(employee.person), String.valueOf(employee.person.person_Bdate), employee.person.person_Adress, employee.person.person_Gender, String.valueOf(employee.person.telephone),String.valueOf(employee.person.SSN), };
                writer.writeNext(rowData);
            }

            System.out.println("CSV dosyası oluşturuldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("shoe.csv"))) {
            // CSV başlıklarını yazın
            String[] header = {"Shoe ID" , "Shoe Brand Name", "Shoe Gender", "Shoe Cost" , "Shoe Size" , "Shoe Quantity","Shoe Color", "Shoe Type"};
            writer.writeNext(header);


            for (shoe shoe: shoes) {

                String[] rowData = {String.valueOf(shoe.shoe_id), shoe.shoe_brand, shoe.shoe_gender, String.valueOf(shoe.shoe_cost), String.valueOf(shoe.shoe_size), String.valueOf(shoe.shoe_qty), shoe.shoe_color, shoe.shoe_type};
                writer.writeNext(rowData);
            }

            System.out.println("CSV dosyası oluşturuldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter("supplier.csv"))) {
            // CSV başlıklarını yazın
            String[] header = {"Supplier ID","Supplier Name" ,"Supplier Address"};
            writer.writeNext(header);


            for (supplier supplier: suppliers) {

                String[] rowData = {String.valueOf(supplier.supplier_id), supplier.supplier_name, supplier.supplier_adress};
                writer.writeNext(rowData);
            }

            System.out.println("CSV dosyası oluşturuldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter("delivery.csv"))) {
            // CSV başlıklarını yazın
            String[] header = {"Supplier ID","Who Make Takes In" ,"Deliveried Date ", "Deliveried Time"};
            writer.writeNext(header);


            for (delivery delivery: deliveries) {

                String[] rowData = {String.valueOf(delivery.supplier.supplier_id), Fullname(delivery.employee.person), delivery.delivery_date + " " + String.valueOf(delivery.delivery_time).substring(11)};
                writer.writeNext(rowData);
            }

            System.out.println("CSV dosyası oluşturuldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("payment.csv"))) {
            // CSV başlıklarını yazın
            String[] header = {"Customer Name ",  "Customer SSN" , "Payment Amount" ,"Payment Date" , "Who Makes the Sale"};
            writer.writeNext(header);


            for (payment payment: payments) {

                String[] rowData = {Fullname(payment.customer.person) , String.valueOf(payment.customer.person.SSN), String.valueOf(payment.payment_amt), String.valueOf(payment.payment_date), Fullname(payment.employee.person)};
                writer.writeNext(rowData);
            }

            System.out.println("CSV dosyası oluşturuldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("StockIn.csv"))) {
            // CSV başlıklarını yazın
            String[] header = {"Who Makes The Stock In ",  "Stock In Date" , "Stock In Id" , "Stock In Quantity" , "Shoe Brand" , "Shoe Type " , "Shoe Size"};
            writer.writeNext(header);


            for (stockin stockin: stockins) {

                String[] rowData = {Fullname(stockin.employee.person), String.valueOf(stockin.stckin_date), String.valueOf(stockin.stckin_id), String.valueOf(stockin.stckin_qty), stockin.shoe.shoe_brand, stockin.shoe.shoe_type , String.valueOf(stockin.shoe.shoe_size)};
                writer.writeNext(rowData);
            }

            System.out.println("CSV dosyası oluşturuldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (CSVWriter writer = new CSVWriter(new FileWriter("StockUsed.csv"))) {
            // CSV başlıklarını yazın
            String[] header = {"Who Makes The Stock Out ",  "Stock Out Date" , "Stock Out Id" , "Stock Out Quantity" , "Shoe Brand" , "Shoe Type " , "Shoe Size"};
            writer.writeNext(header);


            for (stockused stockused: stockuseds) {

                String[] rowData = {Fullname(stockused.employee.person), String.valueOf(stockused.stckused_date), String.valueOf(stockused.stckused_id), String.valueOf(stockused.stckused_qty), stockused.shoe.shoe_brand, stockused.shoe.shoe_type , String.valueOf(stockused.shoe.shoe_size)};
                writer.writeNext(rowData);
            }

            System.out.println("CSV dosyası oluşturuldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }









        //##############################
        //##############################
        //######FOR QUARIES#############
        //##############################
        //##############################

        //######################################################################
        //######################################################################
        //•	What are the top-selling shoe models and sizes in the last quarter?
        //######################################################################
        //######################################################################

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");



            Date startDate = dateFormat.parse("2023-01-01");
            java.util.Date endDate = dateFormat.parse("2023-05-31");


        String hql = "FROM stockused WHERE stckused_date BETWEEN :startDate AND :endDate";
        Query<stockused> query = session.createQuery(hql);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<stockused> bestSllr = query.list();
        Collections.sort(bestSllr, Comparator.comparing(stockused::getStckused_qty));


        try (CSVWriter writer = new CSVWriter(new FileWriter("BestSellerForQuarter.csv"))) {
            // CSV başlıklarını yazın
            String[] header = {"Shoe Brand",  "Shoe Type" , "Shoe Size" };
            writer.writeNext(header);

            for (int i = 0; i < 20; i++) {
                String[] rowData = {bestSllr.get(i).shoe.shoe_brand, bestSllr.get(i).shoe.shoe_type, String.valueOf(bestSllr.get(i).shoe.shoe_size)};
                writer.writeNext(rowData);
            }





            System.out.println("CSV dosyası oluşturuldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        //######################################################################
        //######################################################################
        //•	What is the average purchase amount for the last month?
        //######################################################################
        //######################################################################


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date startDateq2 = calendar.getTime();

        // Şu anki zamanı alın
        Date endDateq2 = new Date();


        String hqlq2 = "FROM payment WHERE payment_date BETWEEN :startDateq2 AND :endDateq2";
        Query<payment> queryq2 = session.createQuery(hqlq2);
        queryq2.setParameter("startDateq2", startDateq2);
        queryq2.setParameter("endDateq2", endDateq2);
        List<payment> avg = queryq2.list();

        int averageValue = 0;

        for (payment payment : avg) {

            averageValue = (int) (averageValue + payment.payment_amt);

        }

        averageValue = averageValue/avg.size();



        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ortalama_deger.txt"))) {
            writer.write(averageValue);
        } catch (IOException e) {
            System.out.println("Dosya yazma hatası: " + e.getMessage());
        }

        //######################################################################
        //######################################################################
        //•	What is the average purchase amount for the last month?
        //######################################################################
        //######################################################################




        session.close();
        sessionFactory.close();
    }
}