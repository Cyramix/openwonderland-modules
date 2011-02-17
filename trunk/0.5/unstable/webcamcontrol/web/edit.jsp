<%-- 
    Document   : edit
    Author     : Bernard Horan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="/wonderland-web-front/javascript/prototype-1.6.0.3.js" type="text/javascript"></script>
        <link href="/wonderland-web-front/css/base.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="/wonderland-web-front/css/module.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <h2>Modify Webcam Viewer Settings</h2>

        <form id="nameForm" action="/webcamcontrol/webcamcontrol/browse">
            <input type="hidden" name="action" value="change"/>

            <table class="installed" id="runnerTable">
                <tr class="header">
                    <td class="installed"><b>Webcam Viewer Name</b></td>
                    <td class="installed"><b>Webcam Viewer Settings</b></td>
                </tr>
                <tr>
                    <td class="installed">${requestScope['record'].cellName}</td>
                    <td class="installed">
                        
                            Webcam URI: <input type="text" name="cameraURI" value="${record.cameraURI}"/><br />
                            Webcam User: <input type="text" name="cameraUsername" value="${record.cameraUsername}"/><br/>
                            Webcam Password: <input type="password" name="cameraPassword" value="${record.cameraPassword}"/><br/>
                            Webcam status: <input type="radio" name="cameraState" value="PLAYING" 
                                                    <c:if test='${record.cameraState == "PLAYING"}'>
                                                    checked
                                                    </c:if>
                                            /> Playing<br/>
                                            <input type="radio" name="cameraState" value="STOPPED"
                                                   <c:if test='${record.cameraState == "STOPPED"}'>
                                                    checked
                                                    </c:if>/> Stopped<br/>
                                            <input type="radio" name="cameraState" value="PAUSED"
                                                   <c:if test='${record.cameraState == "PAUSED"}'>
                                                    checked
                                                    </c:if>/> Paused
                            <input type="hidden" name="cellID" value="${requestScope['record'].cellID}"/>
                        
                    </td>

                </tr>
            </table>
            <div id="actionLinks">
                <a href="javascript:void(0)" onclick="$('nameForm').submit()">OK</a>
                <a href="/webcamcontrol/webcamcontrol/browse">Cancel</a>
            </div>
        </form>
    </body>
</html>
