<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</section>
                  <!-- END CONTENT -->
                  <!-- //////////////////////////////////////////////////////////////////////////// -->
          </div>
        <!-- END WRAPPER -->
    </div>
    <!-- END MAIN -->



    <!-- //////////////////////////////////////////////////////////////////////////// -->

    <!-- START FOOTER
    <footer class="page-footer">
        <div class="container">

        </div>
        <div class="footer-copyright">
            <div class="container">
                Copyright © 2015   All rights reserved.
                <span class="right"> Design and Developed by  </span>
            </div>
        </div>
    </footer>
     END FOOTER -->


    <!-- ================================================
    Scripts
    ================================================ -->

    <!-- jQuery Library -->
    <script src="js/jquery-1.11.2.min.js"></script>
    <!--materialize js-->
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <!--scrollbar-->
    <script type="text/javascript" src="js/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>


    <!-- chartist -->
    <script type="text/javascript" src="js/plugins/chartist-js/chartist.min.js"></script>

    <!-- chartjs -->
    <script type="text/javascript" src="js/plugins/chartjs/chart.min.js"></script>
    <script type="text/javascript" src="js/plugins/chartjs/chart-script.js"></script>

    <!-- sparkline -->
    <script type="text/javascript" src="js/plugins/sparkline/jquery.sparkline.min.js"></script>
    <script type="text/javascript" src="js/plugins/sparkline/sparkline-script.js"></script>

    <!--jvectormap-->
    <script type="text/javascript" src="js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script type="text/javascript" src="js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script type="text/javascript" src="js/plugins/jvectormap/vectormap-script.js"></script>


    <!--plugins.js - Some Specific JS codes for Plugin Settings-->
    <script type="text/javascript" src="js/plugins.js"></script>
    <!-- Toast Notification -->
    <script type="text/javascript">
    // Toast Notification
    $(window).load(function() {
        setTimeout(function() {
            Materialize.toast('<span>欢迎使用教学管理系统.</span>', 1500);
        }, 3000);
        setTimeout(function() {
            Materialize.toast('<span>你好！尊敬的管理员</span>', 3000);
        }, 5500);
        setTimeout(function() {
            Materialize.toast('<span>这里，你可以对学院、系、教师、学生、课程和教材的基本信息</span>', 3000);
        }, 10000);
        setTimeout(function() {
            Materialize.toast('<span>进行管理</span>', 3000);
        }, 18000);
        $('tr th a').on('click',function(event) {
            console.log($(this).attr("class"));
            console.log($(this).attr("class")=='waves-effect waves-light mdi-hardware-keyboard-arrow-up');
            if ($(this).attr("class")=='waves-effect waves-light mdi-hardware-keyboard-arrow-up') {
              $(this).removeClass('mdi-hardware-keyboard-arrow-up');
              $(this).addClass('mdi-hardware-keyboard-arrow-down');
            }else{
              $(this).removeClass('mdi-hardware-keyboard-arrow-down');
              $(this).addClass('mdi-hardware-keyboard-arrow-up');
            }
            /* Act on the event */
          });
    });

    </script>
</body>

</html>