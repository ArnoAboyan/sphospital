//package com.hospital.sphospital.services;
//
//import DAO.DAOException;
//import DAO.impl.AppointmentDao;
//import entitys.Appointment;
//import entitys.Doctor;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.apache.log4j.Logger;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class AppointmentListCommand implements Command {
//
//    static final Logger logger = Logger.getLogger(AppointmentListCommand.class);
//
//    @Override
//    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DAOException, CommandException, SQLException {
//        logger.info("Execute ==> AppointmentListCommand...");
//
//        //check role
//        Doctor user = (Doctor) req.getSession().getAttribute("currentUser");
//
//        if (user == null) {
//            return "index.jsp";
//        }
//
//        String role = user.getRole().getTitle();
//
//        if (!role.equalsIgnoreCase("admin")) {
//            logger.error("Check role " + role + " FALSE");
//            return "error.html";
//        }
//
//        logger.info("Check role " + role + " CORRECT");
//
//        String sort = req.getParameter("sort");
//        logger.info("get sort" + sort);
//        AppointmentDao appointmentDao = new AppointmentDao();
//        if (sort == null) {
//            logger.info("execute without sort");
//            return executeWithOutSort(req, appointmentDao);
//        } else {
//            logger.info("execute with sort");
//            return executeWithSort(req, appointmentDao, sort);
//        }
//    }
//
//    //execute without sort//
//    public String executeWithOutSort(HttpServletRequest req, AppointmentDao appointmentDao) throws DAOException, CommandException, SQLException {
//
//
//        String page = req.getParameter("page");
//        logger.info("get page" + page);
//        int i = Integer.parseInt(page);
//        List<Appointment> appointmentList = appointmentDao.getAllWithLimit(i, 5);
//        logger.info("appointmentList " + appointmentList);
//        int countPage = (int) Math.ceil((double) appointmentDao.getCountPatient() / 5);
//        logger.info("countPage =  " + countPage);
//        if (appointmentList == null) {
//            logger.error("appointmentList = null");
//            throw new CommandException("Can`t get patients");
//        } else {
//            req.getSession().setAttribute("appointment", appointmentList);
//            req.setAttribute("page", page);
//            req.setAttribute("countPage", countPage);
//            logger.info("req.setAttributes => Correct");
//            return "appointmentlist.html";
//        }
//    }
//
//
//    public String executeWithSort(HttpServletRequest req, AppointmentDao appointmentDao, String sort) throws DAOException, CommandException {
//
//        String page = req.getParameter("page");
//        logger.info("get page" + page);
//        int i = Integer.parseInt(page);
//        List<Appointment> appointmentList = appointmentDao.getAllWithLimitAndOrderBy(i, 5, sort);
//        int countPage = (int) Math.ceil((double) appointmentDao.getCountPatient() / 5);
//        logger.info("countPage =  " + countPage);
//        if (appointmentList == null) {
//            logger.error("appointmentList = null");
//            throw new CommandException("Can`t get patients");
//        } else {
//            req.getSession().setAttribute("appointment", appointmentList);
//            req.setAttribute("page", page);
//            req.setAttribute("countPage", countPage);
//            req.setAttribute("sort", sort);
//            logger.info("req.setAttributes => Correct");
//            return "appointmentlist.html";
//        }
//    }
//
//
//}
