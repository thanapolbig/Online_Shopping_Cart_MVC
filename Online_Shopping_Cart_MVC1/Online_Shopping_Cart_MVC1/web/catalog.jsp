<%-- 
    Document   : Catalog
    Created on : Nov 26, 2020, 1:28:34 AM
    Author     : ASUS
--%>

<%@page import="model.CatalogTable"%>
<%@page import="model.Catalog"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Vector"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="dc" class="model.Catalog" scope="request"/>
    <%
            EntityManager em = (EntityManager) session.getAttribute("Online_Shopping_Cart_MVC1PU");
            Vector<Catalog> dcList = CatalogTable.findAllDvd();
            Iterator<Catalog> itr = dcList.iterator();
    %>
    <body>
        <center>
<h1>DVD Catalog</h1>
 <table border="1">
     <thread>
          <tr>
            <th>DVD name</th>
            <th>Rate</th>
            <th>Year</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>AddCart</th>
          </tr></thread>
          <%
               while(itr.hasNext()) {
                   dc = itr.next();
                   //String Quantity = "Quantity";
          %>
          <tr>
          <form name="AddCart"action="AddCart" method="POST">
              <td><%= dc.getDvdnames() %></td>
              <td><%= dc.getRate() %></td>
              <td><%= dc.getYearr() %></td>
              <td><%= dc.getPrice() %></td>
              <td><input type="text" name="Quantity"  size="5" /></td>
              <td>
                  <input type="hidden" name="Name" value='<%= dc.getDvdnames() %>'>
                  <input type="hidden" name="Rate" value='<%= dc.getRate() %>'>
                  <input type="hidden" name="Year" value='<%= dc.getYearr() %>'>
                  <input type="hidden" name="Price" value='<%= dc.getPrice() %>'>
                  <input type="submit" value="addCart" name="addCart" />
              </td>
          </form>
          </tr>
          <%
               }
          %>
 </table>
          <jsp:include page="cartinfo.jsp" flush="true" />
 </center>
    </body>
</html>
