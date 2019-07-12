package com.sure.mi.service;

import com.sure.mi.mapper.OverviewMapper;
import com.sure.mi.model.Overview;
import com.sure.mi.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class OverviewServiceImpl implements OverviewService{

    @Override
    public List<Overview> selectAllOverview() {
        try {
            SqlSession sqlSession = DBUtil.getSession();
            OverviewMapper overviewMapper = sqlSession.getMapper(OverviewMapper.class);
            return overviewMapper.selectAllOverview();
        }
        catch (Exception e) {
            return null;
        }
    }
}
