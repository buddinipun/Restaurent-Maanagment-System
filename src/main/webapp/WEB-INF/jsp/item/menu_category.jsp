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
                               		<li class="active">Menu / Menu Category</li>
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
                                <strong>Register</strong> Menu Category
                            </div>
                            <div class="card-body">
                               
                                <form:form role="form" class="form-inline" action="menuCategory.reg" method="post"
                                       name="table_reg" id="table_reg"
                                       modelAttribute="addcategory">
                                   
                                   
                                        <div class="col-2 col-md-2">
                                        	<label for="hf-category-name" class=" form-control-label">Category Name</label>
                                        </div>
                                        <div class="col-4 col-md-4">
                                        	<form:input type="text" id="typeName" name="typeName" path ="typeName"
                                        	placeholder="Enter Category Name..." class="form-control" />
                                        </div>
                                  
                                    
                                        <div class="col-2 col-md-2">
                                        	<label for="hf-description" class=" form-control-label">Category Description</label>
                                        </div>
                                        <div class="col-4 col-md-4">
                                        	 <textarea class="form-control" rows="2" name="description"
                                                           id="description"></textarea>
                                        </div>
                                   
	                                <div class="col-8 col-md-8">
                                        	<label for="hf-category-name" class="form-control-label sr-only">Category Name</label>
                                        </div>
                                         <div class="col-4 col-md-4">
		                                <button type="submit" class="btn btn-primary">
		                                    Submit
		                                </button>
		                                <button type="reset" class="btn btn-danger">
		                                    <i class="fa fa-ban"></i> Reset
		                                </button>
		                                </div>
	                              
                                    
                                </form:form>
                            </div>
                            
                            </div>
                  
       
                <div class="row">
                    <div class="col-md-12">
                    
                    
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Registered Categoris</strong>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Category Name</th>
                                        <th>Description</th>
                                        <th>Change</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${summary}" var="summary">
                                        <tr>

                                            
                                           <%--  <td>${summary.itemName}</td> --%>
                                            <td>${summary.typeName}</td>
                                            <td>${summary.description}</td>
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
    
    
      <div class="clearfix"></div>

    <footer class="site-footer">
        <div class="footer-inner bg-white">
            <div class="row">
                <div class="col-sm-6">
                    Copyright &copy; 2020 Apptota soft
                </div>
                <div class="col-sm-6 text-right">
                    Designed by <a href="https://apptota.lk">APPTOTA</a>
                </div>
            </div>
        </div>
    </footer>


    </div><!-- /#right-panel -->

    <!-- Right Panel -->

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
    <script src="resource/static/js/main.js"></script>


</body>
</html>
    
