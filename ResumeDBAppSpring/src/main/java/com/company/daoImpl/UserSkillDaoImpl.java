/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.daoImpl;

import com.company.daoInter.AbstractDao;
import static com.company.daoInter.AbstractDao.connect;
import com.company.daoInter.UserSkillDaoInter;
import com.company.entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anar
 */
public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter{
    
    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try(Connection c = connect()){
            PreparedStatement stmt = c.prepareStatement("select us.id as userSkillId, u.*, us.skill_id, s.`name` as skill_name, us.power " +
             "from user_skill us " +
             "left join user u on us.user_id = u.id " +
             "left join skill s on us.skill_id = s.id " +
             "where us.user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
               UserSkill u =  getUserSkill(rs);
               result.add(u);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    
     private UserSkill getUserSkill(ResultSet rs)throws Exception{
        int userSkillId = rs.getInt("userSkillId");
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");
//        return new UserSkill(userSkillId, new User(userId), new Skill(skillId, skillName), power);
        return null;
    }

     @Override
    public boolean removeUserSkill(int userId) {
        try(Connection c = connect()){
            PreparedStatement stmt = c.prepareStatement("delete from user_skill where id=?");
            stmt.setInt(1, userId);
            return stmt.execute();
        }catch(Exception ex){
            
        }
        return false;
    }

     @Override
    public boolean insertUserSkill(UserSkill us) {
        try(Connection c = connect()){
            PreparedStatement stmt = c.prepareStatement("insert into user_skill (skill_id,user_id,power) values(?,?,?)");
//            stmt.setInt(1, us.getSkill().getId());
//            stmt.setInt(2, us.getUser().getId());
//            stmt.setInt(3, us.getPower());
            return stmt.execute();
        }catch(Exception ex){
            
        }
        return false;
    }

     @Override
    public boolean updateUserSkill(UserSkill us) {
        try(Connection c = connect()){
            PreparedStatement stmt = c.prepareStatement("update user_skill set user_id=?,skill_id=?,power=? where id=?");
//            stmt.setInt(1, us.getUser().getId());
//            stmt.setInt(2, us.getSkill().getId());
            stmt.setInt(3, us.getPower());
            stmt.setInt(4, us.getId());
            return stmt.execute();
        }catch(Exception ex){
            
        }
        return false;
    }

}
