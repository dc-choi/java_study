package org.yama.service;

import org.yama.dao.TwinsDao;
import org.yama.model.Twins;

import java.util.List;
import java.util.Map;

public class TwinsServiceImpl implements TwinsService {
    private TwinsDao twinsDao;

    // 여기에 Setter 주입을 완성하시오...
    public void setTwinsDao(TwinsDao twinsDao) {
        this.twinsDao = twinsDao;
    }

    @Override
    public int total() {
        return twinsDao.getTwinCnt();
    }

    @Override
    public List<Twins> list() {
        return twinsDao.getTwinsList();
    }
}
