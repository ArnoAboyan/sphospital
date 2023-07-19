//package com.hospital.sphospital.services;
//
//
//import DAO.DAOException;
//import DAO.impl.DoctorDao;
//import entitys.Doctor;
//import entitys.Role;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.apache.log4j.Logger;
//
//public class LoginCommand implements Command {
//
//    static final Logger logger = Logger.getLogger(LoginCommand.class);
//
//    @Override
//    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DAOException, CommandException {
//        logger.info("Execute ==> LoginCommand...");
//
//
//
//        //CREATE NEW USER SESSION//
//        if (req.getSession().getAttribute("currentUser") == null) {
//
//
//            String login = req.getParameter("login");
//            logger.info("login ==> " + login);
//
//            String passwordInPut = req.getParameter("password");
//            logger.debug("passwordInPut ==>" + passwordInPut);
//
//
//            if (login ==null && passwordInPut ==null){
//                return "index.jsp";
//            }
//
//            DoctorDao doctorDao = new DoctorDao();
//            Doctor doctor = doctorDao.getByLogin(login);
//
//
//            if (doctor.getLogin() == null) {
//                logger.error("user = null");
//                throw new CommandException("Can not find user by Login");
//            } else {
//                logger.debug("get doctor not null");
//                String originalPassword = doctor.getPassword();
//                logger.debug("originalPassword ==>" + originalPassword);
//
//                if (passwordInPut.equals(originalPassword)) {
//                    req.getSession().setAttribute("currentUser", doctor);
//
//
//
//                    Role role = doctor.getRole();
//                    logger.info("Get user with role = " + role.getTitle());
//
//                    if (role.getTitle().equalsIgnoreCase("admin")) {
//                        logger.info("Continue with role ==> Admin");
//                        return "controller?command=adminpagecommand&page=1";
//                    } else if (role.getTitle().equalsIgnoreCase("doctor")) {
//                        logger.info("Continue with role ==> Doctor");
//                        return "controller?command=patientlistbydoctor&page=1&patientsfordoctorid=" + doctor.getDoctorId();
//                    } else if (role.getTitle().equalsIgnoreCase("nurse")) {
//                        logger.info("Continue with role ==> Nurse");
//                        return "controller?command=hospitalcardlist&page=1";
//                    }
//
//                } else {
//                    throw new CommandException("password wrong");
//                }
//            }
//            return "error!!!.html";
//        }
//
//      //WORK WITH ACTUAL USER//
//        Doctor currentUser = (Doctor) req.getSession().getAttribute("currentUser");
//        Role role = currentUser.getRole();
//
//        logger.info("Get user with role = " + role.getTitle());
//
//        if (role.getTitle().equalsIgnoreCase("admin")) {
//            logger.info("Continue with role ==> Admin");
//            return "controller?command=adminpagecommand&page=1";
//        } else if (role.getTitle().equalsIgnoreCase("doctor")) {
//            logger.info("Continue with role ==> Doctor");
//            return "controller?command=patientlistbydoctor&page=1&patientsfordoctorid=" + currentUser.getDoctorId();
//        } else if (role.getTitle().equalsIgnoreCase("nurse")) {
//            logger.info("Continue with role ==> Nurse");
//            return "controller?command=hospitalcardlist&page=1";
//        }
//        return "index.jsp";
//    }
//}