<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="controller.IdentityHelper" %>
<%@ page import="model.DriverIdentity" %>
<%@ page import="model.PassengerIdentity" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Identities</title>
</head>
<body>
    <h1>View Identities</h1>
    
    <h2>Driver Identities</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <%
            IdentityHelper identityHelper = new IdentityHelper();
            List<DriverIdentity> driverIdentities = identityHelper.showAllIdentities(DriverIdentity.class);
            
            for (DriverIdentity driver : driverIdentities) {
        %>
        <tr>
            <td><%= driver.getId() %></td>
            <td><%= driver.getDriverFName() %></td>
            <td><%= driver.getDriverLName() %></td>
        </tr>
        <%
            }
        %>
    </table>
    
    <h2>Passenger Identities</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <%
            List<PassengerIdentity> passengerIdentities = identityHelper.showAllIdentities(PassengerIdentity.class);
            
            for (PassengerIdentity passenger : passengerIdentities) {
        %>
        <tr>
            <td><%= passenger.getId() %></td>
            <td><%= passenger.getPassengerFName() %></td>
            <td><%= passenger.getPassengerLName() %></td>
        </tr>
        <%
            }
        %>
    </table>
    
    <p><a href="AddIdentities.html">Back to Add Identities</a></p>
</body>
</html>


