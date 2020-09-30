<%--
  Created by IntelliJ IDEA.
  User: KimShin
  Date: 9/30/2020
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../bootstrap-4.5.2-dist/css/bootstrap.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <table cellpadding="2" cellspacing="2" border="1">
        <tr>
            <th>STT</th>
            <th>Name Customer</th>
            <th>Addres Customer</th>
            <th>Number Phone</th>
            <th>Detil</th>
        </tr>

        <c:forEach var="orders" items="${listorder}">
            <tr>
                <td>${orders.orderId}</td>
                <td>${orders.nameCustomer}</td>
                <td>${orders.addressCustomer}</td>
                <td>${orders.numberPhoneCustomer}</td>
                <td>
                    <!-- Button to Open the Modal Delete-->
                    <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#itemdetail${orders.orderId}">
                        Detail
                    </button>
                </td>
            </tr>


            <!-- The Modal Delete -->
            <div class="modal fade" id="itemdetail${orders.orderId}" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <div class="container">
                                <div class="form-group">
                                    <label>Detail Order ${orders.orderId}</label>
                                    <tr>
                                        <th>Name IceCream</th>
                                        <th>Quantity</th>
                                        <th>Price</th>
                                        <th>DisCount</th>
                                    </tr>
                                    <c:forEach var="item" items="${orders.items}">
                                        <tr>
                                            <td>${item.iceCream.name}</td>
                                            <td>${item.quantity}</td>
                                            <td>${item.iceCream.price}</td>
                                            <td>${item.iceCream.discount}</td>
                                        </tr>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </c:forEach>
    </table>





</body>
</html>
<script src="../../../bootstrap-4.5.2-dist/js/bootstrap.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
