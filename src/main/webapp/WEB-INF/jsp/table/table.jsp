<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<jsp:include page="../include/headder.jsp" />

  <body>
       
        <div class="breadcrumbs">
            <div class="breadcrumbs-inner">
                <div class="row m-0">
                    <div class="col-sm-4">
                        <div class="page-header float-left">
                            <div class="page-title">
                                <h1>Management</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="page-header float-right">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="#">Dashboard</a></li>
                               		<li class="active">Add Table</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
               
                <div class="content">
            		<div class="animated fadeIn">
                
                   <div class="card">
                            <div class="card-header">
                                <strong>Register</strong> Table
                            </div>
                            <div class="card-body card-block">
                               
                                <form:form role="form" class="form-inline" action="table.reg" method="post"
                                       name="table_reg" id="table_reg"
                                       modelAttribute="addTable">
                                    <div class="form-group mb-2">
				    					<label for="staticEmail2" class="sr-only">Table Name</label>
				    					<input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Table Name">
				 					</div>
                                    <div class="form-group mx-sm-3 mb-2">
                                    	<label for="tableName" class="sr-only">Table Name</label>
                                    	<form:input type="text" path="tableName"
                                                        class="validate[required] form-control"
                                                        id="table_name" placeholder="Enter Table Name..."
                                                        />
                                            <span style="color: red"><label id="lbl_table_name"></label></span>
                                    </div>
                                    <div class="form-group mx-sm-3 mb-2">
                                    	 <button type="submit" class="btn btn-danger" form="table_reg"
                                                id="register_table_btn" value="Save">Register
                                        </button>
                                   </div>
                                </form:form>
                            </div>
                            
                            </div>
                         
       
                <div class="row">
                    <div class="col-md-12">
                    
                    
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Registered Table</strong>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Table Name</th>
                                        <th>Status</th>
                                        <th>Change Status </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${summary}" var="summary">
                                        <tr>

                                            
                                           <%--  <td>${summary.itemName}</td> --%>
                                            <td>${summary.tableName}</td>
                                            <td>${summary.status}</td>
                                            <th>
                                            	<button type="button" class="btn btn-success">Change</button>
                                            </th>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
             
                       
                    </div>

                </div>
         

</div>
</div>

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" style="color: red"><span class="glyphicon glyphicon-remove-sign"></span>ERROR</h4>
                </div>
                <div class="modal-body">
                    <p id="error" style="color: #0b0b0b; font-size: medium; font-family: 'Raleway', sans-serif"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
    
    </body>
  <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
    <script src="../../resource/static/js/main.js"></script>


    <script !src="">


        $('#register_table_btn').click(function() {
            validateForm();

        });

        function validateForm() {
        	
            var tableName = $('#table_name').val().trim();
          
            if(tableName == "") {
            	$("#error").html("Please fill Table Name required field!");
                $('#myModal').modal("show");
                document.getElementById("table_name").focus();
            }
           

             else {
            	$("#table_reg").submit();

            }

            console.log(tableName);
        }
    </script>
