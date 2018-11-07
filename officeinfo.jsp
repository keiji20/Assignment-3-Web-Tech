<%-- 
    Document   : officeinfo.jsp
    Created on : Nov 6, 2018, 12:41:12 AM
    Author     : Keiji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Office Directory</title>
    </head>
    <body>
        <h1>Portfolio and Staff</h1>
        <form action="./OfficeServlet" method="POST">
            <table>
                <tr>
                    <td>Office ID</td>
                    <td><input type="text" name="officeId" value="${office.officeId}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="firstname" value="${office.lastname}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="lastname" value="${office.firstname}" /></td>
                </tr>
                <tr>
                    <td>Center</td>
                    <td><input type="text" name="centre" value="${office.centre}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>                
                </tr>            
            </table>
        </form>        
        <br>
        <table border="1">
            <th>Office ID</th>
            <th>Last Name</th>
            <th>First Name</th>
            <th>Centre</th>
            <c:forEach items="${allOffices}" var="stud">
                <tr>
                    <td>${stud.officeId}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.centre}</td>
                </tr>
            </c:forEach>
        </table>  
    </body>
</html>
