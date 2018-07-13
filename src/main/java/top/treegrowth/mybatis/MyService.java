package top.treegrowth.mybatis;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.treegrowth.mybatis.mapper.MyMapper;
import top.treegrowth.mybatis.model.My;

import javax.annotation.Resource;

/**
 * @author wusi
 */

@Service
public class MyService {

    @Resource
    private MyMapper myMapper;

//    @Transactional(noRollbackFor = RuntimeException.class)
    @Transactional()
    public void insert() {
        My my = new My();
        my.setId(111);
        my.setName("名字");
        my.setAge(13);
        myMapper.insert(my);
        throw new RuntimeException();
    }
}
