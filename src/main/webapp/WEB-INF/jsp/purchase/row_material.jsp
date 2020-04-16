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
                                <h1>Purchase</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="page-header float-right">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="#">Dashboard</a></li>
                               		<li class="active">Purchase / Row Material</li>
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
                                <strong>Record </strong>Purchase Item
                            </div>
						<div class="card-body">
						 <form:form role="form" action="material.purchase" method="post"
                                       name="table_reg" id="table_reg"
                                       modelAttribute="updatePurchase">
						<div class ="row">
							<div class="col-lg-12">
								  
                                    
                                     <div class="row form-group">
								  
                                        <div class="col-lg-1"><label for="itemTypeId" class=" form-control-label">Row Material Type</label></div>
                                        <div class="col-lg-4">
                                         <form:select class="form-control" path="idrowMaterial" id="idrowMaterial" data-live-search="true">
                                                <form:option value="NONE"> --SELECT MATERIAL--</form:option>
                                              
										<c:forEach items="${summary}" var="summary">
                                                <form:option value="${summary.idrowMaterial}">${summary.name}</form:option>
                                        </c:forEach>
                                               
										</form:select>
                                        </div>
                                    	
                                    	<div class="col-lg-1"><label for="totalQuantity" class=" form-control-label">Quantity</label></div>
                                        <div class="col-lg-4"><input type="text" id="totalQuantity" name="totalQuantity" placeholder="Enter Quantity" class="form-control"></div>
                                   
                                    </div>
                                  
							
							
								  <div class="row form-group">
                                        <div class="col-md-1"><label for="text-input" class="sr-only form-control-label">Item Price</label></div>
                                 		<div class="col-md-4"><label for="text-input" class="sr-only form-control-label">Item Price</label></div>
                                 		
                                        <div class="col-md-4"><label for="email-input" class=" form-control-label"></label></div>
                                        <div class="col-md-1"><input class="btn btn-info" type="submit" value="Update Purchase"></div>
                                    </div>
							</div>
							</div>
							</form:form>
						</div>
					</div>
				</div>
				
		</div>
		
	 <div class="row">
                    <div class="col-md-12">
                    
                    
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Registered Items</strong>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Material Name</th>
                                        <th>Material Code</th>
                                        <th>Material Type</th>
                                        <th>Minimum Qty</th>
                                         <th>Total Quantity</th>
                                        <th>Description</th>
                                        <th>Change</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${summary}" var="summary">
                                        <tr>

                                            
                                           <%--  <td>${summary.itemName}</td> --%>
                                            <td>${summary.name}</td>
                                            <td>${summary.code}</td>
                                            <td>${summary.type}</td>
                                            <td>${summary.minAmount} - ${summary.measurementUnit}</td>
                                            <td>${summary.totalQuantity}</td>
                                            <td>${summary.description}</td>
                                            <th>
                                            	<button type="submit" class="btn btn-success">Change</button>
                                            </th>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
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



    <!-- Right Panel -->

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
    <script src="../../resource/static/js/main.js"></script>


</body>
</html>



  