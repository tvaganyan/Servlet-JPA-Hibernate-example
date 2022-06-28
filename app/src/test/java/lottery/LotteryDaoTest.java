package lottery;

import lottery.dao.LotteryDao;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

public class LotteryDaoTest {
    LotteryDao lotteryDao;
    @Before
    public void setUp() {
        lotteryDao = LotteryDao.getInstans();
    }

    @Test
    public void ParticipantCount(){
        Assert.assertTrue(lotteryDao.ParticipantCount() >= 0);
    }
}
