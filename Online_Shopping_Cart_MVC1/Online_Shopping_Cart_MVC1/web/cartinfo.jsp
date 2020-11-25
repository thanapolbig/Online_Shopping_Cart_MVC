<%-- 
    Document   : cartinfo
    Created on : Nov 26, 2020, 1:52:21 AM
    Author     : ASUS
--%>
<%@page import="model.Catalog"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Vector"%>
<%@page import="model.Cart"%>
<%
    Cart cart = (Cart) session.getAttribute("cart");
    
    if (cart == null){
        cart = new Cart();
        session.setAttribute("cart", cart);
    }
    Vector items = cart.getItem();
    if(items.size() != 0){
    
%>
<h1>Cart</h1>
<br>
<table border="4">
    <tr><th>DVD name<th>Rate<th>Year<th>Price<th>Quantity<th>Remove
<!--            <th>DVD name</th>
            <th>Rate</th>
            <th>Year</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Remove</th>
          </tr>          -->
    <%
        int numItem = items.size();
        //NumberFormat currency = NumberFormat.getCurrencyInstance();
        for(int i = 0; i < numItem; i++){
            Catalog item = (Catalog) items.elementAt(i);
    %>
            <tr>
            <form name="removeItem" action="removeItem" method="POST">
                <td><%= item.getDvdnames() %></td>
                <td><%= item.getRate() %></td>
                <td><%= item.getYearr() %></td>
                <td><%= item.getPrice() %></td>
                <td><%= item.getQuantity() %></td>
                <td>
                    <input type="hidden" name="item" value='<%= i %>' />
                    <input type="submit" value="remove" name="remove" />
            </form>
            </tr>
    <%  
        }
    %>
</table>
<form name="checkout "action="checkout" method="POST">
    <input type="submit" value="checkout" name="checkout" />
</form> 
<%
    }
%>
