package org.lwerl.caloriesmng.service.jdbc;

import org.lwerl.caloriesmng.service.UserServiceTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by lWeRl on 02.03.2017.
 */
@ActiveProfiles({"postgres","jdbc"})
public class JdbcUserServiceTest extends UserServiceTest{
}
