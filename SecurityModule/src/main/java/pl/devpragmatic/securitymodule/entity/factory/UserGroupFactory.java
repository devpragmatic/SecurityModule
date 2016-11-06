package pl.devpragmatic.securitymodule.entity.factory;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import pl.devpragmatic.securitymodule.context.UserGroupDTO;
import pl.devpragmatic.securitymodule.entity.UserGroup;

/**
 * Factory for UserGroup and UserGroupDTO
 * @author devpragmatic
 */
@Component
public class UserGroupFactory {
    
    /**
     * Convering userGroup object to usertGroupDTO object
     * @param userGroup object with values to convert
     * @return object DTO
     */
    public UserGroupDTO convertUserGroupToUserGroupDTO(UserGroup userGroup){
        if(userGroup == null)
            return null;
        UserGroupDTO userGroupDTO = new UserGroupDTO();
        userGroupDTO.setId(userGroup.getId());
        userGroupDTO.setName(userGroup.getName());
        return userGroupDTO;
    }
    
    public List<UserGroupDTO> convertListUserGroupToListUserGroupDTO(List<UserGroup> userGroups){
        if(userGroups == null)
            return null;
        List<UserGroupDTO> userGroupDTOs = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(userGroups)){
            userGroups.stream().forEach((userGroup) -> {
                userGroupDTOs.add(convertUserGroupToUserGroupDTO(userGroup));
            });
        }
        return userGroupDTOs;
    }
}
