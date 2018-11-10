<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            Materialize.toast('<span>你可以用我方便的管理你的教学活动</span>', 3000);
        }, 5500);
        setTimeout(function() {
            Materialize.toast('<span>要开始添加课程吗.</span><a class="btn-flat yellow-text" href="AddCourse">添加课程<a>', 3000);
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
        $('#addbooks').on('click',function(event) {
            if ($('#addMaters').css('display')=='none') {
              $('#addMaters').css('display','block');
            }else {
              $('#addMaters').css('display','none');
            }

          });
    });

    </script>
</body>

</html>