<%--
  Created by IntelliJ IDEA.
  User: Dell Precision 7550
  Date: 10/11/2024
  Time: 7:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--  Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang chủ - BookStore</title>
    <link rel="stylesheet" type="text/css" href="css/templatemo_style.css">
</head>
<body>
<!-- Templates from www.stanford.com.vn -->
<div id="templatemo_container">
    <jsp:include page="home/menu.jsp"/>
    <jsp:include page="home/header.jsp"/>

    <div id="templatemo_content">

        <div id="templatemo_content_left">
            <jsp:include page="home/sidebar.jsp"/>
        </div> <!-- end of content left -->

        <div id="templatemo_content_right">
            <div class="templatemo_product_box">
                <h1>Photography  <span>(by Best Author)</span></h1>
                <img src="images/templatemo_image_01.jpg" alt="image" />
                <div class="product_info">
                    <p>Etiam luctus. Quisque facilisis suscipit elit. Curabitur...</p>
                    <h3>$55</h3>
                    <div class="buy_now_button"><a href="subpage.html">Buy Now</a></div>
                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>

            <div class="cleaner_with_width">&nbsp;</div>

            <div class="templatemo_product_box">
                <h1>Cooking  <span>(by New Author)</span></h1>
                <img src="images/templatemo_image_02.jpg" alt="image" />
                <div class="product_info">
                    <p>Aliquam a dui, ac magna quis est eleifend dictum.</p>
                    <h3>$35</h3>
                    <div class="buy_now_button"><a href="subpage.html">Buy Now</a></div>
                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>

            <div class="cleaner_with_height">&nbsp;</div>

            <div class="templatemo_product_box">
                <h1>Gardening <span>(by Famous Author)</span></h1>
                <img src="images/templatemo_image_03.jpg" alt="image" />
                <div class="product_info">
                    <p>Ut fringilla enim sed turpis. Sed justo dolor, convallis at.</p>
                    <h3>$65</h3>
                    <div class="buy_now_button"><a href="subpage.html">Buy Now</a></div>
                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>

            <div class="cleaner_with_width">&nbsp;</div>

            <div class="templatemo_product_box">
                <h1>Sushi Book  <span>(by Japanese Name)</span></h1>
                <img src="images/templatemo_image_04.jpg" alt="image" />
                <div class="product_info">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
                    <h3>$45</h3>
                    <div class="buy_now_button"><a href="subpage.html">Buy Now</a></div>
                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>

            <div class="cleaner_with_height">&nbsp;</div>

            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->

        <div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->

    <jsp:include page="home/footer.jsp"/>
    <!-- end of footer -->
    <!--  Free CSS Template www.templatemo.com -->
</div> <!-- end of container -->
<div align=center>This template  downloaded form <a href='http://www.stanford.com.vn'>Stanford.com.vn</a></div>
</body>
</html>
