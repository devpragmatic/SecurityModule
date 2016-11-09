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
    public UserGroupDTO convertToDTO(UserGroup userGroup){
        if(userGroup == null)
            return null;
        UserGroupDTO userGroupDTO = new UserGroupDTO();
        userGroupDTO.setId(userGroup.getId());
        userGroupDTO.setName(userGroup.getName());
        return userGroupDTO;
    }
    
    /**
     * Convering list of userGroup object to list of usertGroupDTO object
     * @param userGroups objects with values to convert
     * @return list of object DTO
     */
    public List<UserGroupDTO> convertToDTO(List<UserGroup> userGroups){
        if(userGroups == null)
            return null;
        List<UserGroupDTO> userGroupDTOs = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(userGroups)){
            userGroups.stream().forEach((userGroup) -> {
                userGroupDTOs.add(UserGroupFactory.this.convertToDTO(userGroup));
            });
        }
        return userGroupDTOs;
    }
}
