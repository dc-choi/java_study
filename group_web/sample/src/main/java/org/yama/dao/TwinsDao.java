package org.yama.dao;

import org.yama.model.Twins;

import java.util.List;
import java.util.Map;

public interface TwinsDao {
    int getTwinCnt();
    List<Twins> getTwinsList();
}
