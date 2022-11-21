/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.daoImpl;

import com.company.daoInter.AbstractDao;
import static com.company.daoInter.AbstractDao.connect;
import com.company.daoInter.CountryDaoInter;
import com.company.entity.Country;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anar
 */
public class CountryDaoImpl extends AbstractDao implements CountryDaoInter{
    
    @Override
    public List<Country> getAllCountry() {
        List<Country> result = new ArrayList<>();
        try(Connection c = connect()){
            Statement stmt = c.createStatement();
            stmt.execute("select * from country");
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                int id = rs.getInt("id");
                String nationality  = rs.getString("nationality");
                String name = rs.getString("name");
//                result.add(new Country(id,nationality,name));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

}
