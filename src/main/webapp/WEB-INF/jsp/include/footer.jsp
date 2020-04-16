
<!-- build:js ../assets/js/core.min.js -->
<!-- <spring:url value="/resources/libs/bower/jquery/dist/jquery.js" var="jqueryJS"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/jquery/dist/jquery.js"></script>

<!-- <spring:url value="/resources/libs/bower/jquery-ui/jquery-ui.min.js" var="jqueryMinJS"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/jquery-ui/jquery-ui.min.js"></script>

<!-- <spring:url value="/resources/libs/bower/jQuery-Storage-API/jquery.storageapi.min.js" var="jqueryStorageapi"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/jQuery-Storage-API/jquery.storageapi.min.js"></script>

<!-- <spring:url value="/resources/libs/bower/bootstrap-sass/assets/javascripts/bootstrap.js" var="bootstrapJS"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/bootstrap-sass/assets/javascripts/bootstrap.js"></script>

<!-- <spring:url value="/resources/libs/bower/jquery-slimscroll/jquery.slimscroll.js" var="jquerySlimscroll"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/jquery-slimscroll/jquery.slimscroll.js"></script>

<!-- <spring:url value="/resources/libs/bower/perfect-scrollbar/js/perfect-scrollbar.jquery.js" var="perfectScrollbar"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/perfect-scrollbar/js/perfect-scrollbar.jquery.js"></script>

<!-- <spring:url value="/resources/libs/bower/PACE/pace.min.js" var="paceMin"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/PACE/pace.min.js"></script>

<!-- <spring:url value="/resources/assets/js/library.js" var="libraryJS"/> -->
<script type="text/javascript" src="../../resource/static/js/library.js"></script>

<!-- <spring:url value="/resources/assets/js/plugins.js" var="pluginsJS"/> -->
<script type="text/javascript" src="../../resource/static/js/plugins.js"></script>

<!-- <spring:url value="/resources/assets/js/app.js" var="appJS"/> -->
<script type="text/javascript" src="../../resource/static/js/app.js"></script>


<ul>
    <li class="active"><c:if test="${not empty ErrinsertStatus}">
        <!--<c:out value="${insertStatus}"/> -->
        <script>
            console.log("ErrinsertStatus");
            $('#responseErrvalue').text("${ErrinsertStatus}");
            $('#errorModal').modal('show');

        </script>
    </c:if>
        <c:if test="${not empty insertStatus}">
            <!--<c:out value="${insertStatus}"/> -->
            <script>
                $('#responseSuccvalue').text("${insertStatus}");
                $('#sucessModal').modal('show');

            </script>
        </c:if></li>
</ul>


</body>
</html>