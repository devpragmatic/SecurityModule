package pl.devpragmatic.securitymodule.service;

import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import pl.devpragmatic.securitymodule.context.UserContextDTO;
import pl.devpragmatic.securitymodule.context.UserGroupDTO;
import pl.devpragmatic.securitymodule.entity.User;
import pl.devpragmatic.securitymodule.entity.UserGroup;
import pl.devpragmatic.securitymodule.entity.factory.UserGroupFactory;
import pl.devpragmatic.securitymodule.repository.UserGroupRepository;
import pl.devpragmatic.securitymodule.repository.UserRepository;

/**
 * @author devpragmatic
 */
@RunWith(MockitoJUnitRunner.class)
public class SecureServiceImplTest {
    
    @InjectMocks
    private final SecureService secureService = spy(new SecureServiceImpl());
    
    @Mock
    private UserGroupRepository userGroupRepository;
    @Mock
    private UserGroupFactory userGroupFactory;
    @Mock 
    private UserRepository userRepository;
    
    private final String username =  RandomStringUtils.randomAlphanumeric(10);
    
    @Before
    public void setUp(){
        when(secureService.getUserName()).thenReturn(username);
    }
    
    @After
    public void tearDown(){
        Mockito.reset(secureService, userGroupRepository, userGroupFactory, userRepository);
    }

    @Test
    public void whenUseGetUserContextThenSetUserGroupsForResult(){
        Long userId = RandomUtils.nextLong();
        User user = new User();
        user.setUserId(userId);
        when(userRepository.findOneByUsername(username)).thenReturn(user);
        List<UserGroup> userGroups = mock(List.class);
        when(userGroupRepository.findByUser(userId)).thenReturn(userGroups);
        List<UserGroupDTO> userGroupDTOs = mock(List.class);
        when(userGroupFactory.convertListUserGroupToListUserGroupDTO(userGroups)).thenReturn(userGroupDTOs);
        UserContextDTO result = secureService.getUserContext();
        Assert.assertEquals(userGroupDTOs, result.getGroups());
    }
    
    @Test
    public void whenUseGetUserContextThenSetUserNameForResult(){
        UserContextDTO result = secureService.getUserContext();
        Assert.assertEquals(username, result.getUserName());   
    }
    
}
