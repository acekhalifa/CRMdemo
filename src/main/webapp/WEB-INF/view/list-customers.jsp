<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.projectcrm.util.SortUtils" %>


<!DOCTYPE html>

<html>

    <head>
        <title>List Customers</title>

        <!-- reference our style sheet -->

        <link type="text/css"
              rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/style.css" />

    </head>

    <body>

        <div id="wrapper">
            <div id="header">
                <h2>CRM - Customer Relationship Manager</h2>
            </div>
        </div>

        <div id="container">

            <div id="content">

                <input type="button" value="Add Customer"
                       onclick="window.location.href = 'showFormForAdd'; return false;"
                       class="add-button"
                       />
                <!--  add our html table here -->

                <c:url var="sortLinkFirstName" value="/customer/list" >
                    <c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME)%>"/>
                        </c:url>
                <c:url var="sortLinkLastName" value="/customer/list" >
                    <c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME)%>"/>
                        </c:url>
                <c:url var="sortLinkEmail" value="/customer/list" >
                    <c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL)%>"/>
                        </c:url>
                <table>
                    <tr>
                        <th><a href="${sortLinkFirstName}">First Name</a></th>
                        <th><a href="${sortLinkLastName}">Last Name</a></th>
                        <th><a href="${sortLinkEmail}">Email</a></th>
                        <th>Action</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="tempCustomer" items="${customers}">
                        
                        <c:url var="updateLink" value="/customer/showFormUpdate" >
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>
                        
                        <c:url var="deleteLink" value="/customer/showFormDelete" >
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>
                        <tr>
                            <td> ${tempCustomer.firstName} </td>
                            <td> ${tempCustomer.lastName} </td>
                            <td> ${tempCustomer.email} </td>
                            <td>
                                <!-- display the update link -->
                                <p><a href="${updateLink}">Update</a> 
                                    | <a href="${deleteLink}" 
                                      onclick="if(!(confirm('Are you sure you want to delete?'))) return false;">Delete</a></p> 
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>

        </div>


    </body>

</html>









