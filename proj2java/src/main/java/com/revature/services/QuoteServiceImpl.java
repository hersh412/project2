package com.revature.services;

import com.revature.daos.QuoteDao;
import com.revature.models.Quote;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    private static final Logger log = LogManager.getLogger(QuoteServiceImpl.class);
    private QuoteDao qd;
    private final double BASE_PRICE = 400.00;
    private final double MALE_MULTIPLIER = 1.0;
    private final double FEMALE_MULTIPLER = 0.95;
    private final double SPORTS_CAR_MULTIPLIER = 1.2;
    private final double SUV_LUX_MULTIPLIER = 1.1;
    private final double EVERYTHING_ELSE_MULTIPLIER = 1.0;


    public QuoteServiceImpl() {
    }

    public QuoteServiceImpl(QuoteDao qd) {
        this.qd = qd;
    }

    @Override
    public void addQuote(Quote q) {
        qd.saveQuote(q);
    }

    @Override
    public Double generateQuote(Quote q) {
    double ret = 0;
    ret += BASE_PRICE;

        switch (q.getAge()) {
            case "Under 18":
                ret += ret + 3000;
                break;
            case "18-21":
                ret += 2750;
                break;
            case "22-25":
                ret += 2000;
                break;
            case "26-30":
                ret += 1000;
                break;
            case "31-35":
                ret += 750;
                break;
            case "36-45":
                ret += 750;
                break;
            case "46-55":
                ret += 500;
                break;
            default:
                ret += 500;
                break;
        }

    if (q.getGender().equals("Male"))
        ret += ret * MALE_MULTIPLIER;
    else
        ret += ret * FEMALE_MULTIPLER;

    switch (q.getVehicleClass()) {
        case "Sports Car":
            ret += ret * SPORTS_CAR_MULTIPLIER;
            break;
        case "SUV":
            ret += ret * SUV_LUX_MULTIPLIER;
            break;
        case "Luxury":
            ret += ret * SUV_LUX_MULTIPLIER;
            break;
        default:
            ret += ret * EVERYTHING_ELSE_MULTIPLIER;
            break;
    }

    addQuote(q); //save to db
    return ret;
    }

    @Override
    public List getAllQuotes() {
        return null;
    }

    @Autowired
    public void setQd(QuoteDao qd) {
        this.qd = qd;
    }
}
