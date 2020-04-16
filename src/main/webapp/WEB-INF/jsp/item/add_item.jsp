<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<jsp:include page="../include/headder.jsp" />


<style>


.modal-backdrop {
    z-index: 600;
}


</style>

<!-- Bootstrap -->
<script type="text/javascript" src='https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.3.min.js'></script>
<script type="text/javascript" src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js'></script>
<link rel="stylesheet" href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/css/bootstrap.min.css'
    media="screen" />
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
                               		<li class="active">Menu / menu Item</li>
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
                                <strong>Register </strong>Menu Item
                            </div>
						<div class="card-body">
						 <form:form role="form" action="menuItem.reg" method="post"
                                       name="table_reg" id="table_reg"
                                       modelAttribute="additem">
						<div class ="row">
							<div class="col-lg-12">
								  <div class="row form-group">
								  
                                        <div class="col-lg-1"><label for="itemName_lbl" class=" form-control-label">Item Name</label></div>
                                        
                                        <div class="col-lg-4">
                                        	<form:input type="text" id="itemName" path="itemName" name="itemName" placeholder="Text" class="form-control" />
                                        </div>
                                    	
                                    	<div class="col-lg-1"><label for="itemCode" class=" form-control-label">Menu Item Code</label></div>
                                        <div class="col-lg-4">
                                        	<form:input type="text" id="itemCode" name="itemCode" path="itemCode" placeholder="Enter Email" class="form-control" />
                                        </div>
                                   
                                    </div>
                                    <div class="row form-group">
								  
                                        <div class="col-lg-1"><label for="itemTypeId" class=" form-control-label">Menu Item Type</label></div>
                                        <div class="col-lg-4">
                                         <form:select class="form-control" path="itemTypeId" id="itemTypeId" data-live-search="true">
                                                <form:option value="NONE"> --SELECT Type--</form:option>
                                              
										<c:forEach items="${summary}" var="summary">
                                                <form:option value="${summary.iditemType}">${summary.typeName}</form:option>
                                        </c:forEach>
                                               
										</form:select>
                                        </div>
                                    	
                                    	<div class="col-lg-1"><label for="itemDescription" class=" form-control-label">Description</label></div>
                                        <div class="col-lg-4"><input type="text" id="itemDescription" name="itemDescription" placeholder="Enter Description" class="form-control"></div>
                                   
                                    </div>
                                   <div class="row form-group">
                                        <div class="col-md-1"><label for="text-input" class="form-control-label">Item Price</label></div>
                                 		<div class="col-lg-4"><input type="text" id="itemPrice" name="itemPrice" placeholder="Enter Item Price" class="form-control"></div>
                 
                                        <div class="col-md-4"><label for="email-input" class=" form-control-label"></label></div>
                                        <div class="col-md-1"><input class="btn btn-info" type="submit" value="Add Item"></div>
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
                <div class="content">
            		<div class="animated fadeIn">
                
		       
                    
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Registered Items</strong>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Item Name</th>
                                        <th>Item Code</th>
                                        <th>item Type</th>
                                        <th>Description</th>
                                        <th>Item Price</th>
                                        <th>View Materials</th>
                                        <th>Change</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${items}" var="item">
                                        <tr>

                                            
                                           <%--  <td>${summary.itemName}</td> --%>
                                            <td>${item.itemName}</td>
                                            <td>${item.itemCode}</td>
                                            <td>${item.itemTypeId}</td>
                                            <td>${item.itemDescription}</td>
                                            <td>${item.itemPrice}</td>
                                            <th>
                                            	 <input type="button" id="" value="Materials" class="btn btn-primary" onclick="callMe('${item.iditem}')" >	
                                            </th>
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
</div>
</div>
<!-- Modal Popup -->
<div id="MyPopup" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    &times;</button>
                <h4 class="modal-title">
                </h4>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">
                    Close</button>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    function callMe(itemId) {
        alert(itemId);

        $.ajax({
		    method: "GET",
		    url: "getItemMaterials",
		    data: {itemId: itemId},
		    dataType: "json",
		    success: function (data) {
  
			alert(data.materials.materialName);
			    
		    },
		    error: function (data) { 
		    // console.log("failure" + data);
		  	alert("failure" + JSON.stringify(data));
		    }
		    });
        
        $("#MyPopup").modal("show");

        }
</script>
            
            

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
<%@include file="../include/footer.jsp" %>
    <!-- Scripts -->
   <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
    <script src="../../resource/static/js/main.js"></script> 


</body>
</html>



  