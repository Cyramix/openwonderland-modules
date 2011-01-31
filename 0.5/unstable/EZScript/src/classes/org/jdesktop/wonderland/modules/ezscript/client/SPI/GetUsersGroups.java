/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdesktop.wonderland.modules.ezscript.client.SPI;

import java.util.LinkedHashSet;
import java.util.Set;
import org.jdesktop.wonderland.client.login.LoginManager;
import org.jdesktop.wonderland.client.login.ServerSessionManager;
import org.jdesktop.wonderland.modules.ezscript.client.annotation.ReturnableScriptMethod;
import org.jdesktop.wonderland.modules.securitygroups.common.GroupDTO;
import org.jdesktop.wonderland.modules.securitygroups.common.GroupUtils;

/**
 *
 * @author JagWire
 */
@ReturnableScriptMethod
public class GetUsersGroups implements ReturnableScriptMethodSPI {

    private String username;
    private ServerSessionManager session;
    private Set<String> groups;

    public String getDescription() {
        return "usage: GetUsersGroups(username);\n"
                +"- grabs the list of groups for a user from the webserver\n"
                +"- returns a Set<String>";
    }

    public String getFunctionName() {
        return "GetUsersGroups";
    }

    public void setArguments(Object[] args) {
        username = (String)args[0];
        session = LoginManager.getPrimary();
        groups = new LinkedHashSet<String>();

    }

    public Object returns() {
        return groups;
    }

    public void run() {
        Set<GroupDTO> userGroups = new LinkedHashSet<GroupDTO>();
        try {
        userGroups.addAll(GroupUtils.getGroupsForUser(session.getServerURL(),
                                                      username,
                                                      false,
                                                      session.getCredentialManager()));
        for(GroupDTO d : userGroups) {
                groups.add(d.getId());
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
