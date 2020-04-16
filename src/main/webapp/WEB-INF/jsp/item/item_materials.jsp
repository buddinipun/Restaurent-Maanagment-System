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
                               		<li class="active">Menu / Menu Item Row Materials</li>
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
                                <strong>Add </strong> Menu Row Materials
                            </div>
						<div class="card-body">
						
						<div class ="row">
							<div class="col-lg-12">
								  
                                    
                                     <div class="row form-group">
								  
                                        <div class="col-lg-2"><label for="itemTypeId" class=" form-control-label">Row Material Type</label></div>
                                        <div class="col-lg-4">
                                       		  <input id="menuItemPicker" class="form-control" type="text"/>
                                       		  <input id="menuItemId" class="form-control" type="text"/>
                                        </div>
                                    	
                                    	 <div class="col-md-1">
                                    	 	<button type="button" class="btn btn-info" id="getItem"><i class="glyphicon glyphicon-search"></i> Get Item
                                    	 	</button>
                                    	 </div>
                                    </div>
                                  
							</div>
							</div>
						
						</div>
						
				   </div>
				   
				     <div class="row" id="item_materials_tbl">
                    <div class="col-md-12">
                    
                    
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Registered Items</strong>
                        </div>
                        <div class="card-body">
                       <table id="item_materials" data-plugin="DataTable"
						class="table table-striped" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th></th>
								<th>Material Name</th>
								<th>Quantity</th>
							
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" name="chk" /></td>
								<td>
									<div class="col-md-7" class="form-horizontal">
									<select class="form-control degree_accept_id item_code" id="material_id"
											data-live-search="true">
											<option value="NONE">-- SELECT ITEM --</option>
											 <c:forEach items="${materils}" var="materil">
												<option value="${materil.idrowMaterial}">${materil.name}</option>
													
											</c:forEach> 
										</select>
									
									</div>
								</td>
								<td>
								<div class="col-md-5" class="form-horizontal">
								<input type="text" name="quantitytest" class="validate[required,minSize[3]] form-control"
                                                        id="quantity"/>
                                                        
                                
                              
                                </div>
                                </td>
                               </tr>
                               
                               
						</tbody>
					</table>
					
					 <div class="col-10 col-md-10">
					 	    <button type="button" class="btn btn-info" id="add_item" style="float:right" onclick="GetCellValues('item_materials')">Add Row Materials
                            </button>
		                               
		              </div>
					 
                           <br>             
                      <div class="col-8 col-md-8">                   
					  	    <button type="button" class="btn btn-info" id="add_item" onclick="addRow('item_materials')">Add Item Material
                            </button>
                              <button type="button" class="btn btn-danger" id="add_item" onclick="deleteRow('item_materials')">Delete Selected Item
                              </button>
                      </div>
                        	
                        </div>
				  </div>   
			</div>
		</div>
		
	</div>
	</div>
              
     <SCRIPT language="javascript">
     //in
        function addRow(tableID) {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
            var colCount = table.rows[0].cells.length;
            for(var i=0; i<colCount; i++) {
                var newcell = row.insertCell(i);
                newcell.innerHTML = table.rows[1].cells[i].innerHTML;
                //alert(newcell.childNodes);
                switch(newcell.childNodes[0].type) {
                    case "text":
                            newcell.childNodes[0].value = "";
                            break;
                    case "checkbox":
                            newcell.childNodes[0].checked = false;
                            break;
                    case "select-one":
                            newcell.childNodes[0].selectedIndex = 0;
                            break;
                }
            }
        }


   // < -------------------------------------------------             delete order item from table                  ----------------------------------------->
       // in 
        function deleteRow(tableID) {
            try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    if(rowCount <= 1) {
                        alert("Cannot delete all the rows.");
                        break;
                    }
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
            }
            }catch(e) {
                alert(e);
            }
        }
    </SCRIPT>
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
<%@include file="../include/footer.jsp" %>
    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
    <script src="../../resource/static/js/main.js"></script>


