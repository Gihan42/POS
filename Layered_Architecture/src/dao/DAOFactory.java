package dao;

import dao.custom.CustomerDao;
import dao.custom.impl.*;
import model.CustomerDTO;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    //singleton
    public static DAOFactory getDaoFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    //public final static integer values
    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDERDETAILS, QUERYDAO
    }

    //method for hide the object creation logic and return what client wants
    public SuperDao getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl(); //SuperDAO superDAO=new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl(); //SuperDAO superDAO=new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl(); //SuperDAO superDAO = new OrderDAOImpl();
            case ORDERDETAILS:
                return new OderDetailsDAOImpl(); //SuperDAO superDAO = new OrderDetailsDAOImpl();
            case QUERYDAO:
                return new QueryDaoImpl(); //SuperDAO superDAO = new QueryDAOImpl();
            default:
                return null;
        }
    }
}