</body>
</html>




    <script type="text/javascript">

    // < -------------------------------------------------             save order               ----------------------------------------->
    // on
      $(document).ready(function() {
             $("#item_materials_tbl").hide();
             var priceType;


      });

      // null
        function GetCellValues(dataTable)
        {
            var menuItemId = document.getElementById("menuItemId").value;
			alert(menuItemId);
            var jsonObj = [];
            var jsonString;
            var table = document.getElementById(dataTable);
            for (var r = 1, n = table.rows.length; r < n; r++) {
                var item = {};
                for (var c = 0, m = table.rows[r].cells.length; c < m; c++){
                    if(c == 1){
                         e =table.rows[r].cells[c].getElementsByTagName('select')[0];
                        item ["materialId"] = e.options[e.selectedIndex].value;

                       }

                    else if(c==2){
                        item ["quantity"] = table.rows[r].cells[c].innerHTML;
                        item ["quantity"] = table.rows[r].cells[c].getElementsByTagName('input')[0].value;

                    }
                    

                }
                jsonObj.push(item);
            }
            jsonString = JSON.stringify(jsonObj);
            //alert("Save your data "+ jsonString);

           // null
            $.ajax({
                method: "GET",
                url : "setMaterials.do",
                data:{jsonString:jsonString,menuItemId:menuItemId},
                dataType: "json",
                success: function(data){
                    $("#").html(data);
                   

                    if(data.validated){
							
							
				             alert("Sucess"):
				            
                        }else {
								alert("Error");
						   }


                },
                error:function(data){
                    console.log("failure"+data);
                    alert("failure"+JSON.stringify(data));
                    console.log("failure"+JSON.stringify(data));
                }
            });

        }

    </script>

    <script>

 // < -------------------------------------------------             get customer details                  ----------------------------------------->
    // on
    var customerId;
    $("#getItem").click(function(){
    	
        var menuItemPicker = document.getElementById("menuItemPicker").value;
	
    $.ajax({
    method: "GET",
    url: "../../menu-item/getItemByName",
    data: {menuItemPicker : menuItemPicker},
    dataType: "json",
    success: function (data) {

        $("#item_materials_tbl").show();
        document.getElementById("menuItemId").value = data.item.iditem;
        
    },
    error: function (data) {
    console.log("failure" + data);
  //  alert("failure" + JSON.stringify(data));
    }
    });

    });

    </script>

     <script>

     // on 
  $( function() {

    $( "#menuItemPicker" ).autocomplete({
      source: "../../menu-item/searchItem"
    });
  } );

  

//< -------------------------------------------------             get cost for select item                  ----------------------------------------->
  
 var totalQuotation = 0;
 var itemOldPrice = 0;
  function getItemCost(test) {
//alert(test.value);

 var quantity = test.value;
 //var priceinput = $(test).closest('tr').find('input[name="pricetextmy"]').val(0);
     itemOldPrice = $(test).closest('tr').find('input[name="pricetextmy"]').val();
 var itemId = $(test).closest('tr').find('#item_code option:selected').val();
console.log("itemOldPrice is : " + itemOldPrice);

 if(itemId == 'NONE') {
		alert("please select Item");
		//$(this).closest('tr').find('input[name="quantitytest"]').val() = "";
		
	   }

 else{

	   $.ajax({
		    method: "GET",
		    url: "../../products/product/getItemById",
		    data: {itemId: itemId},
		    dataType: "json",
		    success: function (data) {

		      
			   var Itemprice;
		       var itemTotalPrice;
		       

		       if(priceType == 'distributer') {
		    	   Itemprice = data.item.distributerPrice;
		        	
		            }
		        else if(priceType == 'customer') {
		        	Itemprice = data.item.customerPrice;
		            }

		        else if(priceType == 'dealer') {
		        	Itemprice = data.item.dealerPrice;
		            }

		        else {
		        //	$('#price').attr('readonly',true);
		        	alert("Contact System administrator");
		            }


	           itemTotalPrice = Itemprice * quantity;
	           //priceinput.val(itemTotalPrice);
			 //  console.log("Itemprice is : " + Itemprice);
	           console.log("itemTotalPrice is :  " + itemTotalPrice);
	           //itemOldPrice
	           totalQuotation = totalQuotation - itemOldPrice;
	           totalQuotation = totalQuotation + itemTotalPrice;
	           $(test).closest('tr').find('input[name="pricetextmy"]').val(itemTotalPrice);
	           console.log("totalQuotation is :  " + totalQuotation);
	           document.getElementById('totalQuotationValue').innerHTML = totalQuotation;
	           document.getElementById('totalQuotationValue').style = "color: blue;";
		       
		       
		    },
		    error: function (data) { 
		   // console.log("failure" + data);
		  //  alert("failure" + JSON.stringify(data));
		    }
		    });
		
	   }
 


	  }

//< -------------------------------------------------             get excel                  ----------------------------------------->
  
  
  $('#btn_download_pdf').click(function(){
		var quotationId = document.getElementById('savedQuotationId').value;
		 $.ajax({
			    method: "GET",
			    url: "../../customers/getcustomerbyNic",
			    data: {adUserpicker: adUserpicker},
			    dataType: "json",
			    success: function (data) {

			      
			    },
			    error: function (data) {
			    console.log("failure" + data);
			    alert("failure" + JSON.stringify(data));
			    }
			    });
		
	  });



//< -------------------------------------------------             get pdf                  ----------------------------------------->
  
  
  $('#btn_download_excel').click(function(){

	  
		var quotationId = document.getElementById('savedQuotationId').value;
		
		alert("quotationId is : " + quotationId);
		  $.ajax({
			    method: "GET",
			    url: "../../reports/getquotationReport",
			    data: {quotationId: quotationId, reportType:'excel'},
			    dataType: "json",
			    success: function (data) {
				//alert(data);
			      
			    },
			    error: function (data) {
			   /*  console.log("failure" + data);
			    alert("failure" + JSON.stringify(data)); */
			    }
			    });
		
	  });
  </script>
